package ssafy0114;

import java.util.Arrays;

public class Quicksort {
	
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a]= arr[b];
		arr[b]= temp;
	}
	
	public static int partition(int[] arr, int start, int end) {
		int left =start;
		int right = end+1;
		int pivot = arr[start];
		do {
			do {
				left++;
			} while (left<=end && arr[left]<pivot);
			do {
				right--;
			} while (start<=right && arr[right]>pivot);
			if(left<right) {
				swap(arr, left, right);
			}
		}while(left<right);
		swap(arr, start, right);
		
		return right;
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start< end) {
			int temp= partition(arr, start, end);
			
			quickSort(arr, start, temp-1);
			quickSort(arr, temp+1, end);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test= {3,5,6,1,2,40,17,16,99,77,66,41,37,89,100,23};
		quickSort(test, 0, test.length-1);
		System.out.println(Arrays.toString(test));
	}

}
