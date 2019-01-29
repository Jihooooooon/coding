package com.ssafy.algo;

import java.util.Scanner;

public class Samg6718 {
	static Scanner sc = new Scanner(System.in);
	
	public static int makeScore(int n)
	{
		if(n<100)
		{
			return 0;
		}
		else if(100<=n && n<1000) {
			return 1;
		}
		else if(1000<= n && n <10000)
		{
			return 2;
		}
		else if(10000<= n && n < 100000) {
			return 3;
		}
		else if(100000 <= n && n < 1000000) {
			return 4;
		}
		else {
			return 5;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int testcase = sc.nextInt();
		for (int i = 1; i <= testcase; i++) {
			int n = sc.nextInt();
			System.out.println("#"+i+" "+makeScore(n));
		}

	}

}
