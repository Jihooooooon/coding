package com.ssafy;

import java.util.ArrayList;

public interface IProductMgr {
	void add(Product product);
	ArrayList<Product> findAll();
	Product findByNo(String no);
	ArrayList<Product> findByName(String name);
	void soldProduct(String no, int aMount);
	void chageProductAmount(String no, int aMount);
	void updateProduct(String no, int price);
	void deleteProduct(String no);
	
	long productsTotalPrice();
	int size();
}
