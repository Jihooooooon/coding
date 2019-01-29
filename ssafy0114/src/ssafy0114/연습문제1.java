package ssafy0114;

import java.util.Arrays;

public class 연습문제1 {
	static int[] dx= {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[][] arr = new int[5][5];
	
	public static int solution(int[][] arr, int row, int col) {
		int result=0;
		for(int i=0; i<4; i++) {
			int dRow = row+dx[i];
			int dCol = col+dy[i];
			if(dRow<0 || dRow >=5 ||dCol<0 || dCol >=5) {
				continue;
			}
			else {
				result = Math.abs(arr[dRow][dCol]-arr[row][col]);
			}
		}
			
		return result;
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result=0;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				arr[i][j]= (int)(Math.random()*25+1);
			}
		}
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				
				System.out.format("%-4d",arr[i][j]);
				result += solution(arr, i, j);
			}
			System.out.println();
		}
		System.out.println("총합 : "+result);
		
	}

}
