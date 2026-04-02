package com.turing.advancese7.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class MutualExclusionDemo {

	public static void main(String[]args)
	{
		ReentrantLock lock = new ReentrantLock();
		Data data = new Data();
		
		IncThread t1 = new IncThread("One",data,lock);
		IncThread t2 = new IncThread("Two",data,lock);
		IncThread t3 = new IncThread("Three",data,lock);
		
		t1.start();
		t2.start();
		t3.start();
		
		try
		{
			t1.join();
			t2.join();
			t3.join();
			
			System.out.println("Data value "+data.value);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
