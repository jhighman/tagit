package me.buildon.domain;

public class SkillTag extends ObjectWithId{
    private String person;
    private String tag;

    public SkillTag() {
    }

    public SkillTag(long id,String person, String tag)
    {
        super(id);
        this.person = person;
        this.tag = tag;
    }

	public String getPerson() {
		return person;
	}

	public void setPerson(String person) {
		this.person = person;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}


}
