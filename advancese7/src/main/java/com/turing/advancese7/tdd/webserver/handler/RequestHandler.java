package com.turing.advancese7.tdd.webserver.handler;

import com.turing.advancese7.tdd.webserver.HttpRequest;
import com.turing.advancese7.tdd.webserver.HttpResponse;

public interface RequestHandler {
	void handle(HttpRequest request,HttpResponse response);
}
