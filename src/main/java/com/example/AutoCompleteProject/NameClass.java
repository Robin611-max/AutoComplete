package com.example.AutoCompleteProject;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NameClass{
	


	@Id
	private String name;

	// Getters and Setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "NameClass [name=" + name + "]";
	}
}
