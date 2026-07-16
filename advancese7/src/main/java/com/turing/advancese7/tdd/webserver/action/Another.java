package com.turing.advancese7.tdd.webserver.action;

import com.turing.advancese7.tdd.webserver.HttpRequest;
import com.turing.advancese7.tdd.webserver.HttpResponse;

public class Another extends HttpServerAction{

	@Override
	public void handle(HttpRequest request, HttpResponse response) {
		System.out.println("Another action executed");
		response.setBody("Another");
		response.setStatusCode("200");
		response.setHeader("Content-Type", "text/html");
		
	}

}
