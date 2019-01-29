package ssafy0114;

import java.util.Scanner;

public class Subset {
	static Scanner sc = new Scanner(System.in);
	public static boolean solution(int[] test) {
		int result=0;
		boolean isR=false;
		boolean isU=false;
		for(int i=0; i<(1<<test.length); i++) {
			isU=false;
			result=0;
			for(int j=0; j<test.length; j++) {
				
				if((i&(1<<j))!=0) {
					result +=test[j];
					isU=true;
					
				}
				
			}
			
			if(result==0&&isU) {
				isR=true;
				break;
			}
		}
		
		return isR;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] temp = new int[10];
		int index=0;
		for(int i=0; i<temp.length; i++) {
			temp[index++]= sc.nextInt();
		}
	
		System.out.println(solution(temp));
	}

}
