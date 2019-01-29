package ssafy0114;

import java.util.Scanner;

public class Solution {

	static Scanner sc = new Scanner(System.in);
	static int N;
	public static int countMap(int[][] map,int a, int b) {
		int result=0;
		for (int i = 0; i < N; i++) {
			if(map[i][b]==1) {
				result++;
			}
		}
		for (int i = 0; i < N; i++) {
			if (i == b)
				continue;
			if(map[a][i] ==1) {
				result++;
			}
		}
		return result;
	}
	public static int solution(int[][] map) {
		int result=0;
		for(int i=0; i<N;i++) {
			for(int j=0; j<N; j++) {
				
				int temp=countMap(map, i, j);
				if((temp%2)==1) {
					result++;
				}
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			N=sc.nextInt();
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					char temp = s.charAt(j);
					int tempResult = 0;
					if (temp == 'B') {
						
						tempResult = 1;
						
					}
					map[i][j] = tempResult;
				}
			}
			System.out.println("#"+test+" "+solution(map));
			
		}
	}
}
