package com.turing.advancese7.unittest;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Tag;

import static java.time.Duration.ofMillis;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

class Data
{
	int value;
	Data(int value)
	{
		this.value = value;
	}
	public boolean equals(Object a)
	{
		Data another = (Data)a;
		System.out.println("Data.equals");
		return this.value == another.value;
		
	}
	int getDataWithDelay(long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 100;
	}
}
//@TestMethodOrder(OrderAnnotation.class)
public class AssertionDemo {

	@Test
	void testEquals()
	{
		assertEquals("Hello", new String("Hello"));
		Data d1 = new Data(20);
		Data d2 = new Data(20);
		
		assertEquals(d1,d2);
	}
	@Test
	void testMessage()
	{
		assertEquals(2,1+1,"1 +1 should  be 2");
	}
	@Test
	void exceptionTesting() {
		Exception exception = assertThrows(ArithmeticException.class, () ->
			{
				int a =1/0;
			});
		assertEquals("/ by zero", exception.getMessage());
	}
	@Order(2)
	@Test
	void testTimeout()
	{
		Data data =new Data(19);
		int result = assertTimeout(ofMillis(1000),()->{
			//data.getDataWithDelay(1200);
			return data.getDataWithDelay(600);
		});
		assertEquals(100,result);
	}
	@Order(1)
	@Tag("exception")
	@Test
	void exceptionThrowExactlyTesting() {
		Exception exception = assertThrowsExactly(ArithmeticException.class, () ->
			{
				int a =1/0;
			});
		assertEquals("/ by zero", exception.getMessage());
	}
	@Disabled("Disabled until bug #99 has been fixed")
	@Test
	void testNotThrow()
	{
		assertDoesNotThrow(()->{
			System.out.println("Test Not throw");
			//throw new RuntimeException("Test");
		});
	}
	
	
}
