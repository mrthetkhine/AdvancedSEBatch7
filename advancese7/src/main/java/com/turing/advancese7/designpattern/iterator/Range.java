package com.turing.advancese7.designpattern.iterator;

import java.util.Iterator;

public class Range implements Iterable<Integer>{
	int from,to;
	
	Range(int from,int to)
	{
		this.from =from;
		this.to = to;
	}

	@Override
	public Iterator<Integer> iterator() {
		
		return new RangeIterator();
	}
	class RangeIterator implements Iterator<Integer>
	{

		int current;
		RangeIterator()
		{
			this.current = from;
		}
		@Override
		public boolean hasNext() {
			
			return this.current< to;
		}

		@Override
		public Integer next() {
			return this.current++;
		}
		
	}
}
