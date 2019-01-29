package com.ssafy;

import java.util.ArrayList;

public class ProductTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Object> productList = new ArrayList<>();
		productList.add(new TV(1000,"SamgSungTv", 1000000,1000,40,"ElfWin2"));
		productList.add(new Refrigerator(1001,"SamgSungR", 2000000,800,1000));
		productList.add(new Refrigerator(1002,"SamgSungR2", 3000000,900,1500));
		
		System.out.println("********************* 제품 정보 ***********************");
		for(Object product:productList) {
			System.out.println(product);
		}
	}

}
