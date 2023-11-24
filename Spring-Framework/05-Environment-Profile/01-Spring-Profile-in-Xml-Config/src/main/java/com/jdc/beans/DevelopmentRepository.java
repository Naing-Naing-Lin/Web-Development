package com.jdc.beans;

public class DevelopmentRepository implements Repository {

	@Override
	public void getMessage() {
		
		System.out.println("Hello from Development Repo");

	}

}
