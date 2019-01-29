package ssafy0128;

import java.util.Scanner;

public class Solution2070 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int i=1; i<=testCase; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.print("#"+i+" ");
			if(a<b) {
				System.out.print("<");
			}
			else if(a==b) {
				System.out.print("=");
			}
			else {
				System.out.print(">");
			}
		}
	}

}
