package com.ssafy.edu.first;

public class Test {

	 public static void sort(int[] data, int l, int r){
	        int left = l;
	        int right = r;
	        int pivot = data[(l+r)/2];
	        
	        do{
	            while(data[left] < pivot) left++;
	            while(data[right] > pivot) right--;
	            if(left <= right){    
	                int temp = data[left];
	                data[left] = data[right];
	                data[right] = temp;
	                left++;
	                right--;
	            }
	        }while (left <= right);
	        
	        if(l < right) sort(data, l, right);
	        if(r > left) sort(data, left, r);
	    }




	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arrs = { 7, 5, 1, 3, 15, 16, 19, 2, 3, 3, 28, 39, 53, 100, 55, 44, 11, 14, 24, 60 };

		sort(arrs, 0, arrs.length - 1);
		System.out.println("결과");

		for (int i : arrs) {
			System.out.print(i + " ");
		}

	}

}
