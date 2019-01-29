package ssafy1022;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution1225 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			int testCase = sc.nextInt();
			Queue<Integer> que =  new LinkedList<Integer>();
			for(int j=0; j<8;j++) {
				que.add(sc.nextInt());
			}
			int del=0;
			int cnt=0;
			while(true) {
				
				int temp = que.poll();
				temp-=++del;
				
				if(temp<=0) {
					cnt++;
					temp=0;
					que.add(temp);
					break;
				}
				else {
					cnt++;
					que.add(temp);
				}
				if(cnt==5) {
					cnt=0;
					del=0;
				}
			}
			System.out.print("#"+testCase);
			for(int t=0; t<8;t++) {
				System.out.print(" "+que.poll());
			}
			System.out.println();
		}
	}

}
