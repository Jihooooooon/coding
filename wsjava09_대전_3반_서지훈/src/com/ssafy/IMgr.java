package com.ssafy;

import java.util.ArrayList;

public interface IMgr<T> {
	void save(T o);
	ArrayList<T> search();
	T search(T o);
	
	
}
