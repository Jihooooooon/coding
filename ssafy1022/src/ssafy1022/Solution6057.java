package ssafy1022;

import java.util.Scanner;
import java.util.Stack;

public class Solution6057 {
	static Scanner sc = new Scanner(System.in);
	static int N,M;
	static boolean[][] arr;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			N=sc.nextInt();
			M=sc.nextInt();
			arr = new boolean[N+1][N+1];
			
			int totalCount=0;
			for(int i=0; i<M; i++) {
				int temp1 = sc.nextInt();
				int temp2 = sc.nextInt();
				arr[temp1][temp2]=arr[temp2][temp1]=true;
			}
			for(int i=1; i<=N-2; i++) {
				for(int j=i+1; j<=N-1; j++) {
					if(!arr[i][j]) continue;
					for(int k=j+1; k<=N; k++) {
						if(!arr[i][k]) continue;
						if(!arr[j][k]) continue;
						totalCount++;
					}
				}
			}
	
			System.out.println("#"+test+" "+totalCount);
		}
	}
	
}
