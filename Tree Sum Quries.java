// Akash Yadav
// @PD Tandon, MNNIT Allahabad
// 10th August 18

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class TestClass{

	// TREE SUM QUERIES
	// Precomputation : O(n)
	// Sum   : O(1)
	// Update: O(log(N))

	public static Scanner scn = new Scanner(System.in);

	public static class Node{

		int data;
		int idx;
		int sum;
		Node parent;
		ArrayList<Node> neighbours;

		public Node(int idx, int data){
			this.idx = idx;
			this.data = data;
			this.sum = data;
			this.parent = null;
			this.neighbours = new ArrayList<>();
		}
	}

	public static Node root = null;

	public static void main (String[] args) throws java.lang.Exception{

		//no. of nodes and index of root node
		int N = scn.nextInt();
		int R = scn.nextInt();

		//HashMap for index -> node
		HashMap<Integer, Node> map = new HashMap<>();

		//values of each node
		for(int i = 1; i <= N; i++){
			int val = scn.nextInt();
			Node bairn = new Node(i, val);
			map.put(i, bairn);
		}

		root = map.get(R);

		//connections
		for(int i = 1; i <= N-1; i++){
			int a = scn.nextInt();
			int b = scn.nextInt();

			Node A = map.get(a);
			Node B = map.get(b);

			A.neighbours.add(B);
			B.neighbours.add(A);

			// map.get(a).neighbours.add(map.get(b));
			// map.get(b).neighbours.add(map.get(a));
		}

		//precomputation: make parent connections and set sum
		buildTree(root, new HashSet<>());
		setSum(root);
		
		//printS(map);
		//print(map);
        
        //quries
		int Q = scn.nextInt();
		
		while(Q-- > 0){
		    
		    int type = scn.nextInt();
		    
		    if(type == 0){//sum: i
		    
                int idx = scn.nextInt();
                System.out.println(map.get(idx).sum);
		    
		    } else {//update: i, k
		        
		        int idx = scn.nextInt();
		        int K = scn.nextInt();
		        
		        update(map.get(idx), K);
		    }
		}
	}

	//function to perforn update query
	public static void update(Node ptr, int K){
	       
	    if(ptr == null) return;
	    
	    ptr.data += K;
	    ptr.sum += K;
	    
	    update(ptr.parent, K);
	}

	//function to set parent connections on all nodes
	public static void buildTree(Node ptr, HashSet<Node> visited){

		 if(ptr == null) return;

		 visited.add(ptr);

		 for(Node littleOne : ptr.neighbours){

		 	if(visited.contains(littleOne)) continue;

		 	littleOne.parent = ptr;
		 	
		 	buildTree(littleOne, visited);
		 }

		 visited.remove(ptr);
	}
	
	//function to set sum on all nodes
	public static int setSum(Node ptr){
	    
	    if(ptr == null) return 0;
	    
	    int sum = ptr.data;
	    
	    for(Node child : ptr.neighbours){
	        if(child == ptr.parent) continue;
	        sum += setSum(child);
	    }
	    
	    ptr.sum = sum;
	    
	    return sum;
	}
	
	//function to print all nodes with sum
	public static void printS(HashMap<Integer, Node> map){
	    for(int i : map.keySet()){
		    Node ptr = map.get(i);
			System.out.print("d:" + ptr.idx + " | s:" + ptr.sum);
			System.out.println();
		}
	}
	
	//function to print all info of each node
	public static void print(HashMap<Integer, Node> map){
	    for(int i : map.keySet()){
		    Node ptr = map.get(i);
			System.out.print("d:" + ptr.idx + " | ");
			if(ptr.parent != null) System.out.print("p:" + ptr.parent.idx + " | ");
			System.out.print("c:");
			for(Node child : ptr.neighbours) System.out.print(child.idx + " ");
			System.out.println();
		}
	}
}
