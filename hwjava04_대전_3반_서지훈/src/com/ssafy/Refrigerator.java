package com.ssafy;

public class Refrigerator {
	private int product_num;
	private String product_name;
	private int product_price;
	private int product_stock;
	private int product_L;

	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public int getProduct_price() {
		return product_price;
	}

	public void setProduct_price(int product_price) {
		this.product_price = product_price;
	}

	public int getProduct_stock() {
		return product_stock;
	}

	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}

	public int getProduct_L() {
		return product_L;
	}

	public void setProduct_L(int product_L) {
		this.product_L = product_L;
	}

	public Refrigerator() {

	}

	public Refrigerator(int product_num, String product_name, int product_price, int product_stock,int product_L) {
		this.product_num = product_num;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_stock = product_stock;
		this.product_L = product_L;

	}
	
	public String toString() {
		return String.format("%-10d | %-20s | %-10d | %-10d | %-8d ", product_num,product_name,product_price,product_stock,product_L);
	}

}
