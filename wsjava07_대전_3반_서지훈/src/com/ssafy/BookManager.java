package com.ssafy;

import java.util.Arrays;


public class BookManager implements IBookManager{

	private static BookManager bookManager;
	private Book[] book;
	private int index;
	private BookManager() {
		book = new Book[100];
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
		if(this.size()>=100) {
			System.out.println("용량초과!");
			return;
		}
		else {
			this.book[index++]=b;
		}
	}

	@Override
	public Book[] findAll() {
		return Arrays.copyOf(this.book, index);
	}

	@Override
	public Book findByIsbn(String isbn) {
		
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getIsbn().equals(isbn)) {
				return book[i];
			}
		}
		
		return null;
		
	}

	@Override
	public Book[] findByIsTitle(String title) {
		int count =0;
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getTitle().contains(title)) {
				count++;
			}
		}
		int h=0;
		Book[] off3 = new Book[count];
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getTitle().contains(title)) {
				off3[h++]= book[i];
			}
		}
		return off3;
	}

	@Override
	public Book[] findOnlyBooks() {
		int count =0;
		for(int i =0; i< index; i++) {
			if(!(book[i] instanceof Magazine)) {
				count++;
			}
		}
		int h=0;
		Book[] off3 = new Book[count];
		for(int i =0; i< index; i++) {
			if(!(book[i] instanceof Magazine)) {
				off3[h++]= book[i];
			}
		}
		return off3;
	}

	@Override
	public Magazine[] findOnlyMagazines() {
		int count =0;
		for(int i =0; i< index; i++) {
			if((book[i] instanceof Magazine)) {
				count++;
			}
		}
		int h=0;
		Magazine[] off3 = new Magazine[count];
		for(int i =0; i< index; i++) {
			if((book[i] instanceof Magazine)) {
				off3[h++]= (Magazine)book[i];
			}
		}
		return off3;
	}

	@Override
	public Magazine[] findMagazinesThisYear(int year) {
		int count =0;
		for(int i =0; i< index; i++) {
			if((book[i] instanceof Magazine)&& ((Magazine)book[i]).getYear()==year) {
			
				count++;
			}
		}
		int h=0;
		Magazine[] off3 = new Magazine[count];
		for(int i =0; i< index; i++) {
			if((book[i] instanceof Magazine)&& ((Magazine)book[i]).getYear()==year) {
				off3[h++]= (Magazine)book[i];
			}
		}
		return off3;
	}

	@Override
	public Book[] findByPublisher(String publisher) {
		int count =0;
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getPublisher().equals(publisher)) {
				count++;
			}
		}
		int h=0;
		Book[] off3 = new Book[count];
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getPublisher().equals(publisher)) {
				off3[h++]= book[i];
			}
		}
		return off3;
	}

	@Override
	public Book[] findUnderPrice(int price) {
		int count =0;
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getPrice()<price) {
				count++;
			}
		}
		int h=0;
		Book[] off3 = new Book[count];
		for(int i =0; i< index; i++) {
			if(book[i]!=null && book[i].getPrice()<price) {
				off3[h++]= book[i];
			}
		}
		return off3;
	}

	@Override
	public int allBookCost() {

		int result=0;
		for(int i=0; i<index; i++) {
			result +=book[i].getPrice();
		}
		return result;
	}

	@Override
	public int allBookAverageCost() {
		
		return this.allBookCost()/index;
	}
}
