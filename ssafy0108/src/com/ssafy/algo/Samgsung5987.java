package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Samgsung5987 {

	static long[] factorial = new long[18];
	static int N, M;
	static boolean[] isUse;
	static ArrayList<Integer>[] priority;
	static int result = 1;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		factorial[0] =1;
		for (int i = 1; i < 18; i++) {
			factorial[i] = factorial[i - 1] * i;
		}
		int testCase = sc.nextInt();
		for (int test = 1; test <= testCase; test++) {
			N = sc.nextInt();
			M = sc.nextInt();
			priority = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				priority[i] = new ArrayList<>();
			}
			
			isUse = new boolean[N+1];
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				priority[x].add(y);
				isUse[x]=isUse[y]=true;
				
			}
			int count=0;
			for(int i=1; i<=N; i++) {
				if(isUse[i]) {
					count++;
				}
			}
			if(count!=0) {
			
			}
		}
		System.out.println(Arrays.toString(isUse));
	}

}
