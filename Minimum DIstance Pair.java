/*
Created by :  aky91
SpaceTime  :  25th Jan 18, @MNNIT 

reference : https://www.geeksforgeeks.org/closest-pair-of-points/
*/

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class MinDistancePair {

	public static class Point implements Comparable<Point> {
		
		int x;
		int y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void print() {
			System.out.println("" + this.x + " , " + this.y);
		}

		public int compareTo(Point comparePoint) {

			int compareX = comparePoint.x;

			return this.x - compareX;
		}

		public static Comparator<Point> ComparatorX = new Comparator<Point>() {

			public int compare(Point p1, Point p2) {

				// ascending order
				return p1.x - p2.x;
			}
		};

		public static Comparator<Point> ComparatorY = new Comparator<Point>() {

			public int compare(Point p1, Point p2) {

				// ascending order
				return p1.y - p2.y;
			}
		};

	}

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) throws java.lang.Exception {

		System.out.print("Enter no. of points : ");
		int N = scn.nextInt();

		Point arr[] = new Point[N];

		for (int i = 0; i < N; i++) {

			System.out.print("Enter space seperated x,y for point " + (i + 1) + " : ");

			int X = scn.nextInt();
			int Y = scn.nextInt();

			arr[i] = new Point(X, Y);
		}

		for (Point data : arr)
			data.print();

		//sorting with respect to x
		Arrays.sort(arr, Point.ComparatorX);

		System.out.println("Minimum distance : " + solver(arr, 0, arr.length - 1));

	}

	public static double solver(Point[] arr, int l, int r) {

		if (l - r <= 2)
			return trivialSolver(arr, l, r);

		int mid = l + (r - l) / 2;
		Point midPoint = arr[mid];

		double ansl = solver(arr, l, mid);
		double ansr = solver(arr, mid + 1, r);

		double d = Math.min(ansl, ansr);

		ArrayList<Point> strip = new ArrayList<>();

		for (int i = l; i <= r; i++) {

			if (Math.abs(arr[i].x - midPoint.x) < d)
				strip.add(arr[i]);
		}

		return (double) Math.min(d, minDistStrip(strip, d));
	}

	public static double minDistStrip(ArrayList<Point> strip2, double d) {

		Point[] strip = strip2.toArray(new Point[0]);

		//sorting with respect to y
		Arrays.sort(strip, Point.ComparatorY);

		double min = d;

		for (int i = 0; i < strip.length; i++)
			for (int j = i + 1; j < strip.length && strip[i].y - strip[j].y < min; j++)
				if (distance(strip[i], strip[j]) < min)
					min = distance(strip[i], strip[j]);

		return min;
	}

	public static double trivialSolver(Point[] arr, int l, int r) {

		double min = Double.MAX_VALUE;

		for (int i = l; i <= r; ++i)
			for (int j = i + 1; j <= r; ++j)
				if (distance(arr[i], arr[j]) < min)
					min = distance(arr[i], arr[j]);
		return min;
	}

	public static double distance(Point p1, Point p2) {

		double X = Math.pow((p1.x - p2.x), 2);
		double Y = Math.pow((p1.y - p2.y), 2);

		double ans = Math.sqrt(X + Y);

		return ans;
	}

}
