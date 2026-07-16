package com.turing.advancese7.tdd.webserver.handler;

import com.turing.advancese7.tdd.webserver.HttpRequest;
import com.turing.advancese7.tdd.webserver.HttpResponse;
import com.turing.advancese7.tdd.webserver.action.HttpServerAction;

public class PostHandler implements RequestHandler{

	@Override
	public void handle(HttpRequest request, HttpResponse response) {
		String prefix = "com.turing.advancese7.tdd.webserver.action";
		String actionClassUrl = prefix + (request.getUrl().replace("/", "."));
		try {
			Class clazz = Class.forName(actionClassUrl);
			HttpServerAction action = (HttpServerAction) clazz.newInstance();
			action.handle(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
