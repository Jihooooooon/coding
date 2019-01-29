package com.ssafy.edu.j2;

public class MyRunnable implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 300; i++) {
			System.out.printf(Thread.currentThread().getName());
		}
		
	}

}
