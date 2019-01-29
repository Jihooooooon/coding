package com.ssafy.edu.w23g;

import java.io.File;
import java.util.ArrayList;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname="student.txt";
		String path="ssafy";
		String name=path+File.separator+fname;
		StudentSchool ss = new StudentSchool();
		ArrayList<Student> sts = ss.read(name);
		for(Student s:sts) {
			System.out.println(s);
		}
	}

}
