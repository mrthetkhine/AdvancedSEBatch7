package com.turing.advancese7.designpattern.proxy;

public class CommandExecutorImpl implements CommandExecutor{

	@Override
	public void runCommand(String command) {
		System.out.println("execute command "+command);
		
	}

}
