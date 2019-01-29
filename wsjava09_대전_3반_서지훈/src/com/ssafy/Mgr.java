package com.ssafy;

import java.util.ArrayList;

public abstract class Mgr<T> implements IMgr<T> {
	public abstract void save(T o);
	public abstract ArrayList<T> search();
	public abstract T search(T o);

}
