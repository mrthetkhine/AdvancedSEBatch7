package com.turing.advancese7.designpattern.command;

import java.util.ArrayList;
import java.util.List;

public class Invoker {
	List<Command> commands = new ArrayList<Command>();
	
	void addCommand(Command command)
	{
		this.commands.add(command);
	}
	void execute()
	{
		for(Command command :this.commands)
		{
			command.execute();
		}
	}
}
