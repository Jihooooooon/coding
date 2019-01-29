package com.ssafy.algo;

import java.util.Scanner;

public class Gravity {
	
	static Scanner sc = new Scanner(System.in);
	static int maxLength=0;
	
	public void moveBlock(int i, int j) {
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int[] input = { 7, 4, 2, 0, 0, 6, 0, 7, 0 };
		int[] move = new int[input.length];// 각자리수 블록이 이동한 거리
		int length = input.length;
		
		//맨 밑에서 부터 이동해준다.
		for (int i = length - 1; i >= 0; --i) {
			int j = i;
			//이동할려는 블록이 0일 경우  pass
			if(input[i]==0) {
				//j++;
				continue;
			}
			int temp=i;
			//temp기준으로 한칸씩 내려가면서 검사
			while(++j<input.length) {
				//0일경우 통째로 자리이동
				if(input[j]==0) {
					input[j]=input[temp];
					input[temp]=0;	
					temp++;
					move[i]++;
				}
				//0이 아닐경우  작을경우는 이동하지 않고 클경우 그 차이만큼 이동
				else if(input[temp]>input[j]) {
					int result=input[temp]-input[j];
					input[j]+=input[temp]-input[j];
					input[temp]-=result;
					temp++;
					move[i]++;
				}
				
			}
		}
		for(int i=0; i<length; i++) {
			maxLength = maxLength<move[i]?move[i]:maxLength;
		}
		System.out.println(maxLength);
	}

}
