import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class CoinChange {
	
	//Coin change DP

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		int N = scn.nextInt();

		int[] dominations = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < N; i++)
			dominations[i] = scn.nextInt();

		int amount = scn.nextInt();

		System.out.println(getMinChangeTD(amount, dominations, map));
		System.out.println(getMinChangeBU(amount, dominations));	

	}

	public static int getMinChangeTD(int amount, int[] dominations, HashMap<Integer, Integer> map){

		if(amount == 0)
			return 0;

		if(amount < 0)
			return Integer.MAX_VALUE;

		if(map.containsKey(amount))
			return map.get(amount);

		int ans = Integer.MAX_VALUE;

		for(int coin : dominations)
			ans = Math.min(ans, getMinChangeTD(amount - coin, dominations, map));

		map.put(amount, 1 + ans);

		return map.get(amount);
	}

	public static int getMinChangeBU(int amount, int[] dominations){

		int[] ans = new int[amount + 1];
		ans[0] = 0;

		for(int amt = 1; amt <= amount; amt++){

			int minChange = Integer.MAX_VALUE;

			for(int coin : dominations){

				if(amt - coin < 0)
					continue;

				minChange = Math.min(minChange, ans[amt - coin] + 1);
			}

			ans[amt] = minChange;
		}

		return ans[amount];
	}
}