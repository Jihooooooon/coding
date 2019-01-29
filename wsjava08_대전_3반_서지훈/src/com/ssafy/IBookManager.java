package com.ssafy;

import java.util.ArrayList;

public interface IBookManager {
	void add(Book b);
	ArrayList<Book> findAll();
	Book findByIsbn(String isbn);
	ArrayList<Book> findByIsTitle(String title);
	ArrayList<Book> findOnlyBooks();
	ArrayList<Magazine> findOnlyMagazines();
	ArrayList<Magazine> findMagazinesThisYear(int year);
	
	ArrayList<Book> findByPublisher(String publisher);
	ArrayList<Book> findUnderPrice(int price);
	int allBookCost();
	int allBookAverageCost();

}
