package com.turing.advancese7.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.stream.Stream;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;



public class ParameterizedTestCase {

	@RepeatedTest(5)
	public void testRepeat()
	{
		System.out.println("Test");
		File file = new File("./data.csv");
		System.out.println("File "+file.getAbsolutePath() + "exist "+file.exists());
	}
	@Test
	public void testAnother()
	{
		System.out.println("One time");
	}
	@ParameterizedTest
	@ValueSource(ints = { 3, 5, 11 })
	void testOdd(int num) {
		assertTrue(num%2!=0);
	}
	@ParameterizedTest
	@CsvSource({ "apple, 5", "banana, 6" })
	void testStringLength(String str, int len)
	{
		assertEquals(len,str.length());
	}
	
	@ParameterizedTest
	@MethodSource("stringProvider")
	void testWithExplicitLocalMethodSource(String argument) {
		System.out.println("String Provider "+argument);
	    assertNotNull(argument);
	}

	static Stream<String> stringProvider() {
	    return Stream.of("apple", "banana");
	}
	@ParameterizedTest
	@CsvFileSource(resources = "./data.csv", numLinesToSkip = 1)
	void testWithCsvFileSourceFromFile(String country, int reference) {
		
		assertNotNull(country);
		assertNotEquals(0, reference);
	}
}
