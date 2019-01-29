package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSort2063 {
	static Scanner sc = new Scanner(System.in);
	static int[] data;
	static int[] counts;
	static int[] temp;
	
	public static void swap(int[] inputArr, int a, int b) {
		int temp= inputArr[a];
		inputArr[a]=inputArr[b];
		inputArr[b]=temp;
		return;
	}
	
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
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =sc.nextInt();
		data = new int[n];
		temp = new int[n];
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<n; i++) {
			data[i]=sc.nextInt();
			max = max<data[i]? data[i]:max;
		}
		counts = new int[max+1];
		countingSort();
		
		System.out.println(temp[n/2]);
	}

}
