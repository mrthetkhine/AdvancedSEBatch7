package com.turing.advancese7.designpattern.cor;

public class CorDemo {
	public static void main(String[]args)
	{
		Framework framework = new Framework();
		framework.addHandler(new LoggingHandler());
		framework.addHandler(new AuthHandler());
		framework.addHandler(new RequestController());
		
		Request req = new Request();
		req.setUrl("http://localhost/api");
		req.addHeader("Authorization", "Bearer jwtTken");
		Response res = new Response();
		
		framework.processRequest(req, res);
	}
}
