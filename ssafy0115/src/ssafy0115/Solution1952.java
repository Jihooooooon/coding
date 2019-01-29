package ssafy0115;

import java.util.Arrays;
import java.util.Scanner;



public class Solution1952 {
	static Scanner sc = new Scanner(System.in);
	static int[][] dp;
	static int[] cost= new int[4];
	static int[] guest = new int[12];
	public static void main(String[] args) {
		int testCase =sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			for(int i=0; i<4;i++) {
				cost[i]=sc.nextInt();
			}
			guest[0]=sc.nextInt();
			for(int i=1; i<12;i++) {
				guest[i]=sc.nextInt()+guest[i-1];
				
			}
			dp = new int[3][12];
			//1일치 계산
			for(int i=0; i<12; i++) {
				dp[0][i]=cost[0]*guest[i];
			}
			//한달치 계산
			dp[1][0]=(int)Math.min(dp[0][0], cost[1]);
			for(int i=1; i<12;i++) {
				dp[1][i]=dp[1][i-1]+(int)Math.min(dp[0][i]-dp[0][i-1], cost[1]);
			}
			//3달치 계산
			dp[2][0]=dp[1][0];
			dp[2][1]=dp[1][1];
			dp[2][2]=(int)Math.min(dp[1][2], cost[2]);
			
			for(int i=3; i<12;i++) {
				dp[2][i]=(int)Math.min(dp[2][i-1]+(dp[1][i]-dp[1][i-1]), dp[2][i-3]+cost[2]);
				
			}
			//1년치 계산
			int result = (int)Math.min(dp[2][11], cost[3]);
			System.out.println(Arrays.toString(cost));
			System.out.println(Arrays.toString(guest));
			System.out.println(Arrays.toString(dp[0]));
			System.out.println(Arrays.toString(dp[1]));
			System.out.println(Arrays.toString(dp[2]));
			System.out.println("#"+test+" "+result);
		}
	}
}
