package com.restapi.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.restapi.base.TestBase;
import com.restapi.client.Restclient;

public class GetApiTest extends TestBase{
	
	//TestBase testBase;
	TestBase testBase;
	String serviceUrl;
	String apiUrl;
	String finalUrl;
	Restclient restClient;
	

	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException {
		 testBase = new TestBase();
	     serviceUrl = prop.getProperty("URL");
	     apiUrl = prop.getProperty("serviceURL");
	     finalUrl = serviceUrl+apiUrl;  
	     System.out.println(finalUrl);
	    
	}
	
	@Test
	public void getTest() throws ClientProtocolException, IOException {
		    restClient = new Restclient();
		    restClient.get(finalUrl);
	}
}
