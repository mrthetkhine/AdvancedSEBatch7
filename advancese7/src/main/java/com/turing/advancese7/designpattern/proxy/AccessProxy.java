package com.turing.advancese7.designpattern.proxy;

public class AccessProxy implements CommandExecutor{
	boolean isAdmin = false;
	CommandExecutor executor = new CommandExecutorImpl();
	
	AccessProxy(String username,String password)
	{
		if(username.equals("admin")&& password.equals("admin"))
		{
			this.isAdmin = true;
		}
	}

	@Override
	public void runCommand(String command) {
		if(this.isAdmin)
		{
			this.executor.runCommand(command);
		}
		else
		{
			if(command.startsWith("rm"))
			{
				throw new RuntimeException("Invalid access right");
			}
			else
			{
				this.executor.runCommand(command);
			}
		}
	}
}
