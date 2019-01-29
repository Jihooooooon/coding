package com.ssafy.java;

public class ArrayTest {

	public static int[] list= {34,23,64,25,12,75,22,88,53,37};
	
	public static void print() {
		for(int i : list) {
			System.out.printf("%d ",i);
		}
		System.out.println();
	}
	public static void total() {
		int sum=0;
		for(int i : list) {
			sum +=i;
		}
		System.out.println("배열의 합 : " +sum);
	}
	public static void average() {
		int sum=0;
		for(int i : list) {
			sum +=i;
		}
		int average = sum/list.length;
		System.out.println("배열의 평균 :" +average);
		
	}
	
	public static void minimun() {
		int minX=Integer.MAX_VALUE;
		
		for(int i:list) {
			if(minX>i) {
				minX=i;
			}
		}
		selectionSort();
		System.out.println("배열의 최소값 :" +minX);
	}

	public static void selectionSort() {
		//선택정렬
		for(int i=0; i < list.length-1; i++) {
			int minValue = list[i];
			int index=i;
			for(int j=i+1; j<list.length; j++) {
				if(minValue >list[j]) {
					minValue=list[j];
					index=j;
				}
			}
			int temp = list[i];
			list[i]=list[index];
			list[index]=temp;
		}
		
		
		//버블정렬
		//		for (int i = 0; i < list.length-1; i++) {
		//			for(int j=0; j < list.length-1-i; j++) {
		//				if(list[j]>list[j+1]) {
		//					int temp = list[j];
		//					list[j]=list[j+1];
		//					list[j+1]=temp;
		//					
		//				}
		//			}
		//		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print();
		total();
		average();
		minimun();
		System.out.println("=== selection sort (Ascending Order)===");
		selectionSort();
		print();
	}

}
