package com.ssafy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
		String fname="product.txt";
		BufferedReader br =null;
		StringTokenizer st = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg="";
			while((msg=br.readLine())!=null) {
				st = new StringTokenizer(msg,"|");
				int kind = Integer.parseInt(st.nextToken().trim());
				//1 tv 2 refri
				if(kind==1) {
					
					products.add(new TV(st.nextToken().trim(),st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}
				else {
					products.add(new Refrigerator(st.nextToken().trim(),st.nextToken().trim(),
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
		for(Product b: products) {
			System.out.println(b);
		}
	}


	public void close() {
		// TODO Auto-generated method stub
		PrintWriter pw = null;
		String fname="product.txt";
		try {
			pw = new PrintWriter(new FileWriter(fname,false),true);
			for(int i=0; i< products.size(); i++) {
				Product s = products.get(i);
				int num=0;
				String msg="";
				if(s instanceof Refrigerator) {
					num=2;
					msg =String.format("%d|%s|%s|%d|%d|%d", num,s.getNo(),s.getName(),s.getPrice(), s.getAmount(),((Refrigerator) s).getCapacity());
				}
				else {
					num=1;
					msg =String.format("%d|%s|%s|%d|%d|%d", num,s.getNo(),s.getName(),s.getPrice(), s.getAmount(),((TV)s).getWide());
				}
				
				
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
