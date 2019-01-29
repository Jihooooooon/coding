package ssafy0114;

import java.util.Scanner;

public class Subset2 {
	static Scanner sc = new Scanner(System.in);
	static boolean flag;
	public static void solution(int[] temp, boolean[] isUse,int count) {
		if(count==temp.length) {
			int result=0;
			boolean isU=false;
			for(int i=0; i<temp.length; i++) {
				if(isUse[i]) {
					isU=true;
					result+=temp[i];
				}
			}
			if(result==0&&isU) {
				flag = true;
			}
			return;
		}
		isUse[count]=true;
		solution(temp, isUse, count+1);
		isUse[count]=false;
		solution(temp, isUse, count+1);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] temp = new int[10];
		boolean[] isUse = new boolean[10];
		int index=0;
		for(int i=0; i<temp.length; i++) {
			temp[index++]= sc.nextInt();
		}
		solution(temp, isUse, 0);
		System.out.println(flag);
	}

}
