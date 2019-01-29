package com.ssafy.edu.w23g;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class IOTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw =null;
		String msg="";
		//키보드 -> EOF ->CTRL+c->z
		try {
			pw = new PrintWriter(new FileWriter("ssafy\\a.txt",true), true);
			while((msg=br.readLine())!=null) {
				System.out.println(msg);
				pw.println(msg);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		finally {
			if(pw!=null) {
				pw.close();
			}
		}
		
	}

}
