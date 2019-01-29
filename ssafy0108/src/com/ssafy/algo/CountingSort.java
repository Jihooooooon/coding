package com.ssafy.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountingSort {

	static int[] data;
	static int[] counts;
	static int[] temp;

	static Scanner sc = new Scanner(System.in);

	public static void countingSort() {
		for(int i:data) {
			counts[i]++;
		}
		for(int i=0; i<counts.length-1; i++) {
			counts[i+1]+= counts[i];
		}
		for(int i=data.length-1; i>=0;i--) {
			counts[data[i]]--;
			temp[counts[data[i]]]=data[i];
		}
		System.out.println(Arrays.toString(temp));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
	
		data = new int[n];
		temp = new int[n];
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
			max = max<data[i]? data[i]:max;
	

		}
		counts = new int[max+1];
		countingSort();

	}

}
