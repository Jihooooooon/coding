package com.ssafy;

import java.util.Scanner;

public class Solution6730 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t= sc.nextInt();
		for(int test=1; test<=t; test++) {
			int upResult=-1;
			int downResult=-1;
			int n=sc.nextInt();
			int[] arr = new int[n];
			for(int i=0; i<n; i++) {
				arr[i]=sc.nextInt();
			}
			for(int i=0; i<n-1; i++) {
				
				if(arr[i]<arr[i+1]) {
					upResult = upResult<(arr[i+1]-arr[i])? (arr[i+1]-arr[i]): upResult;
				}
				else {
					downResult = downResult<(arr[i]-arr[i+1])?(arr[i]-arr[i+1]):downResult;
				}
			}
			if(upResult==-1) {
				upResult=0;
			}
			if(downResult==-1) {
				downResult=0;
			}
			System.out.println("#"+test+" "+upResult+" "+downResult);
		}
	}

}
