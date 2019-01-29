package com.ssafy.edu.forth;

public class MagicFactory {

	public static IMagic factory(int n) {
		IMagic odd=null;
		
	    if(n%2==1) {
	    	odd = new OddMagicSquare(n);
	    }
	    else if(n%4==0) {
	    	odd = new FourMagicSquare(n);
	    }
	    else if(n%4==2) {
	    	odd = new SixMagicSquare(n);
	    }
	    return odd;
	}

}
