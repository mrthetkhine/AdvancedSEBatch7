package com.turing.advancese7.tdd.webserver.action;

import com.turing.advancese7.tdd.webserver.HttpRequest;
import com.turing.advancese7.tdd.webserver.HttpResponse;

public abstract class HttpServerAction {
	public abstract void handle(HttpRequest request,HttpResponse response);
}
