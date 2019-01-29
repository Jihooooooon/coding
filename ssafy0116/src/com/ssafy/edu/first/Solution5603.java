package com.ssafy.edu.first;

import java.util.Scanner;

public class Solution5603 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase ; test++) {
			int n=sc.nextInt();
			int[] arr = new int[n];
			int sum=0;
			for(int i=0; i<n; i++) {
				sum+=arr[i]=sc.nextInt();
				
			}
			int pivot = sum/n;
			int count=0;
			for(int i=0; i<n; i++) {
				count+=Math.abs(arr[i]-pivot);
				
			}
			System.out.println("#"+test+" "+count/2);
		}

	}

}
