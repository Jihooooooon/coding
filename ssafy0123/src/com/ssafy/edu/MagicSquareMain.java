package com.ssafy.edu;

import java.util.Scanner;

public class MagicSquareMain {

	public static void main(String[] args) {
		
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		IMagic odd=null;
		//MagicSquare odd=new OddMagicSquare(n);//부타자생
		//MagicSquare odd=new FourMagicSquare(n);
		//MagicSquare odd=new  SixMagicSquare(n);
		//odd.make();//부메자호
		//odd.print();
/*		if(n%2==1) {
			odd=new OddMagicSquare(n);
		}else if(n%4==0) {
			odd=new FourMagicSquare(n);
		}else if(n%4==2) {
			odd=new SixMagicSquare(n);
		}*/
		
		 try {
				odd=MagicFactory.factory(n);// 팩토리 패턴 -> 추상성
		} catch (MagicSquareException e) {
			// TODO: handle exception
			System.out.println(e);
		}catch( Exception e) {
			System.out.println(e);
		}
		 finally {
			 System.out.println("필승~~!");
			 
		 }
	
		MagicUtil.print(odd);//부타자참
		System.out.println(odd);
	}

}










