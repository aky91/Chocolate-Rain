/*
 * Author    : Akash Y. (20164094)
 * SpaceTime : 30th Jan 18 @ MNNIT
 */

// smallest and second smallest element in an array

/*
	ALGO.

	recursive solution:

	if we have to do solve for index l and r in array

	find mid index

	recursively get minimum form left and right halves along with all elements 
	with the smallest opponent

	our answer is min amoung those 2 values

	return answer and minimum of current opponent and smallest opponent 


	Complexity Analysis : 

	T(n) = 2T(n/2) + 1

	using masters method : 

	n = O( n^(1-E) )
	
	Case 1

	so complexity is Θ(n) 
	
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 
class Ideone{

	public static Scanner scn = new Scanner(System.in);

	public static class Opair{

		int value;
		int smallestOpponent;

		public Opair(int value, int smallestOpponent){

			this.value = value;
			this.smallestOpponent = smallestOpponent;

		}
	}

	public static void main (String[] args) throws java.lang.Exception{

 		int N = scn.nextInt();

 		//creates 1 indexed array with N elements
 		int[] arr = arrayCreator(N,1);

 		Opair ans = orderStats(1, arr.length-1, arr);

 		System.out.println("Smallest = " + ans.value);

 		if(ans.smallestOpponent != Integer.MAX_VALUE)
 			System.out.println("2nd smallest = " + ans.smallestOpponent);
 		else
 			System.out.println("2nd smallest does not exits");

 	}

 	public static Opair orderStats(int l, int r, int[] arr){

		if(r == l){ // base case

			Opair op = new Opair(arr[r] , Integer.MAX_VALUE);
				
 			return op;
		}

 		int mid = (l + r)/2;

 		Opair n1 = orderStats(l,mid,arr);

 		Opair n2 = orderStats(mid+1,r,arr);

 		Opair ans = new Opair(0,0);

 		if(n1.value < n2.value){ // n1 wins

 			ans.value = n1.value;

 			if(n2.value < n1.smallestOpponent)
 				n1.smallestOpponent = n2.value;

 			ans.smallestOpponent = n1.smallestOpponent;
 		
 		} else if(n2.value < n1.value){ // n2 wins

			ans.value = n2.value;

 			if(n1.value < n2.smallestOpponent)
 				n2.smallestOpponent = n1.value;

 			ans.smallestOpponent = n2.smallestOpponent; 			
 		
 		} else { // when there is tie

 			ans.value = n2.value;

 			ans.smallestOpponent = Math.min(n1.smallestOpponent,n2.smallestOpponent);
 		}

 		return ans;
 	}

 	//function to create array
 	public static int[] arrayCreator(int N, int idx){

 		int[] arr;

 		if(idx == 0){

 			arr = new int[N];

 			for(int i = 0; i < N; i++)
 				arr[i] = scn.nextInt();
 		
 		} else {

 			arr = new int[N + 1];

 			for(int i = 1; i <= N; i++)
 				arr[i] = scn.nextInt();
 		}

 		return arr;
 	}

}		
