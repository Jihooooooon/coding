package com.ssafy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class BookMgrImpl implements IBookMgr {

	private static BookMgrImpl bookMgrImpl;
	private BookMgrImpl() {}
	public static BookMgrImpl getInstance() {
		if(bookMgrImpl==null) {
			bookMgrImpl = new BookMgrImpl();
		}
		return bookMgrImpl;
	}
	
	private ArrayList<Book> books = new ArrayList<>();
	@Override
	public void add(Book b) {
		// TODO Auto-generated method stub
		books.add(b);
	}

	@Override
	public List<Book> search() {
		// TODO Auto-generated method stub
		return this.books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		for(Book temp: books) {
			if(temp.getIsbn().equals(isbn)) {
				if(temp.getQuantity()<quantity) {
					throw new QuantityException();
					
				}
				else {
					temp.setQuantity(temp.getQuantity()-quantity);
				}
			}
		}
	
		throw new ISBNNotFoundException();
	}

	@Override
	public int getTotalAmount() {
		int result=0;
		for(Book temp:books) {
			result+= (temp.getPrice()*temp.getQuantity());
		}
		return result;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		String fname="book.txt";
		BufferedReader br =null;
		StringTokenizer st = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg="";
			while((msg=br.readLine())!=null) {
				st = new StringTokenizer(msg,"|");
				int kind = Integer.parseInt(st.nextToken().trim());
				if(kind==1) {
					
					books.add(new Book(st.nextToken().trim(),st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}
				else {
					books.add(new Magazine(st.nextToken().trim(),st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim()),
									Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다.");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("파일을 읽는 도중 예외가 발생했습니다.");
		}
	}
	
	public void print() {
		for(Book b: books) {
			System.out.println(b);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		String fname="book.txt";
		try {
			pw = new PrintWriter(new FileWriter(fname,false),true);
			for(int i=0; i< books.size(); i++) {
				Book s = books.get(i);
				int num=0;
				if(s instanceof Magazine) {
					num=2;
				}
				else {
					num=1;
				}
				String msg =String.format("%d|%s|%s|%s|%s", num,s.getIsbn(),s.getTitle(),s.getPrice(), s.quantity);
				pw.println(msg);
				
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(pw!=null)pw.close();
		}
	}

	
}
