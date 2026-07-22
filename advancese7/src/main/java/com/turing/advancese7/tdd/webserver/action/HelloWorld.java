package com.turing.advancese7.tdd.webserver.action;

import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HelloWorld extends HttpServerAction{

	@Override
	public void handle(HttpRequest request, HttpResponse response) {
		System.out.println("HelloWorld action executed");
		response.setBody("Hello World");
		response.setStatusCode("200");
		response.setHeader("Content-Type", "text/html");
		
	}

}
