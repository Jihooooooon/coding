package com.ssafy.edu.third;

import java.util.Scanner;

public class MagicSquareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
	    MagicSquare odd=null;
	    odd =MagicFactory.factory(n);
	    MagicUtil.print(odd);
		/*
	    if(n%2==1) {
	    	odd = new OddMagicSquare(n);
	    }
	    else if(n%4==0) {
	    	odd = new FourMagicSquare(n);
	    }
	    else if(n%4==2) {
	    	odd = new SixMagicSquare(n);
	    }*/
	    
		/*MagicSquare odd = new SixMagicSquare(n);
		MagicUtil.print(odd);*/
		
	}

}
