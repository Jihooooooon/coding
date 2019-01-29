package com.ssafy;

import java.util.Scanner;

public class Solution6782_1 {

	static Scanner sc = new Scanner(System.in);
	static long[] powArr = new long[1000000];
	static int minCount=Integer.MAX_VALUE;


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=1; i<powArr.length;i++) {
			powArr[i]=i*i;
		}
		int t= sc.nextInt();
	
		for(int test=1; test<=t; test++) {
			long n = sc.nextLong();
			
			System.out.println("#"+test+" "+minCount);
			minCount=Integer.MAX_VALUE;
		}
		
	}

}
