package com.turing.advancese7.designpattern.decorator;
import java.util.Date;

public class TimeDecorator implements Logger{
	Logger logger;
	public TimeDecorator(Logger logger)
	{
		this.logger = logger;
	}
	@Override
	public String log(String message) {
		
		return new Date()+ logger.log(message);
	}
}
