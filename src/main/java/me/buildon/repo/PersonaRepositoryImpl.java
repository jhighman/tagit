package me.buildon.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.buildon.domain.Persona;

@Repository
public class PersonaRepositoryImpl implements PersonaCustomOperations  {
	private static final String PERSONA_SEQ_KEY = "persona";
	

	@Autowired
	private SequenceDAO sequenceDao;

	@Override
	public <S extends Persona> S insert(S arg0) {
		arg0.setPid(sequenceDao.getNextSequenceId(PERSONA_SEQ_KEY));
		
		System.out.println("Overrideing Insert");
		return null;
	}

	
	@Override
	public <S extends Persona> S save(S arg0) {
		arg0.setPid(sequenceDao.getNextSequenceId(PERSONA_SEQ_KEY));
		System.out.println("Overrideing Save");
		return null;
	}

}
