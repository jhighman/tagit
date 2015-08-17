package me.buildon.controller;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.buildon.domain.Persona;
import me.buildon.service.PersonaService;

@RestController
@RequestMapping("/api")
public class ApiController {

    private PersonaService personaService;
    

    private Logger logger=LoggerFactory.getLogger(PersonaService.class);


    //Note: The @Named("personaService") is not required in this example (as there only instance of BookService around)
    @Inject
    public ApiController(@Named("personaService") PersonaService skillTagService )
    {
        this.personaService=skillTagService;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Persona getPersona(@PathVariable("id") Long id) {
        logger.debug("Provider has received request to get person with id: " + id);
        
        return personaService.getPersona(id);
    }

    @RequestMapping(value = "/add",  method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Long registerPersona(@RequestBody Persona persona)
    {
        return personaService.registerPersona(persona);
    }
}
