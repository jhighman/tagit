package me.buildon.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;


@JsonIgnoreProperties(ignoreUnknown = true)
public @Data class Person {

	private long pid; // user assigned identifier
	private String name;
	
}
