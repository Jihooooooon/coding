package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution2 {
	static int[] dp=new int[1001]; 
	
	public void solution() {
		int testcase = sc.nextInt();
		for(int test=1; test<=testcase; test++) {
			int arrSize = sc.nextInt();
			int inputArr[] = new int[arrSize];
			int max=0;
			for(int i=0; i<arrSize; i++) {
				inputArr[i]=sc.nextInt();
			}
			
			for(int i=0; i<arrSize; i++) {
				dp[i]=1;
				for(int j=0; j<i; j++) {
					if(inputArr[i]>=inputArr[j]) {
						dp[i]= dp[i]<dp[j]+1? dp[j]+1 :dp[i];
					}
				}
				if(max<dp[i]) {
					max=dp[i];
				}
			}
			System.out.println("#"+test+" "+ max);
			Arrays.fill(dp, 0);
		
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Solution2().solution();
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
