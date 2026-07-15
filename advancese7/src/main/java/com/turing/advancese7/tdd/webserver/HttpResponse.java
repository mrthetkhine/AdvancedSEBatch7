package com.turing.advancese7.tdd.webserver;

import java.util.HashMap;

public class HttpResponse extends HttpMessage{
	
	HashMap<String,String> statusCodeMapping = new HashMap<>();
	
	String statusCode;
	String statusCodeDescription;
	
	HttpResponse()
	{
		statusCodeMapping.put("200", "OK");
		statusCodeMapping.put("201", "Created");
		statusCodeMapping.put("400", "Bad Request");
		statusCodeMapping.put("404", "Not Found");
		statusCodeMapping.put("500", "Internal Server Error");
	}
	
	
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
		this.statusCodeDescription = this.statusCodeMapping.get(statusCode);
	}
	public String getStatusCodeDescription() {
		return statusCodeDescription;
	}
	
	
}
