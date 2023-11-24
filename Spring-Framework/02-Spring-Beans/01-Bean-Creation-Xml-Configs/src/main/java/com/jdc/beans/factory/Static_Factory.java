package com.jdc.beans.factory;

import com.jdc.beans.MyClient;

public class Static_Factory {
	/*
	 * a class has a method that returns an object is known as Factory
	 */

	public static MyClient createFactory() {
		return new MyClient();
	}

	public static MyClient withName(String name) {
		var myClient = new MyClient();
		myClient.setName(name);

		return myClient;
	}

	public static MyClient withPhone(String phone) {
		var myClient = new MyClient();
		myClient.setPhone(phone);

		return myClient;
	}
}
