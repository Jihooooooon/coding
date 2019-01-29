package com.ssafy.edu.first;

import java.util.Arrays;

public class OfficerManager implements IOfficerManager {
	private static OfficerManager officerManager;

	private OfficerManager() {

	}

	public static OfficerManager getInstance() {
		if (officerManager == null) {
			officerManager = new OfficerManager();
		}
		return officerManager;
	}

	private Officer[] office = new Officer[100]; // 객체생성x
	// OfficerManager <>------> Officer aggregation 객체를 가지고 있다.
	private int index;

	@Override
	public void add(Officer off) {
		// TODO Auto-generated method stub
		if (findNo(off.getNo()) != -1) {
			return;
		}
		else {
			this.office[index++] = off;
		}
	}

	private int findNo(int no) {
		int count = -1;
		for (int i = 0; i < office.length; i++) {
			if (office[i] == null) {
				break;
			} else if (office[i].getNo() == no) {
				count = i;
				break;
			}

		}
		return count;
	}

	@Override
	public Officer findByNo(int no) {
		// TODO Auto-generated method stub
		int noo = findNo(no);
		if(noo<0) {
			return null;
		}
		
		return this.office[noo];
		
	}

	@Override
	public Officer[] findByPosition(String posing) {
		// TODO Auto-generated method stub
		int count =0;
		for(int i =0; i< index; i++) {
			if(office[i]!=null && office[i].getPosition().equals(posing)) {
				count++;
			}
		}
		int h=0;
		Officer[] off3 = new Officer[count];
		for(int i =0; i< index; i++) {
			if(office[i]!=null && office[i].getPosition().equals(posing)) {
				off3[h++]= office[i];
			}
		}
		return off3;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return index;
	}

	@Override
	public Officer[] findAll() {
		// TODO Auto-generated method stub
		
		return Arrays.copyOf(office, index);
	}

	@Override
	public Header[] findAllHeader() {
		// TODO Auto-generated method stub
		int count=0;
		for (int i = 0; i < index; i++) {
			if(office[i] instanceof Header) {
				count++;
			}
		}
		Header[] header = new Header[count];
		int k=0;
		for (int i = 0; i < index; i++) {
			if(office[i] instanceof Header) {
				header[k++]=(Header)office[i];
			}
		}
		return header;
	}

}
