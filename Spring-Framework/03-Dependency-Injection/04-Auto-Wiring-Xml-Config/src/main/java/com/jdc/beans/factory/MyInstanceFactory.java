package com.jdc.beans.factory;

import com.jdc.beans.MainService;
import com.jdc.beans.MyClient;

public class MyInstanceFactory {

	public MyClient generate(MainService service) {
		MyClient myClient = new MyClient();
		myClient.setMainService(service);
		
		return myClient;
		
	}
}
