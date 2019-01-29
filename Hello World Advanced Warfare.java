import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
import java.util.concurrent.ThreadLocalRandom;
 
class HW{
 
	//Printing string using randomdly generated letters

	public static Scanner scn = new Scanner(System.in);

	public static void main (String[] args) throws InterruptedException{

 		System.out.print("Enter string to check : ");
 		
 		String str = scn.nextLine();

 		int idx = 0;

		while(idx < str.length()){

			//generates random
			char ch = (char)ThreadLocalRandom.current().nextInt(' ', 'z'+1);

			System.out.print(ch);

			if(str.charAt(idx) != ch)
				System.out.print("\b");
			else
				idx++;

			//sleep
			Thread.sleep(10);
		}

 		System.out.println();
 	}
}		
