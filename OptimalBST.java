import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

class Ideone{

	//Optimal BST

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		int[] node = {0, 10, 12, 20};

		int[] freq = {0, 34, 8, 50};

		int ans = optimalBST(node, freq);

		System.out.println(ans);

	}

	public static int optimalBST(int[] node, int[] freq){

		int N = node.length - 1;

		int[][] dp = new int[N+1][N+1];

		for(int size = 0; size <= N; size++){
			
			for(int start = 1; start <= N; start++){

				if(start + size > N)
					break;

				int left = start;
				int right = start + size;

				dp[left][right] = getSum(left, right, freq);

				if(left == right)
					continue;

				int ans = Integer.MAX_VALUE;

				for(int r = left; r <= right; r++){

					int temp = 0;

					if(r - 1 >= 1)
						temp += dp[left][r-1];

					if(r + 1 <= N)
						temp += dp[r+1][right];

					ans = Math.min(ans , temp);
				}
				
				dp[left][right] += ans;
			}
		}

		for(int i = 1; i <= N; i++){

			for(int j = 1; j <= N; j++)
				System.out.print("" + dp[i][j] + "  ");
			System.out.println();
		}

		return dp[1][N];
	}

	public static int getSum(int left, int right, int[] freq){

		int sum = 0;

		for(int i = left; i <= right; i++)
			sum += freq[i];

		return sum;
	}

}