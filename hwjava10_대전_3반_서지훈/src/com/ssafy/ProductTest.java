package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
			ProductMgr productMgr = ProductMgr.getInstance();
			productMgr.open();
			
			try {
				productMgr.add(new TV("2222","티비4",10,10,10));
			} catch (DuplicateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println();
			productMgr.print();
			try {
				productMgr.add(new TV("2222","티비4",10,10,10));
			} catch (DuplicateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				productMgr.findByNo("2222");
			} catch (CodeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				productMgr.findByNo("2223");
			} catch (CodeNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				productMgr.findByAboveRefrigerator(400);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				productMgr.findByAboveRefrigerator(10000);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				productMgr.findByAboveTV(50);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				productMgr.findByAboveTV(1000);
			} catch (ProductNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			productMgr.close();
	}

}
