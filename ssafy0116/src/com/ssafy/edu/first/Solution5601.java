package com.ssafy.edu.first;

import java.util.Scanner;

public class Solution5601 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase;test++) {
			int n=sc.nextInt();
			System.out.print("#"+test+" ");
			for(int i=0; i<n; i++) {
				if(i+1==n) {
					System.out.print("1/"+n);
				}
				else {
				System.out.print("1/"+n+" ");
				}
			}
		}
	}

}
