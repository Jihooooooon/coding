package com.ssafy.algo;

public class ToBinaryByRecursive {

	
	public static void recursive(int cnt, int index, StringBuffer sb) {
		if(index==cnt) {
			System.out.println(sb.toString());
			return;
		}
		for(int i=0; i<=1; i++) {
			sb.append(i);
			recursive(cnt,index+1,sb);
			sb.deleteCharAt(index);
		}
		
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb =new StringBuffer();
		recursive(3,0,sb);
	}

}
