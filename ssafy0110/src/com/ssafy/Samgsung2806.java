package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Samgsung2806 {
	static Scanner sc = new Scanner(System.in);
	static int[][] map = new int[12][12];

	static int n;
	static int result;
	
	public static int nQueen(int depth) {

		int res = 0;
		 
	    if (depth == n)
	    {
	        for (int i = 1; i <= n; i++)
	        {
	        	if(map[depth][i]==0) {
	        		res++;
	        	}
	        }
	        return res;
	    }
	 
	 
	    for (int i = 1; i <= n; i++)
	    {
	        if (map[depth][i] == 0)
	        {
	            int cnt = 1;
	            for (int j = depth + 1; j <= n; j++)
	            {
	                if (i - cnt > 0) map[j][i - cnt]++;
	                if (i + cnt <= n) map[j][i + cnt]++;
	                map[j][i]++;
	                cnt++;
	            }
	 
	            res += nQueen(depth + 1);
	 
	            cnt = 1;
	            for (int j = depth + 1; j <= n; j++)
	            {
	                if (i - cnt > 0) map[j][i - cnt]--;
	                if (i + cnt <= n) map[j][i + cnt]--;
	                map[j][i]--;
	                cnt++;
	            }
	        }
	    }
	 
	    return res;
	 
	}

	public static void main(String[] args) {
		int t=sc.nextInt();
		for(int test=1; test<=t; test++) {
			n=sc.nextInt();
			result=nQueen(1);
			
			System.out.println("#"+test+" "+result);
			result=0;
			
		}
	}
}
