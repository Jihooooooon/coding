package com.ssafy.edu.second;

import java.util.Scanner;

public class Diamond2 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = sc.nextInt();
		for(int i=0; i<num; i++) {
			if(i<=num/2) {
				for(int j=num/2-i; j>0;j--) {
					System.out.print("%2s");
				}
				for(int j=0; j<2*i+1;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
			else {
				for(int j=0; j<i-num/2;j++) {
					System.out.print(" ");
				}
				for(int j=0; j<num-(i-num/2)*2;j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
