package com.ssafy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ProductMgr implements IProductMgr {

	private static ProductMgr productImpl;

	private ProductMgr() {
	}

	public static synchronized ProductMgr getInstance() {
		if (productImpl == null) {
			productImpl = new ProductMgr();
		}
		return productImpl;
	}

	// ---------------------위 싱글턴
	private ArrayList<Product> products = new ArrayList<>();
	private int index = 0;

	// ------- ProductManagerImpl <> -----> Product aggregation
	@Override
	public void add(Product product) {
		// TODO Auto-generated method stub
		if (findByNo(product.getNo()) != null) {
			System.out.println("중복 된 상품 정보가 존재합니다...");
		} else {
			this.products.add(product);

			index++;
		}
	}

	private void sortList() {
		Collections.sort(products);
	}

	@Override
	public ArrayList<Product> findAll() {
		// TODO Auto-generated method stub
		this.sortList();
		return this.products;
	}

	@Override
	public Product findByNo(String no) {
		for (int i = 0; i < index; i++) {
			if (products.get(i) != null && products.get(i).getNo().equals(no)) {
				return products.get(i);
			}
		}
		return null;
	}

	@Override
	public ArrayList<Product> findByName(String name) {

		ArrayList<Product> off3 = new ArrayList<>();

		for (int i = 0; i < index; i++) {
			if (products.get(i).getName().contains(name)) {

				off3.add(products.get(i));
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
	public void soldProduct(String no, int aMount) {
		if (sell(no, aMount)) {
			System.out.println("판매 성공!");
		} else {
			System.out.println("재고가 없거나 부족합니다..");
		}
	}

	private boolean sell(String no, int aMount) {
		Product temp = findByNo(no);
		if (temp == null) {
			return false;
		} else if (temp.getAmount() < aMount) {
			return false;
		} else if (temp.getAmount() == aMount) {
			deleteProduct(no);
			return true;
		} else {
			chageProductAmount(no, aMount);
			return true;
		}
	}

	@Override
	public void deleteProduct(String no) {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.size(); i++) {
			if (products.get(i).getNo().equals(no)) {
				products.remove(i);
				this.index--;
				break;
			}
		}
	}

	@Override
	public long productsTotalPrice() {
		int result = 0;
		for (int i = 0; i < index; i++) {
			result += products.get(i).getPrice();
		}
		return result;
	}

	@Override
	public int size() {
		return this.index;
	}

	@Override
	public void chageProductAmount(String no, int aMount) {
		// TODO Auto-generated method stub
		Iterator<Product> iter = products.iterator();
		while (iter.hasNext()) {
			Product temp = iter.next();
			if (temp.getNo().equals(no)) {
				temp.setAmount(temp.getAmount() - aMount);
				break;
			}
		}
	}

}
