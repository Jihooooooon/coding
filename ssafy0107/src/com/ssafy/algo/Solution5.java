package com.ssafy.algo;

import java.util.Scanner;

public class Solution5 {
	static int N, L;
	static int[] pre, cal;
	static int max;
	static Scanner sc = new Scanner(System.in);

	public static void dfs(int index, int preT, int calT) {
		if (index == N) {
			if (calT <= L) {
				max = max < preT ? preT : max;
			}

			return;
		}
		dfs(index + 1, preT + pre[index], calT + cal[index]);
		dfs(index + 1, preT, calT);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = sc.nextInt();
		for (int testCase = 1; testCase <= test; testCase++) {
			N = sc.nextInt();
			L = sc.nextInt();
			pre = new int[N];
			cal = new int[N];

			for (int i = 0; i < N; i++) {
				pre[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			dfs(0, 0, 0);
			System.out.println("#" + testCase + " " + max);
			max = 0;
		}

	}
}
