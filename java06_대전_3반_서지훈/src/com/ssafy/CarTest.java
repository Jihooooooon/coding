package com.ssafy;

import java.util.Arrays;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CarMgr test = new CarMgr();
		//100, sonata, 1500
		//101, morning 900
		//102, avante  1300
		//103, grandeur 1800
		
		
		test.add(new Car("100","sonata", 1500));
		test.add(new Car("101","morning", 900));
		test.add(new Car("102","avante", 1300));
		test.add(new Car("103","grandeur", 1800));
		
		System.out.println(test.size());
		
		System.out.println(Arrays.toString(test.search()));
		System.out.println(test.search("100"));
		System.out.println(Arrays.toString(test.search(1600)));
		test.update("100", 1550);
		System.out.println(Arrays.toString(test.search()));
		test.delete("100");
		System.out.println(Arrays.toString(test.search()));
		System.out.println(test.size());
		System.out.println(test.totalPrice());
		test.add(new Car("101","morning", 900));
	}

}
