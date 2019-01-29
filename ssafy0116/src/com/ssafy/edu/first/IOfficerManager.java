package com.ssafy.edu.first;

public interface IOfficerManager {
	void add(Officer off);
	Officer findByNo(int no);
	Officer[] findByPosition(String posing);
	int size();
	Officer[] findAll();
	
	Header[] findAllHeader();
	
}
