package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

//https://codingdojo.org/kata/StringCalculator/
//https://kata-log.rocks/string-calculator-kata
public class StringCalculatorTest {

	StringCal cal = new StringCal();
	@Test
	void testNullCase()
	{
		assertEquals("0",cal.sum(null));
		assertEquals("0",cal.sum(""));
	}
	@Test
	void testSingleNumber()
	{
		assertEquals("1",cal.sum("1"));
		assertEquals("2",cal.sum("2"));
		assertEquals("23",cal.sum("23"));
		assertEquals("2.3",cal.sum("2.3"));
		assertEquals("0.3",cal.sum(".3"));
		
	}
	
	@Test
	void testMultipleNumber()
	{
		assertEquals("6",cal.sum("1\n2,3"));
		
		assertEquals("Number expected but \n"
				+ " found at position 6",cal.sum("175.2,\n35"));
				
		assertEquals("Number expected but EOF found.",cal.sum("1,3,"));
	}
	@Test
	void testCustomSeperator()
	{
		assertEquals("3",cal.sum("//;\n1;2"));
		assertEquals("6",cal.sum("//|\n1|2|3"));
		assertEquals("5",cal.sum("//sep\n2sep3"));
		assertEquals("; expected but found , at position 3",cal.sum("//|\n1|2,3"));
	}
}
