package com.ssafy.algo;

public class Permutation {
	
	public static void swap(int[]arr, int i, int j) {
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

	public static void permute(int[] arr, int index,int cnt) {
		if(index==arr.length || index==cnt) {
			for(int i=0; i<cnt; i++) {
				System.out.print(arr[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=index; i<arr.length; i++) {
			swap(arr,index,i);
			permute(arr,index+1,cnt);
			swap(arr,index,i);
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] temp = {1,2,3,4,5,6};
		
		permute(temp,0,2);
	}

}
