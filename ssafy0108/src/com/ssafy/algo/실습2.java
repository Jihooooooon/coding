package com.ssafy.algo;

import java.util.Random;

public class 실습2 {
	
	public static void randomDiceSum(int sum) {
		
		int tempA=(int)(Math.random()*7)+1;
		int tempB=(int)(Math.random()*7)+1;
		System.out.println(tempA+" "+tempB);
		if(tempA==tempB) {
			sum+=tempA+tempB;
			System.out.println("end ="+sum);
			return;
		}
		
		randomDiceSum(sum+tempA+tempB);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		randomDiceSum(0);
	}

}
