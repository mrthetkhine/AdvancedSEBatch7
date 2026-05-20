package com.turing.advancese7.designpattern.strategy;

public class NumberComparatorStrategy implements ComparableStrategy {

	@Override
	public void compare() {
		System.out.println("Compare as number");
	}

}
