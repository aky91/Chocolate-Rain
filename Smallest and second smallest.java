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
	with all elements with which they were compared

	our answer is min amoung those 2 values

	return answer and list of all elements of winner + other element(which we just compared)


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
		ArrayList<Integer> opponents;

		public Opair(int value, ArrayList<Integer> opponents){

			this.value = value;
			this.opponents = opponents;

		}
	}

	public static int smallest = 0;

	public static void main (String[] args) throws java.lang.Exception{

 		int N = scn.nextInt();

 		//creates 1 indexed array with N elements
 		int[] arr = arrayCreator(N,1);

 		Opair ans = orderStats(1, arr.length-1, arr);

 		System.out.println("Smallest = " + ans.value);
 		
 		int[] opponent = new int[ans.opponents.size()+1];
 		int idx = 1;

 		for(int data : ans.opponents)
 			opponent[idx++] = data;
 		
 		Opair ans2 = orderStats(1, opponent.length-1, opponent);
 		
 		System.out.println("2nd smallest = " + ans2.value);

 	}

 	public static Opair orderStats(int l, int r, int[] arr){

		if(r == l){

			Opair op = new Opair(arr[r] , new ArrayList<>());
				
 			return op;
		}

 		int mid = (l + r)/2;

 		Opair n1 = orderStats(l,mid,arr);

 		Opair n2 = orderStats(mid+1,r,arr);

 		Opair ans = new Opair(0,new ArrayList());

 		if(n1.value < n2.value){

 			ans.value = n1.value;

 			n1.opponents.add(n2.value);

 			ans.opponents = n1.opponents;
 		
 		} else {

			ans.value = n2.value;

 			n2.opponents.add(n1.value);

 			ans.opponents = n2.opponents; 			
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
