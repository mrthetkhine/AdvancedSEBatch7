package com.turing.advancese7.designpattern.decorator;

import java.util.Date;

public class HtmlDecorator implements Logger{
	Logger logger;
	public HtmlDecorator(Logger logger)
	{
		this.logger = logger;
	}
	@Override
	public String log(String message) {
		
		return "<html>"+ logger.log(message) +"</html>";
	}
}
