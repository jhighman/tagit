package me.buildon.repo;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import me.buildon.domain.Persona;
import me.buildon.repo.helpers.SequenceDAO;

@Repository
public class PersonaRepositoryImpl implements PersonaCustomOperations  {
	private static final String PERSONA_SEQ_KEY = "persona";
	
	
	@Inject
	private MongoTemplate mongoTemplate;
	

	@Autowired
	private SequenceDAO sequenceDao;
	
	
	@Override
	public <S extends Persona> S insert(S persona) {
		persona.setPid(sequenceDao.getNextSequenceId(PERSONA_SEQ_KEY));
		
		System.out.println("Overrideing Insert");
		mongoTemplate.save(persona);
		return persona;
	}

	
	@Override
	public <S extends Persona> S save(S persona) {
		if (alreadyExists(persona)){
			return persona;
		}
		persona.setPid(sequenceDao.getNextSequenceId(PERSONA_SEQ_KEY));
		mongoTemplate.save(persona);
		return persona;
	}

	private boolean alreadyExists(Persona persona){
		boolean result = false;
		Query query = new Query(Criteria.where("name").is(
				persona.getName()));
		long c = mongoTemplate.count(query, Persona.class,
				PERSONA_SEQ_KEY);
		if(c>0){
			result = true;
		} 
		return result;
	}
	
	
}
