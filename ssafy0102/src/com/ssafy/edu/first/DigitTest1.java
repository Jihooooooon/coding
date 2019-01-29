package com.ssafy.edu.first;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start=1;
		for(int i=0; i<5; i++) {
			for(int j=i ; j>0; j--) {
				System.out.print("\t");
			}
			for(int j=i; j<5; j++) {
				System.out.print(start+"\t");
				start++;
			}
			System.out.println();
			System.out.println();
			
		}
	}

}
