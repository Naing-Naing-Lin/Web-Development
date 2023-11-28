package com.jdc.entity;

public class Hero {

	private String name;
	private HeroType heroType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public HeroType getHeroType() {
		return heroType;
	}

	public void setHeroType(HeroType heroType) {
		this.heroType = heroType;
	}

	public enum HeroType {
		Strength, Agility, Intelligent
	}
}
