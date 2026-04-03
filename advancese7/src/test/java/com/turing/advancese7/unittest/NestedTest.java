package com.turing.advancese7.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class NestedTest {
	@Test
	void testParent()
	{
		System.out.println("parent test case");
	}
	@Nested
	@DisplayName("Subtest")
	class SubTest
	{
		@Test
		public void testSubFeature1()
		{
			System.out.println("Test sub feature");
		}
	}
}
