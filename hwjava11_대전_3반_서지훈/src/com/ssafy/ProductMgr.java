package com.ssafy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;



public class ProductMgr implements IProductMgr{

	private static ProductMgr productImpl;
	private ProductMgr() {
	}
	public static synchronized ProductMgr getInstance() {
		if(productImpl==null) {
			productImpl=new ProductMgr();
		}
		return productImpl;
	}
	//---------------------위 싱글턴
	private ArrayList<Product> products=new ArrayList<>();
	private int index=0;
	
	
	//------- ProductManagerImpl <> -----> Product  aggregation
	@Override
	public void add(Product product) throws DuplicateException {
		// TODO Auto-generated method stub
		boolean isIn=false;
		for(int i =0; i< products.size(); i++) {
			if(products.get(i)!=null && products.get(i).getNo().equals(product.no)) {
				isIn=true;
			}
		}
			if(isIn) {
				throw new DuplicateException();
			}
			this.products.add(product);
			index++;
		
	}
	@Override
	public ArrayList<Product> findAll() {
		// TODO Auto-generated method stub
		return this.products;
	}
	@Override
	public Product findByNo(String no) throws CodeNotFoundException {
		for(int i =0; i< products.size(); i++) {
			if(products.get(i)!=null && products.get(i).getNo().equals(no)) {
				return products.get(i);
			}
		}
		throw new CodeNotFoundException();
	}
	@Override
	public ArrayList<Product> findByName(String name) {
		
		ArrayList<Product> off3 = new ArrayList<>();
		
		for(int i =0; i< products.size(); i++) {
			if(products.get(i).getName().contains(name)) {
				
				off3.add(products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<TV> findOnlyTV() {
		
		
		ArrayList<TV> off3 = new ArrayList<>();
		for(int i =0; i< products.size(); i++) {
			if((products.get(i) instanceof TV)) {
				
				off3.add((TV)products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<Refrigerator> findOnlyRefrigerators() {
	
		ArrayList<Refrigerator> off3 = new ArrayList<>();
		for(int i =0; i< products.size(); i++) {
			if((products.get(i) instanceof Refrigerator)) {
				off3.add((Refrigerator)products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<Refrigerator> findByAboveRefrigerator(int capacity) throws ProductNotFoundException {
		ArrayList<Refrigerator> off3 = new ArrayList<>();
		for(int i =0; i< products.size(); i++) {
			if(products.get(i) instanceof Refrigerator&& ((Refrigerator)products.get(i)).getCapacity()>capacity) {
				off3.add((Refrigerator)products.get(i));
			}
		}
		if(off3.size()==0) {
			throw new ProductNotFoundException();
		}
		return off3;
	}
	@Override
	public ArrayList<TV> findByAboveTV(int wide) throws ProductNotFoundException {
		ArrayList<TV> off3 = new ArrayList<>();
		for(int i =0; i< products.size(); i++) {
			if(products.get(i) instanceof TV&& ((TV)products.get(i)).getWide()>wide) {
				off3.add((TV)products.get(i));
			}
		}
		if(off3.size()==0) {
			throw new ProductNotFoundException();
		}
		return off3;
	}
	@Override
	public void updateProduct(String no, int price) {
		// TODO Auto-generated method stub
	
		try {
			findByNo(no).setPrice(price);
		} catch (CodeNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void deleteProduct(String no) {
		// TODO Auto-generated method stub
		for(int i=0; i<this.size(); i++) {
			if(products.get(i).getNo().equals(no)) {
				products.remove(i);
				this.index--;
			}
		}
	}
	@Override
	public long productsTotalPrice() {
		int result=0;
		for(int i=0; i<products.size(); i++) {
			result +=products.get(i).getPrice();
		}
		return result;
	}
	@Override
	public int size() {
		return this.index;
	}

	public void open() {
		// TODO Auto-generated method stub
		
		String fname="product.obj";
		ObjectInputStream ois = null;
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(fname);
			ois = new ObjectInputStream(fis);
			int count=ois.readInt();
			for (int i = 0; i < count; i++) {
				int k=ois.readInt();
				Product ss;
				try {
					ss = (Product)ois.readObject();
					products.add(ss);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		
		/*
		String fname="product.obj";
	
		FileInputStream fi; 
		ObjectInputStream oi;
		try {
	
			fi= new FileInputStream(fname);
			oi = new ObjectInputStream(fi);
			Product pro;
			while((pro=(Product)oi.readObject())!=null) {
				
				
					
					products.add(pro);
			
			
				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("파일이 존재하지 않습니다.");
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("파일을 읽는 도중 예외가 발생했습니다.");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/	}
	
	public void print() {
		for(Product b: products) {
			System.out.println(b);
		}
	}


	public void close() {
		// TODO Auto-generated method stub
		 FileOutputStream fos=null;
	     ObjectOutputStream oos = null;

		String fname="product.obj";
		try {
			 fos= new FileOutputStream(fname, false);
	         oos = new ObjectOutputStream(fos);
	         oos.writeInt(products.size());
			for(Product p:products) {
				
				oos.writeObject(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(oos!=null) {
	            try {
	               oos.close();
	            } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	         }
	         if(fos!=null) {
	            try {
	               fos.close();
	            } catch (IOException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	            }
	         }

		}
	}
	
}
