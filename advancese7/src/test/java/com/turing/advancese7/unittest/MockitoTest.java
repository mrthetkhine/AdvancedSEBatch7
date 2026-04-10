package com.turing.advancese7.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.timeout;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import com.turing.advancese7.oop.Car;
import com.turing.advancese7.oop.Engine;

public class MockitoTest {
	ArrayList mockedList = mock(ArrayList.class);
	
	@Test
	public void testMockito()
	{
		ArrayList list = mock(ArrayList.class);
		Mockito.when(list.size()).thenReturn(3);
		
		list.add("one");
		list.add("two");
		System.out.println("Size "+list.size());
		assertEquals(3,list.size());
	}
	
	@Test
	public void testInteraction()
	{
		//Arrange
		Engine engine = mock(Engine.class);
		Car car = new Car(engine);
		
		//Act
		car.start();
		verify(engine).start();
		
	}
	@Test
	public void testVerify()
	{
		ArrayList list = mock(ArrayList.class);
		
		list.add("one");
		list.add("two");
		
		list.clear();
		
		verify(list).add("one");
		verify(list).add("two");
		verify(list).clear();
	}
	@Test
	public void testWhen()
	{
		ArrayList list = mock(ArrayList.class);
		
		when(list.get(0)).thenReturn("hello");
		when(list.get(1)).thenReturn(100);
		when(list.get(2)).thenThrow(RuntimeException.class);
		
		assertEquals("hello",list.get(0));
		assertEquals(100,list.get(1));
		
		//System.out.println("get 2"+list.get(2));
		
		assertThrows(RuntimeException.class,()->{
			list.get(2);
		});
	}
	@Test
	public void tesArgument()
	{
		ArrayList list = mock(ArrayList.class);
		when(list.get(anyInt())).thenReturn("element");
		
		assertEquals("element",list.get(1));
		assertEquals("element",list.get(100));
	}
	@Test
	public void testArgumentMatching2()
	{
		
		mockedList.add("hello1");
		verify(mockedList).add(
				argThat((String someString) -> someString.length() > 5));
		
		
	}
	@Test
	public void testTimes()
	{
		mockedList.add("one");
		mockedList.add("two");
		mockedList.add("three");
		
		//mockedList.add("four");
		//mockedList.clear();
		//verify(mockedList,times(2)).add(anyString());
		
		verify(mockedList,never()).clear();
		verify(mockedList,atLeast(2)).add(anyString());
		verify(mockedList,atMost(3)).add(anyString());
	}
	@Test
	public void testDoThrow()
	{
		doThrow(new RuntimeException()).when(mockedList).clear();
		
		assertThrows(RuntimeException.class,()->{
			mockedList.clear();
		});
		
	}
	@Test
	public void testOrder()
	{
		mockedList.add("first");
		mockedList.add("second");
		
		mockedList.clear();
		
		InOrder inOrder = Mockito.inOrder(mockedList);
		inOrder.verify(mockedList).add("first");
		inOrder.verify(mockedList).add("second");
		inOrder.verify(mockedList).clear();
	}
	@Test
	public void testOrderTwoDependency()
	{
		ArrayList firstMock = mock(ArrayList.class);
		ArrayList secondMock = mock(ArrayList.class);
		
		
		firstMock.add("one");
		secondMock.add("one");
		secondMock.add("two");
		
		InOrder inOrder = Mockito.inOrder(firstMock,secondMock);
		inOrder.verify(firstMock).add("one");
		inOrder.verify(secondMock).add("one");
		inOrder.verify(secondMock).add("two");
	}
	@Test
	public void testVerifyNoMore()
	{
		mockedList.add("one");
		//mockedList.add("two");
		
		verify(mockedList).add("one");
		verifyNoMoreInteractions(mockedList);
	}
	@Test
	public void testConsecutiveCall()
	{
		when(mockedList.get(0))
			.thenReturn("hello")
			.thenThrow(new RuntimeException())
			.thenReturn("ok");
		
		assertEquals("hello",mockedList.get(0));
		
		assertThrows(RuntimeException.class,()->{
			mockedList.get(0);
		});
		assertEquals("ok",mockedList.get(0));
	}
	@Test
	public void testReturnWithCallback()
	{
		when(mockedList.get(anyInt()))
		.thenAnswer(
				new Answer()
				{
					public Object answer(InvocationOnMock invocation) {
			             Object[] args = invocation.getArguments();
			             Object mock = invocation.getMock();
			             return "Item " + args[0];
			         }
				}
				);
		assertEquals("Item 1",mockedList.get(1));
		assertEquals("Item 2",mockedList.get(2));
	}
	@Test
	public void testCallRealMethod()
	{
		ArrayList list = new ArrayList();
		List spy = Mockito.spy(list);
		spy.add(1);
		spy.add(2);
		
		doCallRealMethod().when(spy).size();
		
		assertEquals(2,spy.size());
	}
	@Test
	public void testSpy()
	{
	   List list = new LinkedList();
	   List spy = Mockito.spy(list);

	   spy.add("hello");
	   spy.add("first");
	   //optionally, you can stub out some methods:
	   when(spy.size()).thenReturn(100);

	   assertEquals(100,spy.size());
	   assertEquals("hello",spy.get(0));
	}
	@Test
	public void testArgumentCapture()
	{
		 ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		 
		 mockedList.add("one");
		 verify(mockedList).add(argument.capture());
		 
		 assertEquals("one",argument.getValue());
	}
	void delay(long ms)
	{
		try
		{
			Thread.sleep(ms);
		}
		catch(Exception e)
		{
			
		}
	}
	
}
