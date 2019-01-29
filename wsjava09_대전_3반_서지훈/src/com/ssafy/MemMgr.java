package com.ssafy;

import java.util.ArrayList;
import java.util.Iterator;

public class MemMgr extends Mgr<Member>{
	private static MemMgr memMgr;
	private ArrayList<Member> memList;
	private Iterator<Member> iter;
	
	public ArrayList<Member> getMemList() {
		return memList;
	}

	public void setMemList(ArrayList<Member> memList) {
		this.memList = memList;
	}
	
	

	private MemMgr() {
		super();
		this.memList = new ArrayList<>();
		
	}
	
	public static synchronized MemMgr getInstance() {
		if(memMgr==null) {
			memMgr = new MemMgr();
			return memMgr;
		}
		else {
			return memMgr;
		}
		
	}

	@Override
	public void save(Member o) {
		// TODO Auto-generated method stub
		if(!search(o.getId())) {
			this.memList.add(o);
		}
		else {
			System.out.println("중복된 회원정보입니다.");
		}
	}

	@Override
	public ArrayList<Member> search() {
		// TODO Auto-generated method stub
		return this.memList;
	}
	private boolean search(int id) {
		iter = this.memList.iterator();
		while(iter.hasNext()) {
			if(iter.next().getId()==id) {
				return true;
			}
		}
		return false;
	}


	public Member searchById(int id) {
		iter = this.memList.iterator();
		while(iter.hasNext()) {
			Member temp = iter.next();
			if(temp.getId()==id) {
				return temp;
			}
		}
		return null;
	}

	@Override
	public Member search(Member o) {
		// TODO Auto-generated method stub
		iter = this.memList.iterator();
		while(iter.hasNext()) {
			Member temp = iter.next();
			if(temp.getId()==o.getId() && temp.getName().equals(o.getName()) && temp.getTel()==o.getTel()&& temp.getAge()==o.getAge()) {
				return temp;
			}
		}
		return null;
	}

	public boolean updateName(int id, int number, int age) {
		iter = this.memList.iterator();
		while(iter.hasNext()) {
			Member temp = iter.next();
			if(temp.getId()==id) {
				temp.setTel(number);
				temp.setAge(age);
				return true;
			}
		}
		return false;
	}
	
	public boolean removeById(int id) {
		iter = this.memList.iterator();
		while(iter.hasNext()) {
			Member temp = iter.next();
			if(temp.getId()==id) {
				iter.remove();
				return true;
			}
		}
		return false;
	}




}
