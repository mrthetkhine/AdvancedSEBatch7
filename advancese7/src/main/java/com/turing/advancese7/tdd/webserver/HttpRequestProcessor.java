package com.turing.advancese7.tdd.webserver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

import com.turing.advancese7.tdd.webserver.action.HttpServerAction;
import com.turing.advancese7.tdd.webserver.handler.GetHandler;
import com.turing.advancese7.tdd.webserver.handler.HandlerFactory;
import com.turing.advancese7.tdd.webserver.handler.PostHandler;
import com.turing.advancese7.tdd.webserver.handler.RequestHandler;
import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public class HttpRequestProcessor {
	HandlerFactory factory;
	
	public HttpRequestProcessor(HandlerFactory factory)
	{
		this.factory = factory;
	}
	
	public HttpResponse handle(HttpRequest request) {
		HttpResponse response = new HttpResponse();
		response.setHttpVersion(request.getHttpVersion());
		RequestHandler handler = this.factory.getHandler(request.getHttpMethod());
		handler.handle(request, response);
		
		return response;
	}
	
}