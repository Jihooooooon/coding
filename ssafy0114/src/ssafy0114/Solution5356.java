package ssafy0114;

import java.util.Scanner;

public class Solution5356 {
	static Scanner sc = new Scanner(System.in);
	
	public static String solution(char[][] arr, int maxLen) {
		StringBuffer sb = new StringBuffer();
		for(int j=0; j<maxLen; j++) {
			for(int i=0; i<5; i++) {
				if(arr[i][j]=='\u0000') {
					continue;
				}
				sb.append(arr[i][j]);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			char[][] tempArr = new char[5][15];
			int maxLen=0;
			for(int i=0; i<5; i++) {
				String s = sc.next();
				maxLen = maxLen<s.length()? s.length():maxLen;
				for(int j=0; j<s.length(); j++) {
					tempArr[i][j]=s.charAt(j);
				}
			}
			System.out.println("#"+test+" "+solution(tempArr, maxLen));
			
		}
		

	}

}
