package com.turing.advancese7.designpattern.strategy;

public class StringComparatorStrategy implements ComparableStrategy {

	@Override
	public void compare() {
		System.out.println("Compare as string");
	}

}
