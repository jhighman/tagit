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
	
	public Persona(String name, long pid) {
		super();
		this.name = name;
		this.pid = pid;
	}

	public long getPid() {
		return pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	@Id private String id;
	private long pid; // user assigned identifier
	private String name;
	private List<Tag> tags;

	public List<Tag> getTags() {
		return tags;
	}


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
