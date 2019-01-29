package com.ssafy.edu.first;

import java.util.Arrays;
import java.util.Scanner;

public class SixMagicSquare {
	private int[][] magic;
	private int n;
	
	public SixMagicSquare(int n) {
		magic=new int[n][n];
		this.n=n;
/*		for (int i = 0; i < magic.length; i++) {
			Arrays.fill(magic[i],-1);
		}*/
		//
	}

	public SixMagicSquare() {
		this(6);
	}
	public int[][] getMagic() {
		return magic;
	}
	public void make() {
		makeA();
		makeB();
		makeC();
		makeD();
		makeMulti();
		makeOdd();
	}
	
	private void makeOdd() {
		OddMagicSquare odd=new OddMagicSquare(n/2);
		odd.make();
		int[][]mm=odd.getMagic();
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				magic[i][j]+=mm[i][j];
				magic[i][j+n/2]+=mm[i][j];
				magic[i+n/2][j]+=mm[i][j];
				magic[i+n/2][j+n/2]+=mm[i][j];
			}
		}
	}

	private void makeMulti() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				magic[i][j] *=(n/2*n/2);
			}
		}
	}

	private void makeD() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				if(magic[i][j+n/2]==1) {
					magic[i+n/2][j+n/2]=2;
				}else {
					magic[i+n/2][j+n/2]=1;
				}
			}
		}
	}

	private void makeC() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				if(magic[i][j]==0) {
					magic[i+n/2][j]=3;
				}else {
					magic[i+n/2][j]=0;
				}
			}
		}
	}

	private void makeB() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2; j++) {
				magic[i][j+n/2]=1;
			}
		}
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/2-(n/4-1); j++) {
				magic[i][j+n/2]=2;
			}
		}
	}

	private void makeA() {
		for (int i = 0; i < n/2; i++) {
			for (int j = 0; j < n/4; j++) {
				if(i==n/4) {
					magic[i][j+1]=3;
				}else {
					magic[i][j]=3;
				}
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
		SixMagicSquare odd=new SixMagicSquare(n);
		odd.make();
		odd.print();
	}
	
	
	
}
