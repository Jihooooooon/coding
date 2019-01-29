package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int count[] = new int[10];
		while (true) {
			int inputNum = sc.nextInt();
			if (inputNum == 0) {
				break;
			}
			
			count[inputNum / 10]++;
			
		}

		for (int i = 0; i < 10; i++) {
			if (count[i] == 0) {
				continue;
			}
			System.out.println(i + " : " + count[i] + "개");
		}
	}

}
