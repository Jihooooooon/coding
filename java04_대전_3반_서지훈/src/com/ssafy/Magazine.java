package com.ssafy;

public class Magazine {
	public String isbn;
	public String title;
	public String author;
	public String publisher;
	public int year;
	public int month;
	public int price;
	public String desc;
	
	public Magazine(String isbn,String title,String author,String publisher,int year, int month, int price,String desc) {
		this.isbn=isbn;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.year = year;
		this.month = month;
		this.price=price;
		this.desc=desc;
	}
	
	public String toString() {
		return String.format("%-10s | %-25s | %-6s | %-10s | %-9d | %-12s | %-4d.%2d \n", isbn,title,author,publisher,price,desc,year,month);
	}
}
