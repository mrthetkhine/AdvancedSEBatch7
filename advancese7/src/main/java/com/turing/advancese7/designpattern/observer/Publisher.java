package com.turing.advancese7.designpattern.observer;

public interface Publisher {
	void attach(Subscriber subscriber);
	void remove(Subscriber subscriber);
	void change(String message);
}
