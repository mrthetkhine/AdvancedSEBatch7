package com.turing.advancese7.designpattern.meditator;

public class MeditatorDemo {
	public static void main(String[]args)
	{
		ChatRoom room = new ChatRoom();
		User user1 = new User("1",room);
		User user2 = new User("2",room);
		User user3 = new User("3",room);
		
		user1.send("Hello");
	}
}
