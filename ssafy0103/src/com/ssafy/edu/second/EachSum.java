package com.ssafy.edu.second;

import java.util.Scanner;

public class EachSum {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = sc.nextInt();
		int sum=0;
		while(n>0) {
			sum+= n%10;
			n /=10;
		}
		System.out.println(sum);

	}

}
