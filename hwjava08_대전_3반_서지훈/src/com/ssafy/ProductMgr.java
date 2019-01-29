package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;

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
	public void add(Product product) {
		// TODO Auto-generated method stub
		
			this.products.add(product);
			index++;
		
	}
	@Override
	public ArrayList<Product> findAll() {
		// TODO Auto-generated method stub
		return this.products;
	}
	@Override
	public Product findByNo(String no) {
		for(int i =0; i< index; i++) {
			if(products.get(i)!=null && products.get(i).getNo().equals(no)) {
				return products.get(i);
			}
		}
		return null;
	}
	@Override
	public ArrayList<Product> findByName(String name) {
		
		ArrayList<Product> off3 = new ArrayList<>();
		
		for(int i =0; i< index; i++) {
			if(products.get(i).getName().contains(name)) {
				
				off3.add(products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<TV> findOnlyTV() {
		
		
		ArrayList<TV> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if((products.get(i) instanceof TV)) {
				
				off3.add((TV)products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<Refrigerator> findOnlyRefrigerators() {
	
		ArrayList<Refrigerator> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if((products.get(i) instanceof Refrigerator)) {
				off3.add((Refrigerator)products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<Refrigerator> findByAboveRefrigerator(int capacity) {
		ArrayList<Refrigerator> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if(products.get(i) instanceof Refrigerator&& ((Refrigerator)products.get(i)).getCapacity()>capacity) {
				off3.add((Refrigerator)products.get(i));
			}
		}
		return off3;
	}
	@Override
	public ArrayList<TV> findByAboveTV(int wide) {
		ArrayList<TV> off3 = new ArrayList<>();
		for(int i =0; i< index; i++) {
			if(products.get(i) instanceof TV&& ((TV)products.get(i)).getWide()>wide) {
				off3.add((TV)products.get(i));
			}
		}
		return off3;
	}
	@Override
	public void updateProduct(String no, int price) {
		// TODO Auto-generated method stub
		findByNo(no).setPrice(price);
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
		for(int i=0; i<index; i++) {
			result +=products.get(i).getPrice();
		}
		return result;
	}
	@Override
	public int size() {
		return this.index;
	}
	
}
