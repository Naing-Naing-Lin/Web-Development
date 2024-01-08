package com.jdc.mvc.model.entity;

public enum Level {

	BASIC("Basic"), 
	INTERMEDIATE("Intermediate"), 
	ADVANCED("Advanced");
	
	private String level;
	
	private Level(String level) {
		
		this.level = level;
	}
	
	public String getLevel() {
		return level;
	}
}
