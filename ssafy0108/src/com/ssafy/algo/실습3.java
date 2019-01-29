package com.ssafy.algo;

import java.util.Stack;

public class 실습3 {
	
	public static void DecimalToBinary(int n, Stack<Integer> stack) {
		if(n==0) {
			while(!stack.empty()) {
				System.out.print(stack.pop());
			}
			return;
		}
		stack.push(n%2);
		DecimalToBinary(n/2, stack);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> stack = new Stack<>();
		DecimalToBinary(16, stack);
	}

}
