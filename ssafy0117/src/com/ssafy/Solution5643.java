package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5643 {

	static int N,M;
	static boolean[][] map;
	
	public static void cal() {
		for(int k=0; k<N;k++) {
			for(int i=0; i<N;i++) {
				for(int j=0; j<N;j++) {
					if(i!=j) {
						if(map[i][k] && map[k][j]) {
							map[i][j]=true;
						}
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		sc.init();
		int testCase = sc.nextInt();
		
		for (int test = 1; test <= testCase; test++) {
			N=sc.nextInt();
			M=sc.nextInt();
			map = new boolean[N][N];
			for(int i=0; i<M; i++) {
				int height1 = sc.nextInt()-1;
				int height2 = sc.nextInt()-1;
				map[height1][height2]=true;
			}
			cal();
			int result=0;
			for (int i = 0; i < N; i++) {
				int count=0;
				for (int j = 0; j < N; j++) {
					if(map[i][j]) {
						count++;
					}
					if(map[j][i]) {
						count++;
					}
				}
				if(count==(N-1)) {
					result++;
				}
			}
			System.out.println("#"+test+" "+result);
		}
	}
	
	
	static class sc{
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
			while(!st.hasMoreTokens()) {
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
