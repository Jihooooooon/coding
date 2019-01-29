package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samgsung4613 {
	static int N, M, min_paint;
	static char[][] map;

	public void makeArr(int index, String input) {
		for (int i = 0; i < input.length(); i++) {
			map[index][i] = input.charAt(i);
		}
	}

	public void do_paint(int blueStart, int redStart) {
		int temp_count = 0;
		for (int i = 0; i < blueStart; i++) {
			for (int col = 0; col < M; col++) {
				if(map[i][col]!='W') {
					++temp_count;
				}
			}
		}

		for (int j = blueStart; j < redStart; j++) {
			for (int col = 0; col < M; col++) {
				if(map[j][col]!='B') {
					++temp_count;
				}
			}
		}

		for (int k = redStart; k < N; k++) {
			for (int col = 0; col < M; col++) {
				if(map[k][col]!='R') {
					++temp_count;
				}
			}
		}
		min_paint= min_paint > temp_count ? temp_count : min_paint;

	}

	public void solution() {
		int test_case = sc.nextInt();
		for (int test = 1; test <= test_case; test++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			for (int i = 0; i < N; i++) {
				makeArr(i, sc.next());
			}
			min_paint = Integer.MAX_VALUE;
			for (int i = 1; i < N - 1; i++) {
				int blue_start = i;
				for (int j = i + 1; j < N; j++) {
					int red_start = j;
					do_paint(blue_start, red_start);
				}
			}

			System.out.println("#" + test + " " + min_paint);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Samgsung4613().solution();
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
