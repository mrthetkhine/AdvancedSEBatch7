package com.turing.advancese7.designpattern.meditator;

public class User implements ChatUser{
	ChatRoom room;
	String id;
	User(String id, ChatRoom room)
	{
		this.id = id;
		this.room = room;
		this.room.addUser(this);
	}


	@Override
	public void send(String message) {
		System.out.println("user "+this.id+" send "+message);
		this.room.send(this, message);
		
	}

	@Override
	public void receive(String message) {
	
		System.out.println(id+ " "+message+" received");
	}
}