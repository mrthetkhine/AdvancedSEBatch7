package com.turing.advancese7.tdd.webserver.handler;

import java.util.HashMap;

//Flyweight + factory
public class HandlerFactory {
	private static final String POST_METHOD = "POST";
	private static final String GET_METHOD = "GET";
	
	RequestHandler defaultHandler = new GetHandler();
	HashMap<String,RequestHandler> handlers= new HashMap<>();
	
	public HandlerFactory()
	{
		this.handlers.put(GET_METHOD, new GetHandler());
		this.handlers.put(POST_METHOD, new PostHandler());
	}
	public void addHandler(String method,RequestHandler handler)
	{
		this.handlers.put(method, handler);
	}
	public RequestHandler getHandler(String httpMethod) {
		RequestHandler handler = this.handlers.get(httpMethod);
		if(handler == null)
		{
			return defaultHandler; 
		}
		return handler;
	}
}
