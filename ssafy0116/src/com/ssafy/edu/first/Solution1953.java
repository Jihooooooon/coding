package com.ssafy.edu.first;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1953  {
	static int N, M, R, C, L;
	static boolean[][] visit;
	static int[][] map;
	static int count;
	//상 하 좌 우
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	/*
	public static boolean canGo(int x, int y, int nextX, int nextY) {
		boolean isG=false;
		
		if(map[x][y]==1 && map[nextX][nextY]!=0) {
			return true;
		}
		else if(map[x][y]==2 && map[nextX][nextY]!=0)
		return isG;
	}

	public static void bfs(int x, int y) {

	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		int testCase = sc.nextInt();
		for (int test = 1; test <= testCase; test++) {
			N = sc.nextInt();
			M = sc.nextInt();
			R = sc.nextInt();
			C = sc.nextInt();
			L = sc.nextInt();
			
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

		static String readLineReplace() {
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
