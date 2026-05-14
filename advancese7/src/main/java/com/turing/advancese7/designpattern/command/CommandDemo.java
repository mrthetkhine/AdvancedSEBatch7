package com.turing.advancese7.designpattern.command;

public class CommandDemo {
	public static void main(String[]args)
	{
		Invoker invoker = new Invoker();
		invoker.addCommand(new EditCommand());
		invoker.addCommand(new CopyCommand());
		invoker.addCommand(new EditCommand());
		
		invoker.execute();
	}
}
