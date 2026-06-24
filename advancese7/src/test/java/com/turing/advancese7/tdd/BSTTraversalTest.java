package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

public class BSTTraversalTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	BSTTraversalTest()
	{
		
		/*
		 * 			10
		 * 			/ \
		 * 			5  15
		 * 				/\
		 * 			   13  25
		 * 					/
		 * 					18
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(25);
		tree.insert(13);
		tree.insert(18);
	}
	@Test
	public void testPreoder()
	{
		
		
		//Preorder 
		Iterator<Node> iterator = tree.preorderIterator();
		
		assertEquals(10, iterator.next().value);
		assertEquals(5, iterator.next().value);
		assertEquals(15, iterator.next().value);
		assertEquals(13, iterator.next().value);
		assertEquals(25, iterator.next().value);
		assertEquals(18, iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testInorder()
	{
		
		//In-order 
		Iterator<Node> iterator = tree.inOrderIterator();
		
		assertEquals(5, iterator.next().value);
		assertEquals(10, iterator.next().value);
		assertEquals(13, iterator.next().value);
		assertEquals(15, iterator.next().value);
		assertEquals(18, iterator.next().value);
		assertEquals(25, iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
	@Test
	public void testPost()
	{
		
		//post-order 
		Iterator<Node> iterator = tree.postOrderIterator();
		
		assertEquals(5, iterator.next().value);
		assertEquals(13, iterator.next().value);
		assertEquals(18, iterator.next().value);
		assertEquals(25, iterator.next().value);
		assertEquals(15, iterator.next().value);
		assertEquals(10, iterator.next().value);
		
		assertFalse(iterator.hasNext());
	}
}
