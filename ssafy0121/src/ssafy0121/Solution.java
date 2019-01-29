package ssafy0121;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int test = 1; test <= 10; test++) {
			int sLen = sc.nextInt();
			String tempLen = sc.next();
			
			Stack<String> stack1 = new Stack<>();
			Stack<String> stack2 = new Stack<>();

			for (int i = 0; i < sLen; i++) {
				if (tempLen.charAt(i) == '+') {
					if (stack1.isEmpty()) {
						stack1.push("+");
					} else {
						stack1.pop();
						int temp1=Integer.parseInt(stack2.pop());
						int temp2 = Integer.parseInt(stack2.pop());
						int result = temp1+temp2;
						stack2.push(String.valueOf(result));
						stack1.push("+");
						

					}
				} else {
					stack2.push((tempLen.substring(i, i + 1)));
				}
			}
			int result=0 ;
			
			int temp1 = Integer.parseInt(stack2.pop());
			int temp2 = Integer.parseInt(stack2.pop());
			result = temp1+temp2;
			
			

			System.out.println("#" + test + " " + result);
		}
	}

}
