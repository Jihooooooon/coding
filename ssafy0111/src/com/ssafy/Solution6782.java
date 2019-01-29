package com.ssafy;

import java.util.Scanner;

public class Solution6782 {

	static Scanner sc = new Scanner(System.in);
	static long[] route= {2,4,16,196,38416,1475789056};
	static int minCount=Integer.MAX_VALUE;
	
	
	public static boolean isSqrtInteger(long n) {
		boolean isInteger=false;
		
		long temp = (long)Math.sqrt(n);
		if((temp*temp)==n) {
			isInteger=true;
		}
		
		return isInteger;
	}
	
	public static void dfs(long n,int count) {
		if(count>minCount) {
			return;
		}
		if(n==2) {
			minCount = minCount >count? count:minCount;
			return;
		}
		if(isSqrtInteger(n)) {
			dfs((long)Math.sqrt(n),count+1);
		}
		dfs(n+1,count+1);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t= sc.nextInt();
		for(int test=1; test<=t; test++) {
			long n = sc.nextLong();
			dfs(n,0);
			System.out.println("#"+test+" "+minCount);
			minCount=Integer.MAX_VALUE;
		}
		
	}

}
