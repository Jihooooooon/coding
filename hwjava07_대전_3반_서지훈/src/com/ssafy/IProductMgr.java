package com.ssafy;

public interface IProductMgr {
	void add(Product product);
	Product[] findAll();
	Product findByNo(String no);
	Product[] findByName(String name);
	TV[] findOnlyTV();
	Refrigerator[] findOnlyRefrigerators();
	Refrigerator[] findByAboveRefrigerator(int capacity);
	TV[] findByAboveTV(int wide);
	
	void updateProduct(String no, int price);
	void deleteProduct(String no);
	
	long productsTotalPrice();
	int size();
}
