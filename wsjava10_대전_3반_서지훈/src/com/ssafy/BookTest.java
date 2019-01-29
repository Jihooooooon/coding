package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		BookMgrImpl bookMgr = BookMgrImpl.getInstance();
		bookMgr.open();
		bookMgr.print();
		
		for(Book temp:bookMgr.search()) {
			System.out.println(temp);
		}
		System.out.println(bookMgr.getTotalAmount());
		bookMgr.add(new Book("1111", "지훈", 10000, 10));
		bookMgr.print();
		try {
			bookMgr.sell("2222", 10);
		} catch (QuantityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ISBNNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			bookMgr.sell("1111", 12);
		} catch (QuantityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ISBNNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		bookMgr.close();
	
		
	}

}
