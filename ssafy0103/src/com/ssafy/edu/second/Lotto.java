package com.ssafy.edu.second;

public class Lotto {
	private int[] lots;

	public Lotto(int n) {
		lots = new int[n];
	}

	public Lotto() {
		this(6);
	}

	public int makeNum() {
		return (int) ((Math.random() * 45) + 1);
	}

	public boolean contains(int m) {
		boolean isC = false;
		for (int i = 0; i < lots.length; i++) {
			if (m == lots[i]) {
				isC = true;
				break;
			}
		}
		return isC;
	}
	
	

	public void make() {
		lots = new int[6];
		int count = 0;
		while (count != lots.length) {
			int temp = makeNum();
			if (!contains(temp)) {
				lots[count++] = temp;
			}
		}
		bubbleSort();
	}
	
	public void swap(int i, int j) {
		int temp = lots[i];
		lots[i]=lots[j];
		lots[j]=temp;
	}
	
	public void bubbleSort() {
		for (int i = 0; i < lots.length-1; i++) {
			for(int j=0; j < lots.length-1-i; j++) {
				if(lots[j]>lots[j+1]) {
					swap(j,j+1);
				}
			}
		}
	}

		public void print() {
			// TODO Auto-generated method stub
			for(int i=0; i<lots.length; i++)
			{
				System.out.printf("%d\t",lots[i]);
			}
			System.out.println();
		}
}
