package com.ssafy;

import java.util.Arrays;
import java.util.Scanner;

public class Solution1493 {
	static Scanner sc= new Scanner(System.in);
	static int[] info= new int[1000];
	
	public static int[] cal2(int a) {
		int col=0;
		int row=1;
		int pivotD=0;
		int pivotU=0;
		for(int i=1; i<999; i++) {
			pivotD=info[i];
			pivotU=info[i+1];
			if(pivotD<=a && a<pivotU) {
				col = i;
				break;
			}
			
		}
		int temp = a-pivotD;
		row += temp;
		col -= temp;
		
		return new int[] {row,col};
		
	}
	
	public static int cal(int temp1, int temp2) {
		int[] tempArr1=cal2(temp1);
		int[] tempArr2=cal2(temp2);
		int resultR=tempArr1[0]+tempArr2[0];
		int resultC=tempArr1[1]+tempArr2[1];
		int result = info[resultR+resultC-1]+(resultR-1);
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		info[1]=1;
		for(int i=2; i<1000;i++) {
			info[i]+=info[i-1]+(i-1);
		}
		
	
		
		int t= sc.nextInt();
		for(int test=1; test<=t; test++) {
			int temp1 = sc.nextInt();
			int temp2 = sc.nextInt();
			
			
			System.out.println("#"+test+" "+cal(temp1,temp2));
		}
		
	}

}
