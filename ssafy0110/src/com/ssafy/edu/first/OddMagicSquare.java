package com.ssafy.edu.first;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 마방진을 완성한다. <br/>
 * 마방진이란 각 행의 합, 각 열의 합, 대각선의 합, 역대각선의 합이 같다.<br/>
 * 정사각 마방진은 삼마방, 사마방, 육마방으로 구성된다. <br/>
 * <pre>
 * 삼마방 an=1+2n 
 * 사마방 an=4n
 * 육마방은 an=4n+2
 * </pre>
 * @author honeyjava
 * @since 2019.1.9
 * @version 0.1
 */
public class OddMagicSquare {
	/**
	 * 마방진의 핵심 데이터- 이차원 배열
	 */
	private int[][] magic;
	/**
	 * 마방진의 크기 n X n
	 */
	private int n;
	/**
	 * 마방진의 크기를 입력받는 생성자
	 * @param n <code>int</code> 마방진의 크기
	 */
	public OddMagicSquare(int n) {
		magic=new int[n][n];
		this.n=n;
/*		for (int i = 0; i < magic.length; i++) {
			Arrays.fill(magic[i],-1);
		}*/
	}
/**
 * 마방진의 기본 생성자 - <code>OddMagicSquare(int n)</code>을 이용하여
 * 홀수마방진의 대표인 3마방을 만든다. 
 */
	public OddMagicSquare() {
		this(3);
	}
	/**
	 * 만들어진 마방진을 얕은 복사해준다. 
	 * @return 완성된 2차원 마방진
	 */
	public int[][] getMagic() {
		return magic;
	}
/**
 * 마방진을 완성한다. 
 */
	public void make() {
		int x=0;
		int y=n/2;
		for (int i = 1; i <= n*n; i++) {
			this.magic[x][y]=i;
			int tempX=x;
			int tempY=y;
			if(x-1<0) {x=n-1;
			}else {x--;}
			
			if(y-1<0) {y=n-1;
			}else {y--;}
			
			if(magic[x][y]!=0) {
				x=tempX+1;
				y=tempY;
			}
			
			
		}
	}
	
	public boolean isCheck() {
		boolean isS=true;
		int [] mm=new int[2*n+2];
		for (int i = 0; i < n; i++) {
			mm[i]=sumRow(i);
			mm[i+n]=sumCol(i);
		}
		mm[2*n]=sumDia();
		mm[2*n+1]=sumAntDia();
		for (int i = 1; i < mm.length; i++) {
			if(mm[0]!=mm[i]) {
				isS=false;
				break;
			}
		}
		
		return isS;
	}
	private int sumRow(int row) {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[row][i];
		}
		return tot;
	}
	private int sumCol(int col) {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][col];
		}
		return tot;
	}
	private int sumDia() {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][i];
		}
		return tot;
	}
	private int sumAntDia() {
		int tot=0;
		for (int i = 0; i < magic.length; i++) {
			tot+=magic[i][n-1-i];
		}
		return tot;
	}
	public void print() {
		System.out.printf("%d is magic? %b\n",n,isCheck());
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic[i].length; j++) {
				System.out.printf("%d\t",magic[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		OddMagicSquare odd=new OddMagicSquare(n);
		odd.make();
		odd.print();
	}
	
	
	
}
