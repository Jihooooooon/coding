package com.ssafy.fifth;

public class Ant {
	
	public static String ant(String ss) {
		StringBuffer sb = new StringBuffer();
		char c = ss.charAt(0);
		int count=1;
		for(int i=1; i< ss.length(); i++) {
			if(c==ss.charAt(i)) {
				count++;
			}
			else {
				sb.append(c);
				sb.append(count);
				c = ss.charAt(i);
				count=1;
			}
		}
		sb.append(c);
		sb.append(count);
				
				
		return sb.toString();	
	}
	
	public static void ant(int stage) {
		String s="11";
		while(stage-->0) {
			System.out.println(s);
			s= ant(s);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ant(10);
	}

}
