package com.ssafy.edu.first;

public class DigitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start = 1;
		for (int i = 0; i < 5; i++) {
			if (i <= 2) {
				for (int j = i; j > 0; j--) {
					System.out.print("\t");
				}
				for (int j = 0; j < 5 - 2 * i; j++) {
					System.out.print(start + "\t");
					start++;
				}
				for (int j = i; j > 0; j--) {
					System.out.print("\t");
				}
				System.out.println();
				System.out.println();
			} else {
				for (int j = 0; j < (5 - i) / 2; j++) {
					System.out.print("\t");
				}
				for (int j = 0; j < 5 - (((5 - i) / 2) * 2); j++) {
					System.out.print(start + "\t");
					start++;
				}
				for (int j = 0; j < (5 - i) / 2; j++) {
					System.out.print("\t");
				}
				System.out.println();
				System.out.println();
			}
		}
	}

}
