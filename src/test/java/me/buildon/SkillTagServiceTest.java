package me.buildon;

import org.junit.Assert;
import org.junit.Test;

import me.buildon.domain.SkillTag;
import me.buildon.service.SkillTagService;
import me.buildon.service.SkillTagServiceImpl;

public class SkillTagServiceTest {

	private SkillTagService service = new SkillTagServiceImpl();
	
	
	@Test
	public void testgetSkillService() {
		Assert.assertEquals(service.getSkillTagCount(), 2);
	}

	@Test
	public void testgetAddService() {
		service.addSkillTag(new SkillTag(3, "Aaron", "Scrum"));
		Assert.assertEquals(service.getSkillTagCount(), 3);
	}
	
}
