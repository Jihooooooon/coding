package com.ssafy;

public class TV {

	private int product_num;
	private String product_name;
	private int product_price;
	private int product_stock;
	private int product_size;
	private String product_display_info;

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

	public int getProduct_size() {
		return product_size;
	}

	public void setProduct_size(int product_size) {
		this.product_size = product_size;
	}

	public String getProduct_display_info() {
		return product_display_info;
	}

	public void setProduct_display_info(String product_display_info) {
		this.product_display_info = product_display_info;
	}

	public TV() {
		
	}

	public TV(int product_num,String product_name, int product_price, int product_stock, int product_size, String product_display_info) {
		this.product_num=product_num;
		this.product_name=product_name;
		this.product_price=product_price;
		this.product_stock=product_stock;
		this.product_size=product_size;
		this.product_display_info=product_display_info;
	}
	
	public String toString() {
		return String.format("%-10d | %-20s | %-10d | %-10d | %-8d | %-10s", product_num,product_name,product_price,product_stock,product_size,product_display_info);
	}
}
