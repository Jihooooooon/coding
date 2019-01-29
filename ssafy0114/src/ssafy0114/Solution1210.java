package ssafy0114;

import java.util.Scanner;

public class Solution1210 {
	static Scanner sc = new Scanner(System.in);
	static int[][] map = new int[100][100];
	static int result;
	public static boolean moveLeft(int startX, int startY) {
		boolean isM=false;
		if(startY-1>=0 && map[startX][startY-1]==1) {
			isM=true;
		}
		return isM;
	}
public static boolean moveRight(int startX, int startY) {
	boolean isM=false;
	if(startY+1<100 && map[startX][startY+1]==1) {
		isM=true;
	}
	return isM;
	}
	
	public static void solution(int startX, int startY,boolean canMoveRight, boolean canMoveLeft) {
		if(startX==0) {
			result = startY;
			return;
		}
		
		if(moveLeft(startX, startY)&&canMoveLeft) {
			solution(startX, startY-1,false,true);
		}
		else if(moveRight(startX, startY)&&canMoveRight) {
			solution(startX, startY+1,true,false);
		}
		else {
			solution(startX-1, startY,true,true);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int t=1; t<=10; t++) {
			int testCase = sc.nextInt();
			int startX=0;
			int startY=0;
			for(int i=0; i<100; i++) {
				for(int j=0; j<100; j++) {
					map[i][j]=sc.nextInt();
					if(map[i][j]==2) {
						startX=i;
						startY=j;
					}
				}
			}
			solution(startX, startY, true, true);
			System.out.println("#"+testCase+" "+result);
			
			
		}

	}

}
