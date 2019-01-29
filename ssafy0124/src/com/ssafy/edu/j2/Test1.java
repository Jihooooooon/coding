package com.ssafy.edu.j2;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 0; i < 300; i++) {
			System.out.printf("M");
			
		}
		System.out.println();
		GRunnable my1 = new GRunnable();
	
		
		Thread t1 = new Thread(my1,"J");
		Thread t2 = new Thread(my1,"Q");
		Thread t3 = new Thread(my1,"K");

		t3.setPriority(10);
		t1.start();
		t2.start();
		t3.start();
	

	}

}
