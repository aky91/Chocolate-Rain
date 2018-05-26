import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Ideone{

	//https://practice.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s/0/?ref=self

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		int T = scn.nextInt();

		while(T-- > 0){

			int N = scn.nextInt();

			//int[] arr = new int[N];
			ArrayList<Integer> list = new ArrayList<>();

			for(int i = 0; i < N; i++)
				list.add(scn.nextInt());

			int zeroEndIdx = -1;
			int ones = 0;

			for(int i = 0; i < N; i++){

				int num = list.get(i);

				if(num == 0){

					//increase end index of zero
					zeroEndIdx++;

					//swap current zero with updated index
					Collections.swap(list, i, zeroEndIdx);

					int swapped = list.get(i);

					//if swapped element is one, place it in right place
					if(swapped == 1)
						Collections.swap(list, i, zeroEndIdx + ones);
				
				}else if(num == 1){

					ones++;

					Collections.swap(list, i, zeroEndIdx + ones);
				
				} else {
					//when num is 2 do nothing
				}
			}

			for(int item : list)
				System.out.print(item + " ");

			System.out.println();
		}	
	}
}