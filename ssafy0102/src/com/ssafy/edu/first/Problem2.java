package com.ssafy.edu.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem2 {

	public void solution() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Problem2().solution();

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
				return null;
				// TODO: handle exception
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

		static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
		static long nextLong() {
			return Long.parseLong(next());
		}

	}

}
