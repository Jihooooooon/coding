package ssafy0115;

import java.util.Scanner;
import java.util.Stack;

public class Problem1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<String> stack = new Stack<>();
		Scanner sc = new Scanner(System.in);
		String s= sc.next();
		
		boolean flag=false;
		for(int i=0; i<s.length();i++) {
			if(s.charAt(i)=='(') {
				stack.push(s.substring(i, i+1));
				
			}
			else {
				
				if(stack.isEmpty()) {
					flag=true;
					break;
				}
				else {
					
					stack.pop();
				}
			}
		}
		if(flag||!stack.isEmpty()) {
			System.out.println("괄호 숫자가 맞지 않습니다.");
		}
		else {
			System.out.println("괄호 숫자가 맞습니다.");
		}
	}

}
