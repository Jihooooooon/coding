package com.ssafy;

import java.util.ArrayList;

public class Test6 {

	public static void main(String[] args) throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		ArrayList<Grade> grades = new ArrayList<>();
		grades.add(new Grade(100,80,70));
		Grade2 g1 = new Grade2(100,80,70);
		Grade2 g2 =(Grade2)g1.clone();
		g2.setAlgol(90);
		System.out.println(g1);
		System.out.println(g2);
	}

}
