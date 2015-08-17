package me.buildon.service;


import me.buildon.domain.SkillTag;

public interface SkillTagService {
	public SkillTag getSkillTag(long id);

	public long addSkillTag(SkillTag skillTag);

	public long getSkillTagCount();
}
