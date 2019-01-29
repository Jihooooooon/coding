package com.ssafy.edu.w23g;

import java.io.Serializable;

public class Student implements Cloneable,Serializable {
	

	private static final long serialVersionUID = -1924195052069478430L;
	@Override
	protected Object clone()  {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO: handle exception
			return this;
		}
		
	}
	private String id;
	private String name;
	private int ban;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getBan() {
		return ban;
	}
	public void setBan(int ban) {
		this.ban = ban;
	}
	public Student() {
		super();
	}
	public Student(Student st) {
			this(st.getId(),st.getName(),st.getBan());
	}
	public Student(String id, String name, int ban) {
		super();
		this.id = id;
		this.name = name;
		this.ban = ban;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		Student other = (Student) obj;
		return this.id.equals(other.getId());
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", ban=" + ban + "]";
	}
	
	

}
