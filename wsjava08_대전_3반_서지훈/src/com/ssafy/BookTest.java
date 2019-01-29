package com.ssafy;

import java.util.ArrayList;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BookManager manager = BookManager.getInstance();
		
		// 데이터입력기능
		manager.add(new Book("21424", "Java Basic", "김하나", "Jaen.kr", 15000, "Java 기본 문법"));
		manager.add(new Magazine("75342", "Next Web", "편집부", "Jaen.kr", 2012, 10, 10000, "AJAX 소개"));
		manager.add(new Magazine("76534", "Data Modeling", "편집부", "Jaen.kr", 2019, 12, 12000, ""));
		manager.add(new Book("33455", "JDBC Pro", "김철수", "Jaen", 23000, ""));
		//데이터 금액 평균
		System.out.println("금액 평균 :"+manager.allBookAverageCost());
		//데이터 금액 합계
		System.out.println("금액 합계: "+manager.allBookCost());
		// 모든 Book 검색 
		System.out.println("검색된 Book 출력");
		for(Book i:manager.findAll()) {
			System.out.print(i);
		}
		//title로 검색
		System.out.println("title을 포함하는 Book 출력");
		for(Book i:manager.findByIsTitle("Ja")) {
			System.out.print(i);
		}
		//Isbn으로 검색
		System.out.print("Isbn으로 검색 : "+manager.findByIsbn("21424"));
		//북만 검색
		System.out.println("북만 검색");
		for(Book i:manager.findOnlyBooks()) {
			System.out.print(i);
		}
		System.out.println("매거진만 검색");
		for(Magazine i: manager.findOnlyMagazines()) {
			System.out.print(i);
		}
		//올해잡지
		System.out.println("올해 매거진만 검색");
		for(Magazine i: manager.findMagazinesThisYear(2019)) {
			System.out.print(i);
		}
		//출판사
		System.out.println("출판사로 검색");
		for(Book i: manager.findByPublisher("Jaen")) {
			System.out.print(i);
		}
		//가격 검색
		System.out.println("낮은가격 책 검색");
		for(Book i: manager.findUnderPrice(13000)) {
			System.out.print(i);
		}
		/*
		System.out.print();
		System.out.print();
		System.out.print();
		System.out.print();
		System.out.print();
		System.out.print();
		
		*/
		
		
		

	/*	ArrayList<Book> bookList = new ArrayList<>();
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
		}*/
		
	}

}
