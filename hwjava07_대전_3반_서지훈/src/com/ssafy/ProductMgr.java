package com.ssafy;

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
	private Product[] products=new Product[100];
	private int index=0;
	
	
	//------- ProductManagerImpl <> -----> Product  aggregation
	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		if(this.size()>=100) {
			System.out.println("용량초과!");
			return;
		}
		else {
			this.products[index++]=product;
		}
	}
	@Override
	public Product[] findAll() {
		// TODO Auto-generated method stub
		return Arrays.copyOf(this.products, index);
	}
	@Override
	public Product findByNo(String no) {
		for(int i =0; i< index; i++) {
			if(products[i]!=null && products[i].getNo().equals(no)) {
				return products[i];
			}
		}
		return null;
	}
	@Override
	public Product[] findByName(String name) {
		int count =0;
		for(int i =0; i< index; i++) {
			if(products[i]!=null && products[i].getName().contains(name)) {
				count++;
			}
		}
		int h=0;
		Product[] off3 = new Product[count];
		for(int i =0; i< index; i++) {
			if(products[i]!=null && products[i].getName().contains(name)) {
				off3[h++]= products[i];
			}
		}
		return off3;
	}
	@Override
	public TV[] findOnlyTV() {
		int count =0;
		for(int i =0; i< index; i++) {
			if((products[i] instanceof TV)) {
				count++;
			}
		}
		int h=0;
		TV[] off3 = new TV[count];
		for(int i =0; i< index; i++) {
			if((products[i] instanceof TV)) {
				off3[h++]= (TV)products[i];
			}
		}
		return off3;
	}
	@Override
	public Refrigerator[] findOnlyRefrigerators() {
		int count =0;
		for(int i =0; i< index; i++) {
			if((products[i] instanceof Refrigerator)) {
				count++;
			}
		}
		int h=0;
		Refrigerator[] off3 = new Refrigerator[count];
		for(int i =0; i< index; i++) {
			if((products[i] instanceof Refrigerator)) {
				off3[h++]= (Refrigerator)products[i];
			}
		}
		return off3;
	}
	@Override
	public Refrigerator[] findByAboveRefrigerator(int capacity) {
		int count =0;
		for(int i =0; i< index; i++) {
			if(products[i] instanceof Refrigerator&& ((Refrigerator)products[i]).getCapacity()>capacity) {
				count++;
			}
		}
		int h=0;
		Refrigerator[] off3 = new Refrigerator[count];
		for(int i =0; i< index; i++) {
			if(products[i] instanceof Refrigerator&& ((Refrigerator)products[i]).getCapacity()>capacity) {
				off3[h++]= (Refrigerator)products[i];
			}
		}
		return off3;
	}
	@Override
	public TV[] findByAboveTV(int wide) {
		int count =0;
		for(int i =0; i< index; i++) {
			if(products[i] instanceof TV&& ((TV)products[i]).getWide()>wide) {
				count++;
			}
		}
		int h=0;
		TV[] off3 = new TV[count];
		for(int i =0; i< index; i++) {
			if(products[i] instanceof TV&& ((TV)products[i]).getWide()>wide) {
				off3[h++]= (TV)products[i];
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
			if(products[i].getNo().equals(no)) {
				products[i]=null;
				for(int j=i+1; j<this.size(); j++) {
					products[j-1]=products[j];
				}
				this.index--;
			}
		}
	}
	@Override
	public long productsTotalPrice() {
		int result=0;
		for(int i=0; i<index; i++) {
			result +=products[i].getPrice();
		}
		return result;
	}
	@Override
	public int size() {
		return this.index;
	}
	
}
