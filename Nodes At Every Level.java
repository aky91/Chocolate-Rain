import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Ideone{

	// Write a function that accepts root of binary tree as its argument and 
	// return the sum of all leaf nodes at maximum depth from root.

	public static Scanner scn = new Scanner(System.in);

	public static class Node{

		int data;
		Node left;
		Node right;

		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main (String[] args) throws java.lang.Exception{

		Node root = new Node(10);

		root.left = new Node(20);
		root.left.left = new Node(30);
		root.left.right = new Node(40);
		root.left.right.left = new Node(50);

		root.right = new Node(60);
		root.right.left = new Node(70);
		root.right.right = new Node(80);
		root.right.left.left = new Node(90);
		root.right.left.right = new Node(100);

		leafMaxDepth(root);
		
	}

	public static void leafMaxDepth(Node root){

		HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();

		preOrder(root, 0, map);

		for(int depth : map.keySet()){

			System.out.print(" depth " + depth + " : ");

			for(int data : map.get(depth))
				System.out.print(data + " ");

			System.out.println();
		}
	}

	public static void preOrder(Node n, int depth, HashMap<Integer, LinkedList<Integer>> map){

		if(n == null)
			return;

		if(!map.containsKey(depth))
			map.put(depth, new LinkedList<>());

		map.get(depth).addLast(n.data);

		preOrder(n.left, depth + 1, map);
		preOrder(n.right, depth + 1, map);
	}
}