package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;


public class BookManager implements IBookManager{

	private static BookManager bookManager;
	private ArrayList<Book> book;
	private int index;
	private BookManager() {
		book = new ArrayList<>();
		index =0;
	}
	
	public static synchronized BookManager getInstance() {
		if(bookManager==null) {
			bookManager = new BookManager();
			return bookManager;
		}
		else {
			return bookManager;
		}
	}
	
	private int size() {
		return this.index;
	}

	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
		
		book.add(b);
		index++;
			
		
	}

	@Override
	public ArrayList<Book> findAll() {
		
		return this.book;
	}

	@Override
	public Book findByIsbn(String isbn) {
		
		for(int i =0; i< index; i++) {
			if(book.get(i).getIsbn().equals(isbn)) {
				return book.get(i);
			}
		}
		
		return null;
		
	}

	@Override
	public ArrayList<Book> findByIsTitle(String title) {
		
		ArrayList<Book> off3 = new ArrayList<>();
		
		for(int i =0; i< index; i++) {
			if(book.get(i).getTitle().contains(title)) {
				off3.add( book.get(i));
			}
		}
		return off3;
	}

	@Override
	public ArrayList<Book> findOnlyBooks() {
		
		ArrayList<Book> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if(!(book.get(i) instanceof Magazine)) {
				off3.add( book.get(i));
			}
		}
		return off3;
	}

	@Override
	public ArrayList<Magazine> findOnlyMagazines() {
	
		ArrayList<Magazine> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if((book.get(i) instanceof Magazine)) {
				off3.add((Magazine)book.get(i));
			}
		}
		return off3;
	}

	@Override
	public ArrayList<Magazine> findMagazinesThisYear(int year) {
	
		ArrayList<Magazine> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if((book.get(i) instanceof Magazine)&& ((Magazine)book.get(i)).getYear()==year) {
				off3.add((Magazine)book.get(i));
			}
		}
		return off3;
	}

	@Override
	public ArrayList<Book> findByPublisher(String publisher) {

		ArrayList<Book> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if(book.get(i).getPublisher().equals(publisher)) {
				off3.add( book.get(i));
			}
		}
		return off3;
	}

	@Override
	public ArrayList<Book> findUnderPrice(int price) {
	
		ArrayList<Book> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if(book.get(i)!=null && book.get(i).getPrice()<price) {
				off3.add( book.get(i));
			}
		}
		return off3;
	}

	@Override
	public int allBookCost() {

		int result=0;
		for(int i=0; i<index; i++) {
			result +=book.get(i).getPrice();
		}
		return result;
	}

	@Override
	public int allBookAverageCost() {
		
		return this.allBookCost()/index;
	}
}
