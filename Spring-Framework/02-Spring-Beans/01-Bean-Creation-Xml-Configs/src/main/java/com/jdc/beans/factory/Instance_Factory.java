package com.jdc.beans.factory;

import com.jdc.beans.MyClient;

public class Instance_Factory {

	public MyClient createInstance() {
		return new MyClient();
	}
	
	public MyClient withConstructorArg(String s) {
		var myClient = new MyClient();
		myClient.withPara(s);
		
		return myClient;
	}
}
