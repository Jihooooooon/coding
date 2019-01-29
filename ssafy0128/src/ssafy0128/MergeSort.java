package ssafy0128;

import java.util.Arrays;

public class MergeSort {

	public static void mergeSort(int[] arr, int start, int end) {
		int mid;
		if(start < end) {
			mid=(start+end)/2;
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start,mid,  end);
		}
		
	}
	
	public static void merge(int[] arr, int start, int mid, int end) {
		int i,j,k,t;
		i=start;
		j=mid+1;
		k=start;
		int[] sorted = new int[arr.length];
		while (i <= mid && j <= end) {
            if (arr[i] <= arr[j])
                sorted[k] = arr[i++];
            else
                sorted[k] = arr[j++];
            k++;
        }
 
        if (i > mid) {
            for (t = j; t <= end; t++, k++)
                sorted[k] = arr[t];
        } else {
            for (t = i; t <= mid; t++, k++)
                sorted[k] = arr[t];
        }
 
        for (t = start; t <= end; t++)
            arr[t] = sorted[t];
 

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[]= {2,269,10,30,2,16,8,31,22,1000,999};
		mergeSort(temp,0,temp.length-1);
		System.out.println(Arrays.toString(temp));
	}

}
