package com.ssafy.edu.first;

public class Officer {
	protected int no; // ! Caution -> data hide
	protected String position;
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Officer() {
		super();
		
	}
	public Officer(int no) {
		this(no, "None");
	}
	public Officer(int no, String position) {
		super();
		this.no=no;
		this.position = position;
	}
	
	@Override
	public String toString() {
		return "Officer [no=" + no + ", position=" + position + "]";
	}
}
