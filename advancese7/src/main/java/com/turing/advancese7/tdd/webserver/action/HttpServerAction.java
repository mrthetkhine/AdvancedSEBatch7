package com.turing.advancese7.tdd.webserver.action;

import com.turing.advancese7.tdd.webserver.io.HttpRequest;
import com.turing.advancese7.tdd.webserver.io.HttpResponse;

public abstract class HttpServerAction {
	public abstract void handle(HttpRequest request,HttpResponse response);
}
