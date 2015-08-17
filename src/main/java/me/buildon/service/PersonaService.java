package me.buildon.service;

import me.buildon.domain.Persona;

public interface PersonaService {
	
	long registerPersona(Long id, Persona persona);
	long registerPersona(Persona persona);
	Persona save(Persona persona);
	Persona addTag(Long id, String tag);
	Persona getPersona(String personaName);
	Persona getPersona(Long id);

}
