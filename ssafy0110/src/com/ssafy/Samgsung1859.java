package com.ssafy;

import java.util.Scanner;

public class Samgsung1859 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int t = sc.nextInt();
		for(int test=1; test<=t; test++) {
			long result=0;
			int day = sc.nextInt();
			int[] cost = new int[day];
			for(int i=0; i<day; i++) {
				cost[i]=sc.nextInt();
			}
			int max = cost[day-1];
			for(int i=day-2; i>=0; i--) {
				if(cost[i]<max) {
					result+= max-cost[i];
				}
				else if(cost[i]>max) {
					max= cost[i];
				}
			}
			
			
			System.out.println("#"+test+" "+result);
		}
	}

}
