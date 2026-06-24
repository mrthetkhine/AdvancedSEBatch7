package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTest {

	BinarySearch algo = new BinarySearch();
	
	@Test
	public void testBase()
	{
		
		assertEquals(-1,algo.search(null,1));
		assertEquals(-1,algo.search(new int[] {},1));
	}
	
	@Test
	public void testSingleElement()
	{
		int arr[] = {10};
		assertEquals(-1,algo.search(arr,1));
		assertEquals(0,algo.search(arr, 10));
		
		arr= new int[]{20};
		assertEquals(-1,algo.search(arr,1));
		assertEquals(0,algo.search(arr, 20));
	}
	@Test
	public void testTwoElement()
	{
		int arr[] = {10,12};
		assertEquals(-1,algo.search(arr,9));
		assertEquals(0,algo.search(arr, 10));
		assertEquals(1,algo.search(arr, 12));
		assertEquals(-1,algo.search(arr,13));
		assertEquals(-1,algo.search(arr,11));
		
	}
	@Test
	public void testThreeElement()
	{
		int arr[] = {10,12,15};
		assertEquals(-1,algo.search(arr,9));
		assertEquals(0,algo.search(arr, 10));
		assertEquals(1,algo.search(arr, 12));
		assertEquals(2,algo.search(arr,15));
		assertEquals(-1,algo.search(arr,13));
		assertEquals(-1,algo.search(arr,16));
		
	}
	@Test
	public void testMultipleElementEvenSize()
	{
		int arr[] = {10,12,15,16};
		assertEquals(-1,algo.search(arr,-9));
		assertEquals(-1,algo.search(arr,9));
		assertEquals(0,algo.search(arr, 10));
		assertEquals(1,algo.search(arr, 12));
		assertEquals(2,algo.search(arr,15));
		assertEquals(-1,algo.search(arr,13));
		assertEquals(3,algo.search(arr,16));
		assertEquals(-1,algo.search(arr,17));
		
	}
	@Test
	public void testMultipleElementEvenOddSize()
	{
		
		int arr[] = {10,12,15,16,18};
		assertEquals(-1,algo.search(arr,-9));
		assertEquals(-1,algo.search(arr,9));
		assertEquals(0,algo.search(arr, 10));
		assertEquals(1,algo.search(arr, 12));
		assertEquals(2,algo.search(arr,15));
		assertEquals(-1,algo.search(arr,13));
		assertEquals(3,algo.search(arr,16));
		assertEquals(4,algo.search(arr,18));
		assertEquals(-1,algo.search(arr,17));
		
	}
}
