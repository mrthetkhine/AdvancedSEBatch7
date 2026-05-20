package com.turing.advancese7.designpattern.memento;

public class Originator {
	String state;
	
	void changeState(String state)
	{
		this.state = state;
	}
	Memento save()
	{
		return new Memento(this.state);
	}
	void restore(Memento memento)
	{
		this.state = memento.state;
	}
}
