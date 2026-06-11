package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//https://codingdojo.org/kata/StringCalculator/
//https://kata-log.rocks/string-calculator-kata
public class StringCalculatorTest {

	@Test
	void testNullCase()
	{
		assertEquals(0,StringCal.sum(null));
		assertEquals(0,StringCal.sum(""));
	}
	@Test
	void testSingleNumber()
	{
		assertEquals(1,StringCal.sum("1"));
		assertEquals(2,StringCal.sum("2"));
		assertEquals(23,StringCal.sum("23"));
		assertEquals(2.3,StringCal.sum("2.3"));
		assertEquals(.3,StringCal.sum(".3"));
		
	}
}
