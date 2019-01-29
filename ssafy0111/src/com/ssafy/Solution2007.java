package com.ssafy;

import java.util.Scanner;

import javax.xml.transform.Templates;

public class Solution2007 {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = sc.nextInt();
		for(int test=1; test<=t; test++) {
			String str = sc.next();
			String temp="";
			
			int strLength=10;
			boolean isD;
			for(int i=1; i<10; i++) {
				isD=false;
				temp = str.substring(0, i);
				for(int j=i; j+temp.length()<=30; j+=temp.length()) {
					String temp2 = str.substring(j,j+temp.length());
					if(!temp.equals(temp2)) {
						isD=true;
						break;
					}
					
				}
				if(!isD&& temp.length()<=10)
					strLength = strLength>temp.length()?temp.length():strLength;
				
			}
			System.out.println("#"+test+" "+strLength);
		}

	}

}
