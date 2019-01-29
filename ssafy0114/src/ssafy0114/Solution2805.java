package ssafy0114;

import java.util.Scanner;

public class Solution2805 {
	static Scanner sc = new Scanner(System.in);
	static int N;

	public static int solution(int[][] arr) {
		int result = 0;
		int pivot = arr.length / 2;

		for (int i = 0; i < N; i++) {

			for (int j = Math.abs(pivot - i); j < arr.length - Math.abs(-pivot + i); j++) {
				result += arr[i][j];

			}

		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for (int test = 1; test <= testCase; test++) {
			N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					arr[i][j] = s.charAt(j) - '0';
				}
			}
			System.out.println("#" + test + " " + solution(arr));

		}
	}

}
