package com.jdc.beans;

public class MyClient {
	
	private String name;
	private int age;
	private String phone;

	public MyClient() {
	}

	/*
	 * That's why we need factory pattern in java We cannot overload method when
	 * both constructor name and parameter datatype are same
	 */

//	public MyClient(String name) {
//		this.name = name;
//	}
//	
//	public MyClient(String phone) {
//		this.phone = phone;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void sayHello() {
		System.out.println("Hello Spring Bean by XML Based");
	}

	public void withPara(String s) {
		System.out.println(s);
	}

}
