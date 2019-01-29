package com.ssafy.algo;

public class Baby_ginGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = {1,2,3};
		for(int i:temp) {
			for(int i2:temp) {
				if(i2 !=i) {
				for(int i3: temp) {
					if(i3!=i && i3 !=i2) {
						System.out.print(i+" "+i2+" "+i3);
						System.out.println();
					}
				}
				}
			}
		}
	}

}
