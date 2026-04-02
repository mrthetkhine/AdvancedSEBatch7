package com.turing.advancese7.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class IncThread extends Thread{

	Data data;
	ReentrantLock rLock;
	public IncThread(String name,Data data,ReentrantLock rLock)
	{
		super(name);
		this.data = data;
		this.rLock = rLock;
	}
	public void run()
	{
		for(int i=0;i< 100_000;i++)
		{
			System.out.println("Thread "+this.getName() +" i => "+i);
			
			this.rLock.lock();
			this.data.value++;
			this.rLock.unlock();
		}
	}
}
