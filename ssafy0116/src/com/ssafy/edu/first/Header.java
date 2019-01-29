package com.ssafy.edu.first;

public class Header extends Officer {
	
	private String car;

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public Header() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Header(int no, String position, String car) {
		super(no, position);
		this.car=car;
		// TODO Auto-generated constructor stub
		System.out.println("Header 1");
	}

	public Header(int no,String car) {
		this(no,"None",car);
		// TODO Auto-generated constructor stub
		System.out.println("Header 2");
	}

	@Override
	public String toString() {
		return "Header [car=" + car + ", no=" + no + ", position=" + position + "]";
	}
	
	
	
}
