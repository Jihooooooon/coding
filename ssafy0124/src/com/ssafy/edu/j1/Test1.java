package com.ssafy.edu.j1;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 300; i++) {
			System.out.printf("M");
			
		}
		System.out.println();
		MyRunnable my1 = new MyRunnable();
		MyRunnable2 my2 = new MyRunnable2();
		MyRunnable3 my3 = new MyRunnable3();
		
		Thread t1 = new Thread(my1);
		Thread t2 = new Thread(my2);
		Thread t3 = new Thread(my3);
		Thread t4 = new Thread(new MyThread1());
		
		t1.start();
	
		t2.start();
		
		t3.start();
		t4.start();
	}

}
