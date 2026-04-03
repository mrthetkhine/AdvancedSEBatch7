package com.turing.advancese7.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TestCase {

	TestCase()
	{
		System.out.println("Test case created");
	}
	@BeforeAll
	//@DisplayName("A special test case")
	static void initAll(TestInfo testInfo) {
		System.out.println("BEFORE ALL ");
	}
	
	@BeforeEach
	void beforeEach()
	{
		System.out.println("Before each");
	}
	@AfterEach
	void afterEach()
	{
		System.out.println("After each");
	}
	@Test
	@DisplayName("A special test case")
	void hello(TestInfo testInfo)
	{
		System.out.println("Hello test case "+testInfo.getDisplayName());
		assertEquals(2,1+1);
	}
	@Test
	void testCase1()
	{
		System.out.println("Test case 1");
		assertTrue(true);
	}
	@Test
	void testCase2()
	{
		System.out.println("Test case 2");
		assertTrue(true);
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("After ALL");
	}
}
