import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class EggDrop{

	//https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle/0

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		EggDrop ED = new EggDrop();

		int T = scn.nextInt();

		while(T-- > 0){

			int eggs = scn.nextInt();
			int floors = scn.nextInt();

			HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
	        
			int ans = ED.dropEggs(eggs, floors, map);

			System.out.println(ans);
		}
	}
	
	public static int dropEggs(int eggs, int floors, HashMap<Integer, HashMap<Integer, Integer>> map){
	    
	    if(eggs == 1)
	        return floors;

	    if(floors == 0)
	    	return 0;
	        
	    if(map.containsKey(eggs) && map.get(eggs).containsKey(floors))
	    	return map.get(eggs).get(floors);

	    int min = Integer.MAX_VALUE;
	    
	    //try dropping at every floor
	    for(int i = 1; i <= floors; i++){
		// 1 for current drop, first call for if egg breaks, second call for if egg does not break
	    	int val = 1 + Math.max(dropEggs(eggs - 1, i - 1, map) , dropEggs(eggs, floors - i, map));
	        min = Math.min(min, val);
	    }

	    if(!map.containsKey(eggs))
	    	map.put(eggs, new HashMap<>());

	    map.get(eggs).put(floors, min);
	
	    return min;
	}
}
