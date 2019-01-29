package ssafy0115;

import java.util.Scanner;

public class Solution1218 {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int test=1; test<=10; test++) {
			CharStack stack1 = new CharStack();
			CharStack stack2 = new CharStack();
			CharStack stack3 = new CharStack();
			CharStack stack4 = new CharStack();
			int num = sc.nextInt();
			String temp = sc.next();
			int result=1;
			for(int i=0; i<num;i++) {
				if(temp.charAt(i)=='(') {
					stack1.push('(');
				}
				else if(temp.charAt(i)=='[') {
					stack2.push('[');
				}
				else if(temp.charAt(i)=='{') {
					stack3.push('{');
				}
				else if(temp.charAt(i)=='<') {
					stack4.push('<');
				}
				else {
					if(temp.charAt(i)==')') {
						if(stack1.isEmpty()) {
							result=0;
							break;
						}
						else {
							stack1.pop();
						}
					}
					else if(temp.charAt(i)==']') {
						if(stack2.isEmpty()) {
							result=0;
							break;
						}
						else {
							stack2.pop();
						}
					}
					else if(temp.charAt(i)=='}') {
						if(stack3.isEmpty()) {
							result=0;
							break;
						}
						else {
							stack3.pop();
						}
					}
					else if(temp.charAt(i)=='>') {
						if(stack4.isEmpty()) {
							result=0;
							break;
						}
						else {
							stack4.pop();
						}
					}
				}
				
			}
			System.out.println("#"+test+" "+result);
		}

	}
	public static class CharStack{
        StringBuilder sb;

        public CharStack(){
            sb = new StringBuilder();
        }

        public void push(char input){
            sb.append(input);
        }
        public char peek(){
            int lastIndex = sb.length()-1;
            char result = sb.charAt(lastIndex);
            return result;
        }
        public char pop(){
            int lastIndex = sb.length()-1;
            char result = sb.charAt(lastIndex);
            sb.setLength(lastIndex);
            return result;
        }

        public int size(){
            return sb.length();
        }

        public boolean isEmpty(){
            return sb.length()==0?true:false;
        }

    }
}
