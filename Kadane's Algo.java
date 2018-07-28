// Akash Yadav
// @PD Tandon, MNNIT, Allahabad
// 28th July 18

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Ideone{
  
	//Kadane's Algorithm

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		int T = scn.nextInt();

		while(T-- > 0){

			int N = scn.nextInt();

			int[] arr = new int[N];
			
			boolean allneg = true;
			int minneg = Integer.MIN_VALUE;
			
			for(int i = 0; i < N; i++){
			    arr[i] = scn.nextInt();
			    
			    if(arr[i] >= 0)
			        allneg = false;
			        
			    if(arr[i] > minneg) minneg = arr[i];
			}
			
			if(allneg){
			    System.out.println(minneg);
			    continue;
			}
			    
			int maxsum = 0;
			int sum = 0;
			
			for(int data : arr){
			    
			    sum += data;
			    
			    if(sum < 0){
			        sum = 0;
			    }
			    
			    if(sum > maxsum){
			        maxsum = sum;
			    }
			}
            
            System.out.println(maxsum);
		}	

	}
}
