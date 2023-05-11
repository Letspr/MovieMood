package com.example.demo.models.json;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ImdbObjetoRepetido implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	
	public ImdbObjetoRepetido() {
	}
	
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

	@Override
	public String toString() {
		return "ImdbObjetoRepetido [id=" + id + ", name=" + name + "]";
	}
		
	
}
