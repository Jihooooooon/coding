package ssafy0121;

import java.util.Arrays;

public class QuickSort {
	
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
		int[] test= {3,5,6,1,2,40,17,16,99,77,66,41,37,89,100,23};
		sort(test, 0, test.length-1);
		System.out.println(Arrays.toString(test));
	}

}
