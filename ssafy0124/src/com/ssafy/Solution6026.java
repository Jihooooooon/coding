package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6026 {
	static long[] factorial = new long[101];
	static int M,N;
	static final long modNum=1000000007;
	
	

	public static long permutation(int a, int b) {
		return factorial[a]/(factorial[a-b]);
	}
	
	public static long combination(int n, int r) {
		return factorial[n]/(factorial[n-r]*factorial[r]);
	}
	
/*	public static long test(int a, int b) {
		
		
//		return;
	}*/
	
	public static long redundant(int a, int b) {
		long result=1;
		for(int i=0; i<b;i++) {
			result *= a;
		}
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		factorial[0]=1;
		for(int i=1; i<101; i++) {
			factorial[i]=i*factorial[i-1];
		}
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			M=sc.nextInt();
			N=sc.nextInt();
			long result=0;
			if(N==M) {
				result=factorial[N]%modNum;
			}
			else {
				//result=(permutation(N, M)*redundant(M, N-M))%modNum;
				//result=test(M, N)%modNum;
			}
			
			System.out.println("#"+test+" "+result);
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
