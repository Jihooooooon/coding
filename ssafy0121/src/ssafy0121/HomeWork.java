package ssafy0121;

import java.util.Scanner;
import java.util.Stack;

public class HomeWork {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for(int test=1; test<=testCase; test++) {
			int arrSize = sc.nextInt()+1;
			int[] arr = new int[arrSize];
			for(int i=1; i<arrSize; i++) {
				arr[i]=sc.nextInt();
				
			}
			Stack<Integer> stack = new Stack<>();
			for(int i=arrSize-1; i>0; i--) {
				int temp = arr[i];
				boolean is=false;
				for(int j=i-1; j>0; j--) {
					if(arr[j]>=temp) {
						stack.push(j);
						is=true;
						break;
					}
					
				}
				if(!is) {
					stack.push(0);
				}
				
			}
			System.out.print("#"+test);
			while(!stack.isEmpty()) {
				System.out.print(" "+stack.pop());
				}
		}
	}

}
