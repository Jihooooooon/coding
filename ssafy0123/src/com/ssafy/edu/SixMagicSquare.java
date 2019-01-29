package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class SixMagicSquare extends MagicSquare{

	public SixMagicSquare(int n) {
		super(n);
	}

	public SixMagicSquare() {
		this(6);
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

	
}
