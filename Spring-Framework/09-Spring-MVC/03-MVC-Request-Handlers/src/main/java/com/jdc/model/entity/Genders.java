package com.jdc.model.entity;

public enum Genders {

	MALE ("Male"),
	FEMALE ("Female"),
	BISEXUAL ("Bisexual");
	
	private String name;
	
	private Genders(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}
