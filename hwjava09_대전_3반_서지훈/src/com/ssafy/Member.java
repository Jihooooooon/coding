package com.ssafy;

public class Member {
	private int id;
	private int tel;
	private String name;
	private int age;

	

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTel() {
		return tel;
	}
	public void setTel(int tel) {
		this.tel = tel;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Member() {
		
	}
	@Override
	public String toString() {
		return "회원정보 id:" + id + ", tel:" + tel + ", name:" + name + ", age:" + age + "";
	}
	public Member(int id, int tel, String name, int age) {
		super();
		this.id = id;
		this.tel = tel;
		this.name = name;
		this.age = age;
	}
	
	
	

}
