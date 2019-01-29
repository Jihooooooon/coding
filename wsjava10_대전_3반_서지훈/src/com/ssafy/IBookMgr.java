package com.ssafy;

import java.util.ArrayList;
import java.util.List;

public interface IBookMgr {
	void add(Book b); 
	List<Book> search(); 
	void sell( String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	int getTotalAmount();
	void open();
	void close();

}
