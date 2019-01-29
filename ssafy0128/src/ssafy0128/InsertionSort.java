package ssafy0128;

import java.util.Arrays;

public class InsertionSort {



	public static void insertionSort(int[] temp, int inputSize) {
		for (int i = 1; i < inputSize; i++) {
			int pivot =temp[i];
			int j=i-1;
			for (; j >= 0; j--) {
				if(pivot<temp[j]) {
					temp[j+1]=temp[j];
				}
				else if(temp[j]<=pivot) {
					break;
				}
			}
			temp[j+1]=pivot;
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[]= {2,2,69,10,30,2,16,8,31,22};
		insertionSort(temp, 10);
		System.out.println(Arrays.toString(temp));
	}

}
