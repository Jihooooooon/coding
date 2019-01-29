package com.ssafy;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Book> bookList = new ArrayList<>();
		ArrayList<Magazine> magazineList = new ArrayList<>();
		bookList.add(new Book("21424", "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법"));
		bookList.add(new Book("33455", "JDBC Pro", "김철수", "Jaen.kr", 23000, ""));
		bookList.add(new Book("55355", "Servlet/JSP", "박자바", "Jaen.kr", 41000, "Model2 기반"));
		bookList.add(new Book("35332", "Android App", "홍길동", "Jaen.kr", 25000, "Lightweight Framework"));
		bookList.add(new Book("35355", "OOAD 분석,설계", "소나무", "Jaen.kr", 30000, ""));
		
		magazineList.add(new Magazine("35535", "Java World", "편집부", "Jaen.kr", 2013, 2, 7000, ""));
		magazineList.add(new Magazine("33434", "Mobile World", "편집부", "Jaen.kr", 2013, 8, 8000, ""));
		magazineList.add(new Magazine("75342", "Next Web", "편집부", "Jaen.kr", 2012, 10, 10000, "AJAX 소개"));
		magazineList.add(new Magazine("76543", "Architecture", "편집부", "Jaen.kr", 2010, 3, 5000, "java 시스템"));
		magazineList.add(new Magazine("76534", "Data Modeling", "편집부", "Jaen.kr", 2012, 12, 12000, ""));
		
		System.out.println("************************* 도서 목록  *****************************");
		for(Book i:bookList) {
			System.out.print(i);
		}
		System.out.println("************************* 잡지 목록  *****************************");
		for(Magazine i:magazineList) {
			System.out.print(i);
		}
		
	}

}
