package com.ssafy.java;

public class Lotto {
	
	public static int[] lots;
	
	public static int makeNum() {
		return (int) ((Math.random() * 45) + 1);
	}

	public static boolean contains(int m) {
	
		for (int i = 0; i < lots.length; i++) {
			if (m == lots[i]) {
				return true;
			}
		}
		return false;
	}

	public static void make() {
		lots = new int[6];
		int count = 0;
		while (count != lots.length) {
			int temp = makeNum();
			if (!contains(temp)) {
				lots[count++] = temp;
			}
		}
	
	}
	
	

	public static void print() {
		// TODO Auto-generated method stub
		for(int i=0; i<lots.length; i++)
		{
			System.out.printf("%d\t",lots[i]);
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		make();
		print();
	}

}
