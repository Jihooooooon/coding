package com.ssafy;

import java.time.format.TextStyle;
import java.util.Scanner;

public class Samgsung4530 {

	static Scanner sc = new Scanner(System.in);


	public static long countFloor(long a) {
		long tempCount = 0;
		long temp = a;
		//int[] arr = new int[12];
		for(int i=0; i<12; i++) {
			int tempNum = (int)(a%10);
			a /=10;
		
			tempNum = tempNum>4? tempNum-1: tempNum;
			tempCount += tempNum*Math.pow(9, i);
			if(a==0) {
				break;
			}
		}

		return tempCount;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = sc.nextInt();
		for(int testCase=1; testCase<=test; testCase++) {
			long a = sc.nextLong();
			long b = sc.nextLong();
			long result =0;
			if(0<a) {
				result = countFloor(b)-countFloor(a);
				System.out.println("#"+testCase+" "+result);	
			}
			else if(b<0) {
				result = countFloor(-a)-countFloor(-b);
				System.out.println("#"+testCase+" "+result);
			}
			else if(a*b<0) {
				result = countFloor(-a)+countFloor(b)-1;
				System.out.println("#"+testCase+" "+result);
			}
			
		}
	}

}
