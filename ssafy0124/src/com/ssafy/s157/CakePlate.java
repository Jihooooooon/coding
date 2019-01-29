package com.ssafy.s157;
public class CakePlate {
	private int breadCount=0;
	public CakePlate() {
	}
	public synchronized void makeBread(){
		if(breadCount>=10){
			try{
				System.out.println("모두 꽉차다");
				wait();
			}catch(InterruptedException ire){}
		}
		breadCount++;  // ���� 10���� �ȵǸ� �� ������.
		System.out.println("Bake makes breads : "+breadCount+"number");
		this.notifyAll();
	}
	public synchronized void eatBread(){
		if(breadCount<1){
			try{
				System.out.println("접시가 비었다.");
				wait();
			}catch(InterruptedException ire){}
		}
		breadCount--;  // ���� ������ ����.
		System.out.println("빵하나먹음 : "+breadCount+"number");
		this.notifyAll();
	}
}
