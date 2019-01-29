package ssafy0114;

import java.util.Scanner;

public class Solution1979 {
	//흰색 1 검은색 0
	static Scanner sc = new Scanner(System.in);
	static int N,K;
	static int result;
	static int[][] arr;
	
	public static void scanX() {
		for(int i=0; i<N; i++) {
			int maxLen=0;
			for(int j=0; j<N; j++) {
				if(arr[i][j]==0) {
					maxLen=0;
					continue;
				}
				if(arr[i][j]==1) {
					maxLen++;
					if(maxLen==K && (j+1)==N) {
						result++;

					}
					else if(maxLen==K && arr[i][j+1]==0) {
						result++;
					}
					
					
				}
			}
		}
	}
	public static void scanY() {
		for(int j=0; j<N; j++) {
			int maxLen=0;
			for(int i=0; i<N; i++) {
				if(arr[i][j]==0) {
					maxLen=0;
					continue;
				}
				if(arr[i][j]==1) {
					maxLen++;
				
					if(maxLen==K && (i+1)==N) {
						result++;

					}
					else if(maxLen==K && arr[i+1][j]==0) {
						result++;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase =sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			N=sc.nextInt();
			K=sc.nextInt();
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j]=sc.nextInt();
				}
			}
			scanX();
			scanY();
			System.out.println("#"+test+" "+result);
			result=0;
		}
		
	}

}
