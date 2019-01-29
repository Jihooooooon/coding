package com.ssafy.edu.first;

public class Employee extends Officer {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int no, String position,String name) {
		super(no, position);
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	public Employee(int no, String name) {
		this(no,"None",name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [no=" + no + ", position=" + position +",name="+name+ "]";
	}
}
