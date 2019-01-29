package com.ssafy.edu.first;

public class Test2 {

	public static void hello(int ...a) {
		//..a 여러개 인자를 받을 수 있다.
		//배열로 인자를 받는다.
		System.out.println(a.length);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OfficerManager manager=OfficerManager.getInstance();
		manager.add(new Header(1577,"WEST1","G11"));
		manager.add(new Header(1579,"WEST1","G12"));
		manager.add(new Header(1583,"WEST2","홍길동"));
		
		System.out.println(manager.findByNo(1577));
		
		Officer[] off5 = manager.findByPosition("WEST1");
		
		Officer[] temp = manager.findAll();
		for(Officer oo:temp) {
			System.out.println(oo);
			
		}
		
		hello(1,2,3,4,5,6);
		
	}

}
