package com.ssafy.edu.forth;

import java.util.Arrays;
import java.util.Scanner;

public class FourMagicSquare extends MagicSquare{
	
	public FourMagicSquare(int n) {
		super(n);
	}

	
	@Override
	public void make() {
		makeA();
		makeR();
	}
	
	private void makeR() {
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				if((i>=0 && i<n/4) ||(i>=n/4*3 && i<n)) {
					if(j>=n/4 && j<n/4*3) {
						magic[i][j]=n*n-(i*n+j);
					}
				}else {
					if((j>=0 && j<n/4) ||(j>=n/4*3 && j<n)) {
						magic[i][j]=n*n-(i*n+j);
					}
				}
			}
		}
	}

	private void makeA() {
		for (int i = 0; i < magic.length; i++) {
			for (int j = 0; j < magic.length; j++) {
				magic[i][j]=i*n+j+1;
			}
		}
	}
	
	@Override
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
	
	
	
	
}
