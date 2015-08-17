package me.buildon.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import me.buildon.domain.SkillTag;

@Named("skillTagService")
public class SkillTagServiceImpl implements SkillTagService{

    private static Logger logger= LoggerFactory.getLogger(SkillTagServiceImpl.class);
    private AtomicInteger atomicInteger=new AtomicInteger(0);

    public SkillTagServiceImpl()
    {
        init();
    }

    // In-memory list
    private List<SkillTag> skillTags = new ArrayList<>();

    private void init()
    {
        addSkillTag("Jeff","Dev");
        addSkillTag("Rama","Ops");
    }

    public SkillTag getSkillTag(long id) {
        logger.info("Retrieving id {}",id);
        for (SkillTag skillTag : skillTags) {
            if (skillTag.getId()==id)
            {
                return skillTag;
            }
        }
        return null;
    }

    public long addSkillTag(SkillTag skillTag)
    {
        int idTodSet=atomicInteger.getAndIncrement();
        skillTag.setId(idTodSet);
        skillTags.add(skillTag);
        return idTodSet;
    }

    public long addSkillTag(String person, String tag) {
    	SkillTag skillTag = new SkillTag(-1, person, tag);
        return addSkillTag(skillTag);
    }

    public long getSkillTagCount() {
        return skillTags.size();
    }

}


