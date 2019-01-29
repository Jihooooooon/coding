package ssafy1022;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		
		ArrayList<Integer> answer = new ArrayList<>();
		Stack<Integer> building = new Stack<>();
		for (int i = 1; i <= n; i++) {
			int temp = sc.nextInt();
			if (stack.isEmpty()) {
				answer.add(0);
				stack.push(i);
				building.push(temp);
			} else {

				while (!building.isEmpty()) {
					if(building.peek()>temp) {
						answer.add(stack.peek());
						building.push(temp);
						stack.push(i);
						break;
					}
					else if(building.peek()==temp) {
						answer.add(stack.pop());
						stack.push(i);
						building.push(temp);
						break;
					}
					else if(building.peek()<temp) {
						stack.pop();
						building.pop();
					}
				}
				if(stack.isEmpty()) {
					answer.add(0);
					stack.push(i);
					building.push(temp);
				}

			}
		}
		for(Integer t:answer) {
			System.out.print(t+" ");
		}

	}

}
