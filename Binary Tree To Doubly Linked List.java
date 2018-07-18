// Akash Yadav
// @Mainpuri, UP
// 18th July 18

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class TestClass{

	//binary tree's leaves to doubly linked list

	public static Scanner scn = new Scanner(System.in);

	//for binary tree
	public static class Box{
		int data;
		Box left;
		Box right;

		public Box(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	//for doubly linked list
	public static class Node{
		int data;
		Node next;
		Node prev;

		public Node(int data){
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static void main (String[] args) throws java.lang.Exception{

		//binary tree
		Box root = new Box(1);
		root.left = new Box(2);
		root.right = new Box(3);
		root.left.left = new Box(4);
		root.left.right = new Box(5);
	}
}
