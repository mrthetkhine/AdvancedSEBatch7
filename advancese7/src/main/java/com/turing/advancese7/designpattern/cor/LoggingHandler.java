package com.turing.advancese7.designpattern.cor;
import java.util.Date;

public class LoggingHandler implements Handler{

	@Override
	public void handle(Request request, Response response) {
		System.out.println(new Date()+"Log "+request.url);
		
	}

}
