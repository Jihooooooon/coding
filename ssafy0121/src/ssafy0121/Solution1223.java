package ssafy0121;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution1223 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int test=1; test<=10; test++) {
			int sLen = sc.nextInt();
			Stack<String> operS = new Stack<>();
			Stack<String> postFix = new Stack<>();
			Stack<Integer> result = new Stack<>();
			String input = sc.next();
			for(int i=0; i<sLen; i++) {
				if(input.charAt(i)=='(') {
					operS.push(input.substring(i, i+1));
				}
				else if(isOper(input.charAt(i))) {
					if(operS.isEmpty()) {
						operS.push(input.substring(i,i+1));
					}
					else {
						while(true) {
							if(operS.isEmpty()) {
								operS.push(input.substring(i,i+1));
								break;
							}
							String temp = operS.peek();
							if(inStackPrior(temp)<outStackPrior(input.substring(i, i+1))) {
								
								operS.push(input.substring(i, i+1));
								break;
							}
							else {
								String temp3 = operS.pop();
								postFix.push(temp3);
							}
							
						}
					}
				}
				else if(input.charAt(i)==')') {
					while(true) {
						String temp = operS.pop();
						if(temp.equals("(")) {
							break;
						}
						else {
							postFix.push(temp);
						}
					}
				}
				else {
					postFix.push(input.substring(i,i+1));
				}
				
			}
			while(!operS.isEmpty()) {
				postFix.push(operS.pop());
			}
			ArrayList<String> list = new ArrayList<>(postFix);
			for(int k=0; k<list.size(); k++) {
				if(isOper(list.get(k).charAt(0))) {
					int temp1= result.pop();
					int temp2= result.pop();
					if(list.get(k).charAt(0)=='+') {
						result.push(temp1+temp2);
					}
					else if(list.get(k).charAt(0)=='-') {
						result.push(temp2-temp1);
					}
					else if(list.get(k).charAt(0)=='/') {
						result.push(temp2/temp1);
					}
					else if(list.get(k).charAt(0)=='*') {
						result.push(temp2*temp1);
					}
				}
				else {
					result.push(Integer.parseInt(list.get(k)));
				}
			}
			
			System.out.println("#"+test+" "+result.pop());
		}

	}
	
	public static boolean isOper(char s) {
		boolean isO=false;
		if(s=='*'||s=='-'||s=='+'||s=='/') {
			isO=true;
		}
		return isO;
	}
	public static int outStackPrior(String temp) {
		char temp2=temp.charAt(0);
		switch (temp2) {
		case '+':
			return 1;
			
		case '-':
			
			return 1;
		case '*':
			
			return 2;
		case '/':
			
			return 2;
		case '(':
			
			return 3;
	
		default:
			return -1;
		}
	}
	
	public static int inStackPrior(String temp) {
		char temp2=temp.charAt(0);
		switch (temp2) {
		case '+':
			return 1;
			
		case '-':
			
			return 1;
		case '*':
			
			return 2;
		case '/':
			
			return 2;
		case '(':
			
			return 0;
	
		default:
			return -1;
		}
	}
}
