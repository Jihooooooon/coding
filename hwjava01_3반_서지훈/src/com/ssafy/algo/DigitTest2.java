package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int a1= 100;
		int a2= sc.nextInt();
		System.out.printf("%4d%4d", a1, a2);
		while(true) {
			
			int result = a1-a2;
			System.out.printf("%4d", result);
			a1=a2;
			a2=result;
			if(result <0) {
				break;
			}
		}
		
	}

}
