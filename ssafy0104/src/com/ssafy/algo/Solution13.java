package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution13 {

	public boolean isGarden(char[][] inputMap, int x, int y, int mapSize) {
		boolean isNear = false;
	
		if (0 < x && x < mapSize - 1 && 0 < y && y < mapSize - 1) {
		
			
			if (inputMap[x - 1][y] == 'G' || inputMap[x + 1][y] == 'G' || inputMap[x][y - 1] == 'G'
					|| inputMap[x][y + 1] == 'G' || inputMap[x - 1][y - 1] == 'G' || inputMap[x - 1][y + 1] == 'G'
					|| inputMap[x + 1][y - 1] == 'G' || inputMap[x + 1][y + 1] == 'G') {
				isNear = true;
			}
		}

		return isNear;
	}

	public int findTopHeight(char[][] inputMap, int mapSize) {
		int maxHeight = 0;
		for (int i = 1; i < mapSize - 1; i++) {
			for (int j = 1; j < mapSize - 1; j++) {
				if (inputMap[i][j] == 'G') {
					continue;
				} else {
					if (isGarden(inputMap, i, j, mapSize)) {
						maxHeight = maxHeight < 2 ? 2 : maxHeight;
					} else {
						int count_B = 0;
						for (int t = 1; t < mapSize - 1; t++) {
							if (inputMap[t][j] == 'B') {
								count_B++;
							}
							if (inputMap[i][t] == 'B') {
								count_B++;
							}
						}
						count_B--;
						maxHeight = maxHeight < count_B ? count_B : maxHeight;
					}
				}
			}
		}
		return maxHeight;
	}

	public void solution() {
		int testCase = sc.nextInt();

		for (int test_case = 1; test_case <= testCase; test_case++) {
			int arrSize = sc.nextInt();
			char map[][] = new char[arrSize + 2][arrSize + 2];
			for (int i = 1; i < arrSize + 1; i++) {
				for (int j = 1; j < arrSize + 1; j++) {
					map[i][j] = sc.nextChar();
				}
			}
			int topHeight = findTopHeight(map, arrSize + 2);
			System.out.println("#" + test_case + " " + topHeight);

		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Solution13().solution();
	}

	public static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		public static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		public static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				// TODO: handle exception
				return null;
			}
		}

		public static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
				return null;
			}
		}

		public static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}

		public static char nextChar() {
			return next().charAt(0);
		}

		public static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
