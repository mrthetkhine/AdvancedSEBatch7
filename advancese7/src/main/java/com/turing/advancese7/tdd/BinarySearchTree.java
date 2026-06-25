package com.turing.advancese7.tdd;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BinarySearchTree {

	List<Node> nodes = new ArrayList<>();
	Node root;
	public void insert(int value) {
		
		Node newNode = new Node(value);
		if(root == null)
		{
			root = newNode;
		}
		else
		{
			Node current = this.root;
			Node previous = null;
			while(current != null)
			{
				int nodeValue = current.getValue();
				previous = current;
				if(nodeValue < value)
				{
					current = current.getRight();	
				}
				else 
				{
					current = current.getLeft();
				}
			}
			if(previous.value < value)
			{
				previous.setRight(newNode);
			}
			else
			{
				previous.setLeft(newNode);
			}
			
		}
		
	}

	public Node getRoot() {
		
		return this.root;
	}

	
	public Node search(int value) {
		Node current = this.root;
		while(current != null)
		{
			int nodeValue = current.getValue();
			
			if(nodeValue == value)
			{
				return current;
			}
			else if(nodeValue < value)
			{
				current = current.getRight();	
			}
			else 
			{
				current = current.getLeft();
			}
		}
		return null;
	}

	/*
	 * Root , left, right
	 * */
	void preOrder(Node node)
	{
		//Root
		//System.out.println("Node "+node.getValue());
		this.nodes.add(node);
		if(node.getLeft() !=null)
		{
			this.preOrder(node.getLeft());
		}
		if(node.getRight() != null)
		{
			this.preOrder(node.getRight());
		}
	}
	public Iterator<Node> preorderIterator() {
		
		return new PreorderIterator();
	}
	class PreorderIterator implements Iterator<Node>
	{

		int index =0;
		PreorderIterator()
		{
			nodes = new ArrayList<>();
			preOrder(root);
		}
		@Override
		public boolean hasNext() {
			
			return index < nodes.size();
		}

		@Override
		public Node next() {
			return nodes.get(index++);
		}
		
	}
	/*
	 *  , left,Root, right
	 * */
	void inOrder(Node node)
	{
		//Root
		//System.out.println("Node "+node.getValue());
		
		if(node.getLeft() !=null)
		{
			this.inOrder(node.getLeft());
		}
		this.nodes.add(node);
		if(node.getRight() != null)
		{
			this.inOrder(node.getRight());
		}
	}
	public Iterator<Node> inOrderIterator() {
		
		return new InOrderIterator();
	}
	class InOrderIterator implements Iterator<Node>
	{

		int index =0;
		InOrderIterator()
		{
			nodes = new ArrayList<>();
			inOrder(root);
		}
		@Override
		public boolean hasNext() {
			
			return index < nodes.size();
		}

		@Override
		public Node next() {
			return nodes.get(index++);
		}
		
	}
	/*
	 *  , left, right,Root
	 * */
	void postOrder(Node node)
	{
		//Root
		//System.out.println("Node "+node.getValue());
		
		if(node.getLeft() !=null)
		{
			this.postOrder(node.getLeft());
		}
		
		if(node.getRight() != null)
		{
			this.postOrder(node.getRight());
		}
		this.nodes.add(node);
	}
	public Iterator<Node> postOrderIterator() {
		
		return new PostOrderIterator();
	}
	class PostOrderIterator implements Iterator<Node>
	{

		int index =0;
		PostOrderIterator()
		{
			nodes = new ArrayList<>();
			postOrder(root);
		}
		@Override
		public boolean hasNext() {
			
			return index < nodes.size();
		}

		@Override
		public Node next() {
			return nodes.get(index++);
		}
		
	}
	public void delete(int value) {
		if(isRootWithNoChild(value))
		{
			this.root = null;
		}
		else
		{
			Node parent = null;
			Node current = this.root;
			while(current != null)
			{
				int nodeValue = current.getValue();
				
				if(nodeValue == value)
				{
					if(current.isLeaf())//Case I ,Leaf
					{
						deleteLeafCase(value, parent);
						return;
					}
					//Case II,one child
					else if(current.haveOneChild())
					{
						deleteOneChildCase(current);
						return;
					}
					else//Case III,two child, replace with in-order successor
					{
						deleteTwoChildCase(current);
					}
					
				}
				else if(nodeValue < value)
				{
					parent = current;
					current = current.getRight();	
				}
				else 
				{
					parent = current;
					current = current.getLeft();
				}
			}
			
		}
		
	}

	private void deleteTwoChildCase(Node current) {
		Node successor = current.getRight();
		
		while(successor.getLeft() != null)
		{
			
			successor = successor.getLeft();
		}
		int successorValue = successor.value;
		//delete successor
		this.delete(successorValue);
		current.value = successorValue;
	}

	private boolean isRootWithNoChild(int value) {
		return this.root.getValue() == value && this.root.left == null && this.root.right==null;
	}

	private void deleteOneChildCase(Node current) {
		if(current.getLeft() != null)
		{
			current.value = current.getLeft().value;
			current.setLeft(null);
			return;
		}
		else if(current.getRight() != null)
		{
			current.value = current.getRight().value;
			current.setRight(null);
			return;
		}
	}

	private void deleteLeafCase(int value, Node parent) {
		if(parent.getLeft().getValue() == value)//Left child
		{
			parent.setLeft(null);
			return;
		}
		if(parent.getRight().getValue()==value)
		{
			parent.setRight(null);
			return;
		}
	}
}
