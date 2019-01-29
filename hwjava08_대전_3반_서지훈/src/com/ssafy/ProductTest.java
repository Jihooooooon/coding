package com.ssafy;

public class ProductTest {

	public static void main(String[] args) {
			ProductMgr productMgr = ProductMgr.getInstance();
			productMgr.add(new TV("1000","SamgSungTv", 1000000,1000,70));
			productMgr.add(new TV("999","SamgSungTv2", 1000000,1000,40));
			productMgr.add(new Refrigerator("1001","SamgR1", 1100000,2000,390));
			productMgr.add(new Refrigerator("1002","SamgR2", 1200000,3000,1500));
			System.out.println("전체출력");
			for(Product i:productMgr.findAll()) {
				System.out.println(i);
			}
			System.out.println("상품번호");
			System.out.println(productMgr.findByNo("1000"));
			System.out.println("상품명");
			for(Product i:productMgr.findByName("Samg")) {
				System.out.println(i);
			}
			System.out.println("TV");
			for(TV i:productMgr.findOnlyTV()) {
				System.out.println(i);
			}
			System.out.println("냉장고");
			for(Refrigerator i:productMgr.findOnlyRefrigerators()) {
				System.out.println(i);
			}
			System.out.println("400이상");
			for(Refrigerator i:productMgr.findByAboveRefrigerator(400)) {
				System.out.println(i);
			}
			System.out.println("50인치 TV");
			for(TV i:productMgr.findByAboveTV(50)) {
				System.out.println(i);
			}
			System.out.println("업데이트");
			productMgr.updateProduct("999", 999);
			System.out.println(productMgr.findByNo("999"));
			System.out.println("삭제");
			productMgr.deleteProduct("999");
			for(Product i:productMgr.findAll()) {
				System.out.println(i);
			}
			System.out.println("금액");
			System.out.println(productMgr.productsTotalPrice());
			
			/*
			productList.add(new TV(1000,"SamgSungTv", 1000000,1000,40,"ElfWin2"));
			productList.add(new Refrigerator(1001,"SamgSungR", 2000000,800,1000));
			productList.add(new Refrigerator(1002,"SamgSungR2", 3000000,900,1500));
			
			System.out.println("********************* 제품 정보 ***********************");
			for(Object product:productList) {
				System.out.println(product);
			}*/
	}

}
