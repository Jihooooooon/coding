package com.ssafy.algo;

import java.util.Scanner;

public class Solution2063 {
	static Scanner sc = new Scanner(System.in);
	public static void swap(int[] inputArr, int a, int b) {
		int temp= inputArr[a];
		inputArr[a]=inputArr[b];
		inputArr[b]=temp;
		return;
	}
	
	public static int[] bubbleSort(int[] inputArr) {
		for(int i=0; i<inputArr.length-1; i++) {
			for(int j=0; j<inputArr.length-1-i;j++) {
				if(inputArr[j]>inputArr[j+1]) {
					swap(inputArr,j,j+1);
				}
			}
		}
		return inputArr;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n =sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		bubbleSort(arr);
		System.out.println(arr[n/2]);
		
	}

}
