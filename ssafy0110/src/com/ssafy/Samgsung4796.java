package com.ssafy;

import java.util.Scanner;

public class Samgsung4796 {

	static Scanner sc = new Scanner(System.in);
	static int[] mountain = new int[50000];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				mountain[i] = sc.nextInt();
			}
			int totalCount = 0;
			int up=0;
			int down=0;
			boolean isNew = false;
			boolean mCount=false;
			for(int i=0; i<n-1;i++) {
				int pre = mountain[i];
				int next = mountain[i+1];
				if(pre<next&&!isNew) {
					up++;
				}
				if(pre>next&& up!=0) {
					down++;
					isNew=true;
				}
				if(pre<next &&isNew) {
					totalCount += up*down;
					isNew=false;
					up=1;
					down=0;
				}
			}
			totalCount += up*down;
			System.out.println("#"+t+" "+totalCount);
			}

		}

	}

