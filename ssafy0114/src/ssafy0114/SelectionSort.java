package ssafy0114;

import java.util.Arrays;

public class SelectionSort {

	public static void selectionSort(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			int temp=i;
			int minValue=arr[i];
			for(int j=i; j<arr.length; j++) {
				if(minValue>arr[j]) {
					temp=j;
					minValue=arr[j];
				}
			}
			int tempR = arr[temp];
			arr[temp]=arr[i];
			arr[i]=tempR;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {5,1,3,5,9,14,17};
		selectionSort(test);
		System.out.println(Arrays.toString(test));
	}

}
