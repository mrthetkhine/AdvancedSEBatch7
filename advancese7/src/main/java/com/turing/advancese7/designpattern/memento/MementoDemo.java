package com.turing.advancese7.designpattern.memento;

public class MementoDemo {
	public static void main(String[]args)
	{
		Originator org = new Originator();
		CareTaker careTaker = new CareTaker(org);
		
		org.changeState("Hello");
		Memento m1 = org.save();
		careTaker.addHistory(m1);
		
		org.changeState("World");
		Memento m2 = org.save();
		careTaker.addHistory(m2);
		
		org.changeState("Nothing");
		
		careTaker.undo();
		careTaker.undo();
		System.out.println(org.state);
		
	}
}
