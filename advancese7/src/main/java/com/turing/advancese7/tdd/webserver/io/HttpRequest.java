package com.turing.advancese7.tdd.webserver.io;

import java.util.HashMap;

public class HttpRequest extends HttpMessage {
	String url;
	String httpMethod;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(String httpMethod) {
		this.httpMethod = httpMethod;
	}
	
}
