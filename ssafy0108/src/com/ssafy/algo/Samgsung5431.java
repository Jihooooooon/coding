package com.ssafy.algo;

import java.util.Arrays;
import java.util.Scanner;

public class Samgsung5431 {
	

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
		int test = sc.nextInt();
		for (int i = 1; i <= test; i++) {
			int N=sc.nextInt();
			int K=sc.nextInt();
			boolean[] isUse = new boolean[N+1];
			for(int j=0; j<K;j++) {
				isUse[sc.nextInt()]=true;
			}
			int count=0;
			int arr[] = new int[N-K];
			for(int j=1; j<N+1;j++) {
				if(!isUse[j]) {
					arr[count++]=j;
				}
			}
			bubbleSort(arr);
			System.out.print("#"+i+"");
			for(int t:arr) {
				System.out.print(" "+t);
			}
			System.out.println();
		}
	}

}
