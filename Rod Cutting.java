import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class RodCutting {

	//Rod Cutting DP Bottom Up & Top Down with 2D array 

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		int N = scn.nextInt();

		int[] price = new int[N+1];
		HashMap<Integer, Integer> dp = new HashMap<>();
		HashMap<Integer, Integer> choices = new HashMap<>();

		for(int i = 1; i <= N; i++)
			price[i] = scn.nextInt();

		int rodLength = scn.nextInt();

		if(rodLength > N){
			System.out.println("Invalid Input");
			return;
		}

		////////// TOP DOWN

		System.out.println("TOP DOWN");

		System.out.println("max profit : " + getMaxProfitTD(rodLength, price, dp, choices));

		//printing length of pieces

		System.out.print("Pieces : ");

		for(int i = rodLength; i > 0;){

			System.out.print(choices.get(i) + " ");
			i = i - choices.get(i);
		}

		System.out.println("\n");

		////////// BOTTOM UP

		System.out.println("BOTTOM UP");

		System.out.println("max profit : " + getMaxProfitBU(rodLength, price));
		
	}

	public static int getMaxProfitTD(int rod, int[] price, HashMap<Integer, Integer> dp, HashMap<Integer, Integer> choices){

		if(rod < 0)
			return Integer.MIN_VALUE;

		if(rod == 0)
			return 0;
		
		if(dp.containsKey(rod)) 
			return dp.get(rod);

		int ans = Integer.MIN_VALUE;
		
		for(int cut = 1; cut <= rod; cut++){

			int profit = price[cut] + getMaxProfitTD(rod - cut, price, dp, choices);
			
			if(profit > ans){
				ans = profit;
				choices.put(rod, cut);
			}
		}
		
		dp.put(rod, ans);
		return ans;
	}

	public static int getMaxProfitBU(int rodLength, int[] price){

		int[] choices = new int[rodLength + 1];
		int[] ans = new int[rodLength + 1];
		ans[0] = 0;

		for(int rod = 1; rod <= rodLength; rod++){

			int maxProfit = Integer.MIN_VALUE;

			for(int cut = 1; cut <= rod; cut++){

				int profit = price[cut] + ans[rod - cut];
				//maxProfit = Math.max(profit, maxProfit);

				if(profit > maxProfit){
					maxProfit = profit;
					choices[rod] = cut;
				}
			}

			ans[rod] = maxProfit;
		}

		//printing length of pieces

		System.out.print("Pieces : ");

		for(int i = rodLength; i > 0;){

			System.out.print(choices[i] + " ");
			i = i - choices[i];
		}

		System.out.println();

		return ans[rodLength];
	}

}
