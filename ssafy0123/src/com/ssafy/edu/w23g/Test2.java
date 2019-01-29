package com.ssafy.edu.w23g;

import java.io.File;

public class Test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("C:\\SSAFY1");
		if(!f.exists()) {
			f.mkdirs();
		}
		if(f.isDirectory()) {
			File[] fs=f.listFiles();
			for(File temp:fs) {
				System.out.println(temp);
			}
		}
	}

}
