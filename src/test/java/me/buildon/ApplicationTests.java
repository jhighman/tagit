package me.buildon;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.buildon.Application;
import me.buildon.domain.Persona;
import me.buildon.repo.PersonaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	@Inject
	PersonaRepository personaRepository;
	
	
	@Test
	public void contextLoads() {
	}

	@Test
	public void testPersonaRepository(){
		List<Persona> p = personaRepository.findByName("Spiderman");
		Assert.assertEquals(1, p.size());
		Persona persona = personaRepository.findOneByName("Spiderman");
		Assert.assertEquals("Spiderman", persona.getName());
		persona.addTag("Superhero");
		personaRepository.save(persona);
		persona = personaRepository.findOneByName("Spiderman");
		Assert.assertEquals(2,persona.getTags().size());
	}
	
}
