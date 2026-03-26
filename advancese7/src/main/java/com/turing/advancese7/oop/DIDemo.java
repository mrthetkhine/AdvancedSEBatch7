package com.turing.advancese7.oop;

public class DIDemo {
	public static void main(String[]args)
	{
		Engine engine = new ElectricEngine();
		Car car = new Car(engine);
		car.start();
	}
}
