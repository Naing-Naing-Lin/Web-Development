package com.jdc.beans;

public class ReleaseRepository implements Repository {

	@Override
	public void getMessage() {
		
		System.out.println("Hello from Release Repo");
	}

}
