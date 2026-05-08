package com.turing.advancese7.designpattern.cor;

public class RequestController implements Handler{

	@Override
	public void handle(Request request, Response response) {
		System.out.println("Request is handled by controller");
		
	}

}
