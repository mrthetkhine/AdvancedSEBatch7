package com.turing.advancese7.designpattern.meditator;
import java.util.*;

public class ChatRoom {
	List<ChatUser> users = new ArrayList<>();
	
	void addUser(ChatUser user)
	{
		this.users.add(user);
	}
	void send(ChatUser sender,String message)
	{
		for(ChatUser user: this.users)
		{
			if(user!= sender)
			{
				user.receive(message);
			}
		}
	}
}
