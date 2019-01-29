package com.ssafy.edu.w23g;

import java.io.File;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("ssafy2");
		if(!f.exists()) {
			f.mkdirs();
		}
		System.out.println(f.isDirectory());
		System.out.println(f.isFile());
		System.out.println(f.canRead());
		System.out.println(f.lastModified());
	}

}
