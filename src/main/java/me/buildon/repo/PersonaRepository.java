package me.buildon.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import me.buildon.domain.Persona;

@RepositoryRestResource(collectionResourceRel = "persona", path = "persona")
public interface PersonaRepository extends MongoRepository<Persona, String> {

	List<Persona> findByName(@Param("name") String name);
	Persona findOneByName(@Param("name") String name);
	Persona findOneByPid(@Param("pid") Long pid);
}
