package com.jdc.beans;

public class DefaultRepository implements Repository{

	@Override
	public void getMessage() {
		
		System.out.println("Hello from Default Repo");
		
	}

}
