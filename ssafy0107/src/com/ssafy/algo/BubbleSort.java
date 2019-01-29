package com.ssafy.algo;

public class BubbleSort {
	
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
		int[] test = {3,5,1,2,8,9,17,12,13};
		
		bubbleSort(test);
		for(int i : test) {
			System.out.print(i+" ");
		}
		
	}

}
