package com.ssafy;

public class Magazine extends Book {
	
	private int year;
	private int month;



	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
	public Magazine() {
		super();
	}


	public Magazine(String isbn, String title, String author, String publisher, int year, int month, int price,
			String desc) {
		super(isbn, title, author, publisher, price, desc);
		this.year = year;
		this.month = month;
		
		
	}
	@Override
	public String toString() {
		return String.format("%-10s | %-25s | %-6s | %-10s | %-9d | %-12s | %-4d.%2d \n", getIsbn(), getTitle(), getAuthor(),
				getPublisher(), getPrice(), getDesc(), year, month);
	}
}
