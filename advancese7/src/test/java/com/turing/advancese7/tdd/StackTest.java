package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


public class StackTest {
	Stack stack = new Stack();

	@Test
	public void testPush()
	{
		
		stack.push(10);
		
		assertEquals(1,stack.size());
		assertEquals(10,stack.pop());
	}
	@Test
	public void testPushMany()
	{
	
		//Act
		stack.push(10);
		stack.push(20);
		
		//Assert
		assertEquals(2,stack.size());
		
		assertEquals(20,stack.pop());
		assertEquals(10,stack.pop());
	}
	@Test
	public void testPushCornerCase()
	{
	
		for(int i=0;i<10;i++)
		{
			stack.push(i);
		}
		assertEquals(10,stack.size());
		
		for(int i=9;i>=0;i--)
		{
			assertEquals(i,stack.pop());
		}
		
	}
	@Test
	public void testPushEdgeCase()
	{
	
		for(int i=0;i<10;i++)
		{
			stack.push(i);
		}
		assertEquals(10,stack.size());
		System.out.println("Done");
		RuntimeException e = assertThrows(RuntimeException.class,()->{
			stack.push(11);
		});
		assertEquals(Stack.STACKOVERFLOW_EXCEPTION,e.getMessage());
	}
	
	@Test
	public void testPopBaseCase()
	{
		stack.push(20);
		
		int size= stack.size();
		
		assertEquals(20,stack.pop());
		assertEquals(size-1,stack.size());
	}
	@Test
	public void testPopMany()
	{
		stack.push(20);
		stack.push(30);
		
		int size= stack.size();
		
		assertEquals(30,stack.pop());
		assertEquals(20,stack.pop());
		assertEquals(size-2,stack.size());
	}
	
	@Test 
	public void testPopEdgeCase()
	{
		RuntimeException e = assertThrows(RuntimeException.class, ()->{
			stack.pop();
		});
		assertEquals(Stack.STACKUNDERFLOW_EXCEPTION,e.getMessage());
	}
}
