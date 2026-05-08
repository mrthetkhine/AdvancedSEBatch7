package com.turing.advancese7.designpattern.cor;

public class Request extends HttpMessage {
	String url;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
