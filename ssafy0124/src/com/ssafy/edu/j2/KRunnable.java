package com.ssafy.edu.j2;

public class KRunnable implements Runnable {

	int i=0;
	@Override
	public synchronized void run() {
		
		for (; i < 300; i++) {
			System.out.printf(Thread.currentThread().getName());
		}
		
	}

}
