package com.ssafy;

public interface IBookManager {
	void add(Book b);
	Book[] findAll();
	Book findByIsbn(String isbn);
	Book[] findByIsTitle(String title);
	Book[] findOnlyBooks();
	Magazine[] findOnlyMagazines();
	Magazine[] findMagazinesThisYear(int year);
	
	Book[] findByPublisher(String publisher);
	Book[] findUnderPrice(int price);
	int allBookCost();
	int allBookAverageCost();

}
