package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6781 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		int testCase = sc.nextInt();

		// R:0 G:1 B:2
		for (int test = 1; test <= testCase; test++) {
			String num = sc.next();
			String rgb = sc.next();

			int[] rCount = new int[10];
			int[] gCount = new int[10];
			int[] bCount = new int[10];
			int totalCount = 9;
			for (int i = 0; i < 9; i++) {
				int temp = Integer.parseInt(num.substring(i, i + 1));
				if (rgb.charAt(i) == 'R') {
					rCount[temp]++;
				} else if (rgb.charAt(i) == 'G') {
					gCount[temp]++;
				} else {
					bCount[temp]++;
				}
			}
			for (int i = 1; i <= 7; i++) {
				if (rCount[i] >= 1 && rCount[i + 1] >= 1 && rCount[i + 2] >= 1) {
					rCount[i]--;
					rCount[i + 1]--;
					rCount[i + 2]--;
					totalCount -= 3;
					i--;
				}

			}
			for (int i = 1; i <= 7; i++) {
				if (gCount[i] >= 1 && gCount[i + 1] >= 1 && gCount[i + 2] >= 1) {
					gCount[i]--;
					gCount[i + 1]--;
					gCount[i + 2]--;
					totalCount -= 3;
					i--;
				}
			}
			for (int i = 1; i <= 7; i++) {
				if (bCount[i] >= 1 && bCount[i + 1] >= 1 && bCount[i + 2] >= 1) {
					bCount[i]--;
					bCount[i + 1]--;
					bCount[i + 2]--;
					totalCount -= 3;
					i--;
				}
			}
			for (int i = 1; i <= 9; i++) {
				if (rCount[i] >= 3) {
					rCount[i] -= 3;
					totalCount -= 3;
					i--;
				}
			}
			for (int i = 1; i <= 9; i++) {
				if (gCount[i] >= 3) {
					gCount[i] -= 3;
					totalCount -= 3;
					i--;
				}
			}
			for (int i = 1; i <= 9; i++) {

				if (bCount[i] >= 3) {
					bCount[i] -= 3;
					totalCount -= 3;
					i--;
				}
			}
			if (totalCount == 0) {
				System.out.println("#" + test + " Win");
			} else {
				System.out.println("#" + test + " Continue");
			}

		}
	}

	static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String readLineReplaceAll() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
