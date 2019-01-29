package com.ssafy.edu.w23g;

import java.io.File;
import java.util.ArrayList;

public class StudentTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname="student.obj";
		String path="ssafy";
		String name=path+File.separator+fname;
		StudentSchool ss = new StudentSchool();
		ArrayList<Student> sts = new ArrayList<>();
		sts.add(new Student("s0130320","이동규",25));
		sts.add(new Student("s0130321","양동구",26));
		sts.add(new Student("s0130322","유동관",24));
		sts.add(new Student("s0130325","박종찬",27));
		
		ss.saveObj(name, sts);
		

	}

}
