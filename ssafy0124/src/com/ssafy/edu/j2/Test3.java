package com.ssafy.edu.j2;

public class Test3 {

	public static void main(String[] args) {
		SRunnable my1 = new SRunnable();
		Thread t1 = new Thread(my1,"J");
		Thread t2 = new Thread(my1,"Q");
		Thread t3 = new Thread(my1,"K");

		t1.start();
		t2.start();
		t3.start();
	
	}
}
