package com.ssafy.edu;

public class ArrayMain {

	public static void main(String[] args) {
		IMagic [] ms=new IMagic[5];
		for (int i = 0; i < ms.length; i++) {
			ms[i]=new OddMagicSquare(2*i+3);
			//ms[i]=MagicFactory.factory(i+3);
			MagicUtil.print(ms[i]);
		}
	}

}
