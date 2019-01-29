package com.ssafy;


public class Book {
	
	public String isbn;
	public String title;
	public String author;
	public String publisher;
	public int price;
	public String desc;
	
	public Book(String isbn,String title,String author,String publisher,int price,String desc) {
		this.isbn=isbn;
		this.title=title;
		this.author=author;
		this.publisher=publisher;
		this.price=price;
		this.desc=desc;
	}
	
	public String toString() {
		return String.format("%-10s | %-25s | %-6s | %-10s | %-9d | %-12s \n", isbn,title,author,publisher,price,desc);
	}

}
