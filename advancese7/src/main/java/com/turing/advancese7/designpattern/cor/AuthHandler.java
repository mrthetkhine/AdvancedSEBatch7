package com.turing.advancese7.designpattern.cor;

public class AuthHandler implements Handler{

	@Override
	public void handle(Request request, Response response) {
		String token = request.getHeader("Authorization");
		if(token ==null)
		{
			throw new RuntimeException("No Authorization header");
		}
		else
		{
			System.out.println("Auth ok");
		}
	}

}
