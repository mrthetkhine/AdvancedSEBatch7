package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.turing.advancese7.oop.Car;
import com.turing.advancese7.oop.Engine;


public class MockObject extends Engine{
	boolean isStarted = false;
	@Override
	public void start() {
		
		this.isStarted = true;
	}
	
	@Test
	public void testEngineStart()
	{
		
		Car car = new Car(this);
		car.start();
		
		assertTrue(this.isStarted);
	}
}
