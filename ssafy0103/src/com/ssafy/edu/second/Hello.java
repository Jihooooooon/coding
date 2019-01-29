package com.ssafy.edu.second;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Hello {
	public int moveRight(char[][] inputArr, int j, int k, int arrSize) {
		int tempCount = 0;
		while (++k < arrSize && inputArr[j][k] == 'S') {
			++tempCount;
		}
		return tempCount;
	}

	public int moveLeft(char[][] inputArr, int j, int k, int arrSize) {
		int tempCount = 0;
		while (--k >= 0 && inputArr[j][k] == 'S') {
			++tempCount;
		}
		return tempCount;
	}

	public int moveDown(char[][] inputArr, int j, int k, int arrSize) {
		int tempCount = 0;
		while (++j < arrSize && inputArr[j][k] == 'S') {
			++tempCount;
		}
		return tempCount;
	}

	public void solution() {

		int testcase = sc.nextInt();

		for (int i = 1; i <= testcase; ++i) {
			int moveCount = 0;
			int arrSize = sc.nextInt();

			char[][] arr = new char[arrSize][arrSize];
			for (int j = 0; j < arrSize; j++) {
				for (int k = 0; k < arrSize; k++) {
					arr[j][k] = sc.nextChar();
				}
			}

			for (int j = 0; j < arrSize; j++) {
				for (int k = 0; k < arrSize; k++) {
					if (arr[j][k] == 'A') {
						moveCount += moveRight(arr, j, k, arrSize);
					} else if (arr[j][k] == 'B') {
						moveCount += moveRight(arr, j, k, arrSize);
						moveCount += moveLeft(arr, j, k, arrSize);

					} else if (arr[j][k] == 'C') {
						moveCount += moveRight(arr, j, k, arrSize);
						moveCount += moveLeft(arr, j, k, arrSize);
						moveCount += moveDown(arr, j, k, arrSize);
					}
				}

			}
			System.out.println("#" + i + " " + moveCount);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		sc.init();
		Hello test = new Hello();
		test.solution();
	
	}

	static class sc {
		static StringTokenizer st;
		static BufferedReader br;

		static void init() {
			st = new StringTokenizer("");
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
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

		static char nextChar() {
			return next().charAt(0);
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}

	}

}
