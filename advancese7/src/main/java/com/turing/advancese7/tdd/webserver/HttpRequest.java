package com.turing.advancese7.tdd.webserver;

import java.util.HashMap;

public class HttpRequest extends HttpMessage {
	String url;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
}
