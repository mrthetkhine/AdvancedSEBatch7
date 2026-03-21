package com.turing.advancese7.tdd;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StackTest {

	@Test
	public void testPush()
	{
		Stack stack = new Stack();
	
		stack.push(10);
		
		assertEquals(1,stack.size());
		assertEquals(10,stack.pop());
	}
}
