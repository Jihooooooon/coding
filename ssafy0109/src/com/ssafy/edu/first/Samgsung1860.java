package com.ssafy.edu.first;

import java.util.Arrays;
import java.util.Scanner;

public class Samgsung1860 {
	static Scanner sc = new Scanner(System.in);
	static int N, M, K;
	static int totalK;
	static int[] userTime;
	static int beforeTime;
	
	public static void cal(int index) {
		if(index==0) {
			totalK += (userTime[index]/M)*K-1;
			
		}
		else {
			totalK += ((userTime[index]-beforeTime)/M)*K-1;
			
		}
		beforeTime=(userTime[index]/M)*M;
	}

	public static void quickSort(int start, int end) {
		if (start < end) {
			int pivot = partition(start, end);

			quickSort(start, pivot - 1);
			quickSort(pivot + 1, end);
		}
	}

	public static void swap(int a, int b) {
		int temp = userTime[a];
		userTime[a] = userTime[b];
		userTime[b] = temp;
	}

	public static int partition(int start, int end) {
		int pivot = (start + end) / 2;
		int left = start;
		int right = end;
		while (left < right) {
			while (userTime[left] < userTime[pivot] && left < right) {
				left++;
			}
			while (userTime[right] >= userTime[pivot] && left < right) {
				right--;
			}
			
			swap(left, right);
			
		}
		swap(right, pivot);
		return right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int test = sc.nextInt();
		for (int test_case = 1; test_case <= test; test_case++) {
			N = sc.nextInt();// 손님수
			M = sc.nextInt();// 붕어빵 만드는데 걸리는 시간
			K = sc.nextInt();// 붕어빵 수
			userTime = new int[N];
			boolean isE = true;
			for (int i = 0; i < N; i++) {
				userTime[i] = sc.nextInt();

			}
			quickSort(0, N-1);
			//Arrays.sort(userTime);
			System.out.println(Arrays.toString(userTime));
			for (int i = 0; i < userTime.length; i++) {
				cal(i);
				if (totalK < 0) {
					isE = false;
					break;
				}
			}
			if (isE) {
				System.out.println("#" + test_case + " Possible");
			} else {
				System.out.println("#" + test_case + " Impossible");
			}
			totalK = 0;
			beforeTime=0;
		}
	}

}
