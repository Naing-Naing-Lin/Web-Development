package com.jdc.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.jdc.entity.Hero;

public class HeroService {

	private List<Hero> database = new ArrayList<Hero>();
	
	public boolean save(Hero hero) {
		return database.add(hero);
	}
	
	public List<Hero> findAll(){
		return Collections.unmodifiableList(database);
	}
}
