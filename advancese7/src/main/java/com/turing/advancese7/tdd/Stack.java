package com.turing.advancese7.tdd;

public class Stack {

	public static final String STACKUNDERFLOW_EXCEPTION = "Stackunderflow exception";
	public static final String STACKOVERFLOW_EXCEPTION = "Stackoverflow exception";
	int SIZE = 10;
	int top = -1;
	int items[] = new int[SIZE];
	
	public void push(int element) {
		if(top < SIZE-1)
		{
			//System.out.println("Top "+top);
			this.items[++top] = element;
		}
		else
		{
			throw new RuntimeException(STACKOVERFLOW_EXCEPTION);
		}
		
	}

	public int size() {
		return top+1;
	}

	public int pop() {
		if(this.top >= 0)
		{
			return items[this.top--];
		}
		else
		{
			throw new RuntimeException(STACKUNDERFLOW_EXCEPTION);
		}
		
	}

}
