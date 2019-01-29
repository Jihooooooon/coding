package com.ssafy.edu;

public class MagicFactory {

	public static IMagic factory(int n) throws MagicSquareException {
		IMagic odd=null;
		if(n<3) {
			
			throw new MagicSquareException(n+ "마방진은 없습니다.");
		}
		if(n%2==1) {
			odd=new OddMagicSquare(n);
		}else if(n%4==0) {
			odd=new FourMagicSquare(n);
		}else if(n%4==2) {
			odd=new SixMagicSquare(n);
		}
		return odd;
	}
}
