package com.ssafy;

public class Car {

	private String num;
	private String model;
	private int price;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Car() {
		this.num = "";
		this.model = "";
		this.price = 0;

	}

	public Car(String num, String model, int price) {
		this.num = num;
		this.model = model;
		this.price = price;
	}

	public String toString() {
		return String.format("차량번호:%s 모델:%s 가격:%d", this.getNum(),this.getModel(),this.getPrice());
	}
}
