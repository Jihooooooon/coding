package ssafy0115;

import java.util.Scanner;
import java.util.Stack;

public class Problem {

	public static void dfs(int[][] a, boolean[] c, int v) {
		Stack<Integer> stack = new Stack<>();
		int n = a.length - 1;
		stack.push(v);
		c[v] = true;
		System.out.print(v + " ");
		boolean flag;
		while (!stack.isEmpty()) {
			int vv = stack.peek();
			flag = false;
			for (int i = 1; i <= n; i++) {
				if (a[vv][i] == 1 && !c[i]) {
					stack.push(i);
					System.out.print(i + " "); 
					c[i] = true;
					flag = true;
					break;
					}
				}
			if (!flag) {
				stack.pop(); 
				}
			} 
		}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int temp[] = {1,2,1,3,2,4,2,5,4,6,5,6,6,7,3,7};
		int[][] a = new int[8][8];
		boolean[] b = new boolean[8];
		for(int i=0; i<temp.length-1;i+=2) {
			a[temp[i]][temp[i+1]]=1;
			a[temp[i+1]][temp[i]]=1;
		}
		dfs(a, b, 1);
	}

}
