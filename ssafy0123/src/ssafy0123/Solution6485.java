package ssafy0123;

import java.util.Scanner;

public class Solution6485 {
	static Scanner sc = new Scanner(System.in);
	static int N,P;
	static int[] pass ;
	static int[] busStop ;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			N=sc.nextInt();
			pass = new int[5001];
			for(int i=1; i<=N; i++) {
				int start=sc.nextInt();
				int end=sc.nextInt();
				for(int j=start; j<=end; j++) {
					pass[j]++;
				}
			}
			P=sc.nextInt();
			busStop = new int[P+1];
			for(int i=1; i<=P; i++) {
				busStop[i]=pass[sc.nextInt()];
			}
		
			System.out.print("#"+test);
			for(int i=1; i<=P; i++) {
				System.out.print(" "+busStop[i]);
			}
		
		}
	}

}
