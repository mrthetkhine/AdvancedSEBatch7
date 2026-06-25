package com.turing.advancese7.tdd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {
	BinarySearchTree tree = new BinarySearchTree();
	
	@Test
	public void testBaseCase()
	{
		
		tree.insert(10);
		
		assertEquals(10,tree.getRoot().getValue());
	}

	@Test
	public void testLeftInsertCase()
	{
		/*
		 * 			10
		 * 			/
		 * 			5
		 * */
		
		tree.insert(10);
		tree.insert(5);
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		
		assertEquals(5,root.getLeft().getValue());
	}
	@Test
	public void testRightInsertCase()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  15
		 * */
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		assertEquals(5,root.getLeft().getValue());
		assertEquals(15,root.getRight().getValue());
	}
	@Test
	public void testRightInsertSecondLevelCase()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  15
		 * 				\
		 * 				25
		 * */
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(25);
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		assertEquals(5,root.getLeft().getValue());
		assertEquals(15,root.getRight().getValue());
		
		Node right = root.getRight();
		assertEquals(25,right.getRight().getValue());
		
	}
	@Test
	public void testRightInsertSecondLevelCase2()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  15
		 * 				/\
		 * 			   13  25
		 * */
		
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(25);
		tree.insert(13);
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		assertEquals(5,root.getLeft().getValue());
		assertEquals(15,root.getRight().getValue());
		
		Node right = root.getRight();
		assertEquals(25,right.getRight().getValue());
		assertEquals(13,right.getLeft().getValue());
		
	}
	@Test
	public void testRightInsertThirdLevelCase()
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
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		assertEquals(5,root.getLeft().getValue());
		assertEquals(15,root.getRight().getValue());
		
		Node right = root.getRight();
		Node secondRight = right.getRight();
		assertEquals(18,secondRight.getLeft().getValue());
		
		
	}
	@Test
	public void testSkewRight()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			  15
		 * 				/\
		 * 			      25
		 * 					/
		 * 					 30	
		 * */
		
		tree.insert(10);
		tree.insert(15);
		tree.insert(25);
		tree.insert(30);
	
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		assertEquals(15,root.getRight().getValue());
		
		
		Node right = root.getRight();
		Node secondRight = right.getRight();
		assertEquals(25,secondRight.getValue());
		assertEquals(30,secondRight.getRight().getValue());
		
		
	}
	@Test
	public void testSkewLeft()
	{
		/*
		 * 			20
		 * 			/ \
		 * 		  18
		 *        /
		 *       16
		 *       /
		 *      15  
		 * */
		
		tree.insert(20);
		tree.insert(18);
		tree.insert(16);
		tree.insert(15);
	
		
		Node root = tree.getRoot();
		assertEquals(20,root.getValue());
		assertEquals(18,root.getLeft().getValue());
		
		
		Node left = root.getLeft();
		Node secondLeft = left.getLeft();
		assertEquals(16,secondLeft.getValue());
		assertEquals(15,secondLeft.getLeft().getValue());
		
		
	}
	@Test
	public void testSearch()
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
		
		Node node = tree.search(10);
		assertEquals(10,node.getValue());
		
		node = tree.search(11);
		assertNull(node);
		
		node = tree.search(15);
		assertEquals(15,node.getValue());
		
		node = tree.search(25);
		assertEquals(25,node.getValue());
		
		node = tree.search(13);
		assertEquals(13,node.getValue());
		
		node = tree.search(12);
		assertNull(node);
		
		node = tree.search(18);
		assertEquals(18,node.getValue());
	}
	@Test
	public void testLeafRoot()
	{
		/*
		 * 			10
		 * 		
		 * */
		tree.insert(10);
		tree.delete(10);
		
		Node root = tree.getRoot();
		assertNull(root);
		
		Node node = tree.search(10);
		assertNull(node);
	}
	@Test
	public void testLeafLeftChild()
	{
		/*
		 * 			10
		 * 			/
		 * 			5
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		
		tree.delete(5);
		
		
		Node node = tree.search(5);
		assertNull(node);
	}
	@Test
	public void testLeafRightChild()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5 15
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		
		tree.delete(15);
		
		
		Node node = tree.search(15);
		assertNull(node);
	}
	
	@Test
	public void testMultiLevelLeafRightChild()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5 15
		 * 			  / \
		 * 			13	25	
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(13);
		tree.insert(25);
		
		tree.delete(25);
		
		
		Node node = tree.search(25);
		assertNull(node);
	}
	@Test
	public void testMultiLevelLeafLeftChild()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5 15
		 * 			  / \
		 * 			13	25	
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(13);
		tree.insert(25);
		
		tree.delete(13);
		
		
		Node node = tree.search(13);
		assertNull(node);
	}
	@Test
	public void testOneChildLeft()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		
		
		tree.delete(10);
		
		
		Node node = tree.search(10);
		assertNull(node);
		
		node = tree.search(5);
		assertEquals(5,node.getValue());
	}
	@Test
	public void testOneChildRight()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			  18	
		 * 		
		 * */
		tree.insert(10);
		tree.insert(18);
		
		
		tree.delete(10);
		
		
		Node node = tree.search(10);
		assertNull(node);
		
		node = tree.search(18);
		assertEquals(18,node.getValue());
	}
	@Test
	public void testTwoChildBaseCase()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  15	
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		
		
		tree.delete(10);
		
		/*
		 * 			15
		 * 			/ \
		 * 			5 	
		 * 		
		 * */
		Node node = tree.search(10);
		assertNull(node);
		
		Node root = tree.getRoot();
		assertEquals(15,root.getValue());
		
	
		assertEquals(5,root.getLeft().getValue());
		assertNull(root.getRight());
	}
	@Test
	public void testTwoChildSkweCase()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  15
		 * 				/
		 * 			  13
		 * 			 /
		 * 			12
		 * 			/
		 * 		  11				
		 * 		
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(13);
		tree.insert(12);
		tree.insert(11);
		
		tree.delete(10);
		
		/*
		 * 			11
		 * 			/ \
		 * 			5  15
		 * 				/
		 * 			  13
		 * 			 /
		 * 			12
		 * 			/
		 * 		 
		 * 		
		 * */
		Node node = tree.search(10);
		assertNull(node);
		
		Node root = tree.getRoot();
		assertEquals(11,root.getValue());
		
		node = tree.search(12);
		assertNull(node.getLeft());
	}
	@Test
	public void testTwoChildAnotherLevel()
	{
		/*
		 * 			10
		 * 			/ \
		 * 			5  15
		 * 				/\
		 * 			  13  25
		 * 				 /
		 * 				18
		 * */
		tree.insert(10);
		tree.insert(5);
		tree.insert(15);
		tree.insert(13);
		tree.insert(25);
		tree.insert(18);
		
		tree.delete(15);
		
		/*
		 * 			10
		 * 			/ \
		 * 			5  18
		 * 				/\
		 * 			  13  25
		 * 				
		 * 		 
		 * 		
		 * */
		Node node = tree.search(15);
		assertNull(node);
		
		Node root = tree.getRoot();
		assertEquals(10,root.getValue());
		
		assertEquals(18,root.getRight().getValue());
		
		node = tree.search(25);
		assertNull(node.getLeft());
	}
}
