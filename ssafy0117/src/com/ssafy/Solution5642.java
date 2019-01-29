package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5642 {
	static int N;
	static int[] arr;
	static int maxS;
	static int[] result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		int testCase = sc.nextInt();
		for (int test = 1; test <= testCase; test++) {
			N=sc.nextInt();
			arr = new int[N+1];
			result = new int[N+1];
			for (int i = 1; i <= N; i++) {
				arr[i]=sc.nextInt();
			}
			result[1]=arr[1];
			for(int i=2; i<=N; i++) {
				if (result[i-1] + arr[i] > arr[i]){
		            result[i] = result[i - 1] + arr[i];
		        }
		        else
		        {
		            result[i] = arr[i];
		        }

			}
			maxS=Integer.MIN_VALUE;
			for(int i=1; i<=N;i++) {
				maxS = maxS < result[i] ? result[i]: maxS;
			}
			
			
			System.out.println("#"+test+" "+maxS);
			
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
