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

import me.buildon.domain.ObjectWithId;
import me.buildon.domain.SkillTag;
import me.buildon.service.SkillTagService;

@RestController
@RequestMapping("/skillTag")
public class SkillTagRestController {

    private SkillTagService skillTagService;

    private Logger logger=LoggerFactory.getLogger(SkillTagService.class);


    //Note: The @Named("skillTagService") is not required in this example (as there only instance of BookService around)
    @Inject
    public SkillTagRestController(@Named("skillTagService") SkillTagService skillTagService )
    {
        this.skillTagService=skillTagService;
    }


    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public SkillTag getBook(@PathVariable("id") Long id) {
        logger.debug("Provider has received request to get person with id: " + id);
        
        return skillTagService.getSkillTag(id);
    }

    @RequestMapping(value = "/add",  method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ObjectWithId addBook(@RequestBody SkillTag skillTag)
    {
        return new ObjectWithId(skillTagService.addSkillTag(skillTag));
    }
}
