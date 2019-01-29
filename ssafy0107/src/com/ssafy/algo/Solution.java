package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	static int[] inputArr = new int[50];

	public void chageStrtoInt(String[] input) {

		for (int i = 0; i < input.length; i++) {
			inputArr[i] = Integer.parseInt(input[i]);

		}

	}

	public void changeBit(int[] inputArr, int index, int bit) {

		for (int i = index; i < inputArr.length; i++) {
			inputArr[i] = bit;
		}
	}

	public void solution() {
		int testcase = sc.nextInt();

		for (int test = 1; test <= testcase; test++) {
			int count = 0;

			String input = sc.next();
			String[] array_word = input.split("");

			int[] temp = new int[input.length()];

			chageStrtoInt(array_word);
			for (int i = 0; i < input.length(); i++) {
				if (inputArr[i] != temp[i]) {
					changeBit(temp, i, inputArr[i]);
					count++;
				}
			}
			Arrays.fill(inputArr, 0);
			System.out.println("#" + test + " " + count);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc.init();
		new Solution().solution();
	}

	static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String nextLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String nextLineReplaceAll() {
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
