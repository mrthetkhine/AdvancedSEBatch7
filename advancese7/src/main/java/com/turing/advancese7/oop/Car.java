package com.turing.advancese7.oop;

public class Car {
	Engine engine;
	
	Car(Engine engine)
	{
		this.engine = engine;
	}
	void start()
	{
		System.out.println("Car start");
		this.engine.start();
	}
}
