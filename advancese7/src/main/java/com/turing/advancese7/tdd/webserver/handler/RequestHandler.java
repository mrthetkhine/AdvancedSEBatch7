package com.turing.advancese7.tdd.webserver.handler;

import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public interface RequestHandler {
	void handle(HttpRequest request,HttpResponse response);
}
