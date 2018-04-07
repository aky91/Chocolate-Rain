import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class Sudoku {

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws java.lang.Exception{

		int[][] board = new  int[10][10];

		for(int i = 0; i < 10; i++)
			for(int j = 0; j < 10; j++)
				board[i][j] = 0;

		boolean[][] given = new boolean[10][10];

		board[2][6] = 3; given[2][6] = true;
		board[2][8] = 8; given[2][8] = true;
		board[2][9] = 5; given[2][9] = true;

		board[3][3] = 1; given[3][3] = true;
		board[3][5] = 2; given[3][5] = true;

		board[4][4] = 5; given[4][4] = true;
		board[4][6] = 7; given[4][6] = true;

		board[5][3] = 4; given[5][3] = true;
		board[5][7] = 1; given[5][7] = true;

		board[6][2] = 9; given[6][2] = true;

		board[7][1] = 5; given[7][1] = true;
		board[7][8] = 7; given[7][8] = true;
		board[7][9] = 3; given[7][9] = true;

		board[8][3] = 2; given[8][3] = true;
		board[8][5] = 1; given[8][5] = true;

		board[9][5] = 4; given[9][5] = true;
		board[9][9] = 9; given[9][9] = true;

		double ts = Calendar.getInstance().getTimeInMillis()/1000.0;
		
		solve(1, 1, board, given);
		
		double te = Calendar.getInstance().getTimeInMillis()/1000.0;

		for(int i = 1; i < 10; i++){
			for(int j = 1; j < 10; j++)
				System.out.print(board[i][j]+ " ");
			System.out.println();
		}
		
		System.out.println("\n\nIt took " + (te - ts) + " miliseconds");

	}

	public static boolean solve(int row, int col, int[][] board, boolean[][] given){

		if(row == 10)
			return true;

		if(col == 10)
			return solve(row+1, 1, board, given);

		if(given[row][col])
			return solve(row, col+1, board, given);

		for(int num = 1; num <= 9; num++){

			if(isSafe(row, col, num, board)){
				
				board[row][col] = num;

				if(solve(row, col+1, board, given))
					return true;

				board[row][col] = 0;
			} 
		}
		
		return false;
	}

	public static boolean isSafe(int row, int col, int val, int[][] board){

		//row check
		for(int r = 1; r <= 9; r++)
			if(board[r][col] == val)
				return false;

		//col check
		for(int c = 1; c <= 9; c++)
			if(board[row][c] == val)
				return false;

		//box check
		int rs = ((int)Math.ceil(1.0*row/3)-1)*3  + 1;
		int cs = ((int)Math.ceil(1.0*col/3)-1)*3  + 1;

		for(int r = rs; r <= rs + 2; r++)
			for(int c = cs; c <= cs + 2; c++)
				if(board[r][c] == val)
					return false;

		return true;
	}
		

}
