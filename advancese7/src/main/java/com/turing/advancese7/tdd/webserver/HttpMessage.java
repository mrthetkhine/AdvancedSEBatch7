package com.turing.advancese7.tdd.webserver;

import java.util.HashMap;

public class HttpMessage {
	String httpMethod;
	String httpVersion;
	
	HashMap<String,String> headers = new HashMap<>();
	String body;
	
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	
	public String getHttpVersion() {
		return httpVersion;
	}
	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}
	public void setHeader(String name,String value)
	{
		this.headers.put(name, value);
	}
	public String getHeader(String name)
	{
		return this.headers.get(name);
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}
