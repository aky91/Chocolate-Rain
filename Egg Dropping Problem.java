import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class EggDrop{

	//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		EggDrop ED = new EggDrop();

		int eggs = 100;
		int floors = 2;
        
		int ans = ED.dropEggs(eggs, floors);

		System.out.println(ans);
	}
	
	public static int dropEggs(int eggs, int floors){
	    
	    if(eggs == 1)
	        return floors;

	    if(floors == 0)
	    	return 0;
	        
	    int min = Integer.MAX_VALUE;
	    
	    //try dropping at every floor
	    for(int i = 1; i <= floors; i++){

	    	int val = 1 + Math.max(dropEggs(eggs - 1, i - 1) , dropEggs(eggs, floors - i));
	        min = Math.min(min, val);
	    }
	
	    return min;
	}
}
