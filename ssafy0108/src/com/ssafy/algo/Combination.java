package com.ssafy.algo;

public class Combination {
	
	public static void combination(int[] arr, boolean[] isUse,int cnt) {
		if(arr.length==cnt) {
			int sum=0;
			for(int i=0; i<arr.length; i++) {
				if(isUse[i]) {
					sum+=arr[i];
				}
			}
			System.out.println(sum);
			
			return;
		}
		
		isUse[cnt]=true;
		combination(arr, isUse, cnt+1);
		isUse[cnt]=false;
		combination(arr, isUse, cnt+1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] money = {10, 50, 100,500};
		combination(money,new boolean[money.length], 0);
	}

}
