package com.ssafy.edu.j2;

public class GRunnable implements Runnable {
	int i;
	@Override
	public void run() {
		for (; i < 10; i++) {
			System.out.printf(Thread.currentThread().getName());
		}
		
	}

}
