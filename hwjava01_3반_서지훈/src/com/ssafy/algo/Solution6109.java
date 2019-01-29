package com.ssafy.algo;

import java.util.Scanner;

public class Solution6109 {
	static Scanner sc = new Scanner(System.in);
	
	

	public static int[][] makeArr(int[][] arr, int arrSize, String direction ) {
		
		if(direction.equals("left")) {
			for(int i=0; i<arrSize; i++) {
				boolean cantMove[] = new boolean[arrSize];
			
		}
		if(direction.equals("right")) {
		
			}
			
		}
		if(direction.equals("up")) {
	
		}
		if(direction.equals("down")) {
	
		}
		
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testcase = sc.nextInt();
		for (int test_case = 1; test_case <= testcase; test_case++) {
			int arrSize = sc.nextInt();
			String direction = sc.next();
			int arr[][] = new int[arrSize][arrSize];
			for (int i = 0; i < arrSize; i++) {
				for (int j = 0; j < arrSize; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[][] temp=makeArr(arr, arrSize, direction);
			for(int i=0; i<arrSize; i++) {
				for(int j=0; j < arrSize; j++) {
					System.out.print(temp[i][j]+" ");
				}
				System.out.println();
			}
		}
	}

}
