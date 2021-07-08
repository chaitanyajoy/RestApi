package com.restapi.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class Restclient {
	
	//GET Method
	public void get(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(url); //http get request
		CloseableHttpResponse closeableResponse = httpclient.execute(httpget);
		
		//Status Code
		int statusCode = closeableResponse.getStatusLine().getStatusCode();
		System.out.println("Status code: "  + statusCode);
		
		//JSOn String
		String responseString = EntityUtils.toString(closeableResponse.getEntity(),"UTF-8");		
		JSONObject responseJson= new JSONObject(responseString);
		System.out.println("response JSON from API :"+responseJson);
		
		//All Headers
		Header[] headerArray = closeableResponse.getAllHeaders();		
		HashMap<String,String> allHeaders = new HashMap<String,String>();		
		for(Header header : headerArray) {
			allHeaders.put(header.getName(), header.getValue());			
		}
		
		System.out.println("Headers Array-->"+allHeaders);
		
	}
	
	
}
