package com.ssafy;

import java.util.ArrayList;

public class CarMgr{
	private Car[] cars=new Car[100];
	private int index;

	public void add(Car c) {
		if(this.size()>=100) {
			System.out.println("배열이 꽉차서 더이상 넣을 수 없습니다!!!");
			return;
		}
		if(this.search(c.getNum())!=null) {
			System.out.println("동일한 차량번호가 존재합니다.");
			return;
		}
		this.cars[index++]=c;
	}
	
	public Car[] search() {
		Car[] temp = new Car[this.size()];
		for(int i=0; i<this.size(); i++) {
			temp[i]=cars[i];
		}
		return temp;
	}
	
	public Car search(String num) {
		Car temp=null;
		for(int i=0; i<this.size(); i++) {
			if(cars[i].getNum().equals(num)) {
				temp=cars[i];
				break;
			}
		}
		return temp;
	}
	
	public Car[] search(int price) {
		ArrayList<Car> temp = new ArrayList() {};
		for(int i=0; i<this.size(); i++) {
			if(cars[i].getPrice()<price) {
				temp.add(cars[i]);
			}
		}
		return temp.toArray(new Car[temp.size()]);
	}
	
	public void update(String num, int price) {
		for(int i=0; i<this.size(); i++) {
			if(cars[i].getNum().equals(num)) {
				this.cars[i].setPrice(price);
			}
		}
	}
	public void delete(String nume) {
		for(int i=0; i<this.size(); i++) {
			if(cars[i].getNum().equals(nume)) {
				cars[i]=null;
				for(int j=i+1; j<this.size(); j++) {
					cars[j-1]=cars[j];
				}
				this.index--;
			}
		}
	}
	public int size() {
		return this.index;
	}
	
	public int totalPrice() {
		int result=0;
		for(int i=0; i<this.size(); i++) {
			result+= this.cars[i].getPrice();
		}
		return result;
	}
	
}
