package com.turing.advancese7.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Model implements Publisher{

	List<Subscriber> subscribers = new ArrayList<>();
	@Override
	public void attach(Subscriber subscriber) {
		this.subscribers.add(subscriber);
		
	}

	@Override
	public void remove(Subscriber subscriber) {
		this.subscribers.remove(subscriber);
	}

	@Override
	public void change(String message) {
		System.out.println("Model change "+message);
		for(Subscriber sub : this.subscribers)
		{
			sub.update(message);
		}
		
	}

}
