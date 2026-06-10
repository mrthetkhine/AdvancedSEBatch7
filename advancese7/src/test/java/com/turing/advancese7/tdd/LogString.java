package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LogString extends Algorithm{

	String log = "";
	
	@Override
	public void step1()
	{
		log+="setp1 ";
	}
	@Override
	public void step2()
	{
		log+="step2";
	}
	
	@Test
	public void testCallSequence()
	{
		Algorithm alg = this;
		alg.process();
		
		//System.out.println("Algo log "+this.log);
		assertEquals("setp1 step2", this.log);
	}
}
