package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution22 {

	public boolean jump_in_pond(int row, int col, int direction, int[][] pond) {
		boolean isDie = false;

		if (pond[row][col] != 0) {
			return true;
		}
		// 상 1 하 2 좌 3 우 4

		int next_row = row;
		int next_col = col;
		int jump_width = 3;

		// 상
		if (direction == 1) {
			for (int i = 0; i < 3; i++, jump_width--) {
				next_row -= jump_width;
				if (next_row < 0) {
					isDie = true;
					break;
				}
				if (pond[next_row][next_col] != 0) {
					isDie = true;
					break;
				}
			}
			if (!isDie) {
				pond[next_row][next_col] = 1;
			}
		}
		// 하
		else if (direction == 2) {
			for (int i = 0; i < 3; i++, jump_width--) {
				next_row += jump_width;
				if (next_row >= pond.length) {
					isDie = true;
					break;
				}
				if (pond[next_row][next_col] != 0) {
					isDie = true;
					break;
				}
			}
			if (!isDie) {
				pond[next_row][next_col] = 1;
			}
		}
		// 좌
		else if (direction == 3) {
			for (int i = 0; i < 3; i++, jump_width--) {
				next_col -= jump_width;
				if (next_col < 0) {
					isDie = true;
					break;
				}
				if (pond[next_row][next_col] != 0) {
					isDie = true;
					break;
				}
			}
			if (!isDie) {
				pond[next_row][next_col] = 1;
			}
		}
		// 우
		else {
			for (int i = 0; i < 3; i++, jump_width--) {
				next_col += jump_width;
				if (next_col >= pond.length) {
					isDie = true;
					break;
				}
				if (pond[next_row][next_col] != 0) {
					isDie = true;
					break;
				}
			}
			if (!isDie) {
				pond[next_row][next_col] = 1;
			}
		}

		return isDie;
	}

	public void solution() {
		int testcase = sc.nextInt();
		for (int i = 1; i <= testcase; i++) {
			int pondSize = sc.nextInt();
			int saltWater_num = sc.nextInt();
			int pond[][] = new int[pondSize][pondSize];
			int saltWater_alive = saltWater_num;

			for (int j = 1; j <= saltWater_num; j++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				// 상 1 하 2 좌 3 우 4
				int direction = sc.nextInt();
				if (jump_in_pond(row, col, direction, pond)) {
					saltWater_alive--;
				}

			}
			System.out.println("#" + i + " " + saltWater_alive);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Solution22().solution();

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
