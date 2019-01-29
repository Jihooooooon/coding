package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution3 {
	
	public void swap(double[][] input, int a, int b) {
		double temp1=input[a][0];
		double temp2=input[a][1];
		input[a][0]=input[b][0];
		input[a][1]=input[b][1];
		input[b][0]= temp1;
		input[b][1]=temp2;
	}
	public void sort(double[][] input,int[][] inputArr) {
		for(int i=0; i<input.length-1;i++) {
			int temp=i;
			for(int j=i+1; j<input.length;j++) {
				if(input[temp][0]<input[j][0]) {
					temp=j;
				}
				if(input[temp][0]==input[j][0]) {
					if(inputArr[temp][1] >inputArr[j][1])
					temp=j;
				}
			}
			swap(input,i,temp);
		}
	}
	public void solution() {
		int testcase = sc.nextInt();
		for(int i=1; i<=testcase; i++) {
			int arrSize = sc.nextInt();
			int maxCal = sc.nextInt();
			int[][] inputArr = new int[arrSize][2];
			double[][] temp = new double[arrSize][2];
			for(int j=0; j<arrSize; j++) {
				inputArr[j][0] = sc.nextInt();
				inputArr[j][1] = sc.nextInt();
				temp[j][0] = (double)inputArr[j][0]/(double)inputArr[j][1];
				temp[j][1]=j;
			}
			sort(temp, inputArr);
			int total=0;
			for(int j=0; j<temp.length; j++) {
				if(maxCal>=inputArr[(int)temp[j][1]][1]) {
					maxCal-=inputArr[(int)temp[j][1]][1];
					total+=inputArr[(int)temp[j][1]][0];
				}
			}
			System.out.println("#"+i+" "+total);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Solution3().solution();
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
