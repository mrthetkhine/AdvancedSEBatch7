package com.turing.advancese7.designpattern.command.functional;

public class Receiver {
	Callback callback;
	
	public Receiver(Callback callback)
	{
		this.callback =callback;
	}
	void run()
	{
		this.callback.action();
	}
	
	
}
