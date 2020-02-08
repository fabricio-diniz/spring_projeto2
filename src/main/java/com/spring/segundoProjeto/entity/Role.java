package com.spring.segundoProjeto.entity;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

@Document

public class Role {
	
	@Id
	private String id;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
