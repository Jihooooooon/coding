package ssafy0128;

import java.util.Scanner;

public class Solution2071 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase =sc.nextInt();
		for(int test=1; test<=testCase ;test++) {
			double sum=0;
			double count=0;
			for(int i=0; i<10; i++) {
				sum+= sc.nextDouble();
				count++;
			}
			System.out.format("#%d %.0f\n", test, (sum/count));
			//
		}

	}

}
