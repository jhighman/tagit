package me.buildon.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Persona {

	
	public Persona(){
		
	}
	
	public Persona(String name) {
		super();
		this.name = name;
	}

	@Id private String id;
	private String name;
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}

//	public void setTags(List<Tag> tags) {
//		this.tags = tags;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void addTag(String tag){
		if (this.tags == null){
			this.tags = new ArrayList<Tag>();
		}
		if(this.tags.contains(new Tag(tag))){	
		}else{
			this.tags.add(new Tag(tag));
		}
	}
	
}
