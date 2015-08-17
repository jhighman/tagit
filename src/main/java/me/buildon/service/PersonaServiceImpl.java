package me.buildon.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import me.buildon.domain.Persona;
import me.buildon.repo.PersonaRepository;

@Named("personaService")
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	@Override
	public long registerPersona(Long id, Persona persona) {
		persona.setPid(id);
		Persona personaExistsByPid = personaRepository.findOneByPid(id);
		if(personaExistsByPid != null){
		   // log update
		}
		personaRepository.save(persona);
		return id;
	}

	@Override
	public long registerPersona(Persona persona) {
		if(persona.getPid() == 0){
			persona.setPid(1);
		}
		personaRepository.save(persona);
		return persona.getPid();
	}

	@Override
	public Persona save(Persona persona) {
		personaRepository.save(persona);
		return persona;
	}

	@Override
	public Persona addTag(Long id, String tag) {

		Persona persona = personaRepository.findOneByPid(id);
		if(persona != null){
			persona.addTag(tag);	
		}
		return personaRepository.findOneByPid(id);
	}

	@Override
	public Persona getPersona(String personaName) {
		return personaRepository.findOneByName(personaName);
	}

	@Override
	public Persona getPersona(Long id) {
		return personaRepository.findOneByPid(id);
	}

}
