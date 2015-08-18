package me.buildon.repo;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import me.buildon.domain.Persona;

public interface PersonaCustomOperations {

	public <S extends Persona> S save(S arg0);
	public <S extends Persona> S insert(S arg0);
	
}
