package ssafy0121;

import java.util.Stack;

public class Test {
	
	public static void main(String[] args) {
		int a =4;
		char b = Character.forDigit(a, 10);
		Stack<Character> stack = new Stack<>();
		stack.push(b);
		System.out.println(stack.size());
		System.out.format("%s", stack.pop());
	}

}

class Parent{
	int k=5;
	void show() {}
	void down() {}
}
class Child extends Parent{
	int k=10;
	void show() {}
	void down() {}
}
