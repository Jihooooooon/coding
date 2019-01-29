package com.ssafy;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Object> bookList = new ArrayList<>();
		bookList.add(new Book("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본 문법"));
		bookList.add(new Book("35355", "분석설계", "소나무", "Jaen.kr", 30000, "SW 모델링"));
		bookList.add(new Magazine("35535", "Java World", "편집부", "java.com", 2018, 2, 7000, "첫걸음"));
		
		
		System.out.println("************************* 도서 목록  *****************************");
		for(Object i:bookList) {
			System.out.print(i);
		}
		
		
	}

}
