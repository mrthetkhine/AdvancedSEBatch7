package com.turing.advancese7.tdd.webserver.io;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class HttpMessage {
	
	String httpVersion;
	
	LinkedHashMap<String,String> headers = new LinkedHashMap<>();
	String body;
	
	
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
	public HashMap<String, String> getHeaders() {
		return headers;
	}
	public void setHeaders(LinkedHashMap<String, String> headers) {
		this.headers = headers;
	}
	
}
