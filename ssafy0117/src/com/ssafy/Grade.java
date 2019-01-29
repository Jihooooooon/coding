package com.ssafy;

import java.util.Objects;

public class Grade {
	private int algol;
	private int java;
	private int web;
	
	private int total;
	private double avg;
	
	public Grade() {}
	public Grade(int algol, int java, int web) {
		super();
		this.algol = algol;
		this.java = java;
		this.web = web;
	}
	public int getAlgol() {
		return algol;
	}
	public void setAlgol(int algol) {
		this.algol = algol;
		this.getAvg();
	}
	public int getJava() {
		return java;
	}
	public void setJava(int java) {
		this.java = java;
		this.getAvg();
	}
	public int getWeb() {
		return web;
	}
	public void setWeb(int web) {
		this.web = web;
		this.getAvg();
	}
	public int getTotal() {
		this.total=this.algol+this.java+this.web;
		return total;
	}
	
	public double getAvg() {
		this.avg=this.getTotal()/3.0;
		return avg;
	}
	
	@Override
	public String toString() {
		this.getAvg();
		return "Grade [algol=" + algol + ", java=" + java + ", web=" + web + ", total=" + total + ", avg=" + avg + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + algol;
		long temp;
		temp = Double.doubleToLongBits(avg);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + java;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
	
		Grade other = (Grade) obj;
		return algol == other.algol && this.web == other.getWeb()
				&& java == other.java;
	}
	
	
	
	
}
