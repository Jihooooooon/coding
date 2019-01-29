package com.ssafy.edu.second;

import java.util.Scanner;

public class DNumber {
	static Scanner sc = new Scanner(System.in);

	/*
	 * 
	 * 모든 약수를 출력
	 * 
	 * @param n
	 */
	public static void printDivide(int n) {
		if (n == 1) {
			System.out.println("[1]");
			return;
		} else {
			System.out.print("[1,");
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					System.out.printf("%d,", i);
				}
			}
			System.out.println(n + "]");
		}

	}

	public static void printPerfect(int st, int ed) {
		for (int i = st; i < ed; i++) {
			if (i == sumDivide(i)) {
				System.out.printf("%d: ", i);
				printDivide(i);

			}
		}
	}

	public static void printAmicable(int st, int ed) {
//		System.out.print("[");
//		for(int i=st; i<ed-1; i++) {
//			
//			for(int j =i+1 ; j<ed; j++) {
//				if(i==sumDivide(j)&&j==sumDivide(i)&&isPrime(i)&&isPrime(j)) {
//					System.out.printf("%d,%d", i,j);
//				}
//			}
//		}
//		
		for (int i = st; i < ed; i++) {
			int A = i;
			int B = sumDivide(A);
			int C = sumDivide(B);
			if (!isPrime(A) && !isPrime(B) && (A < B) && (A == C)) {
				System.out.printf("(%d,%d)\n", A, B);
			}
		}
	}

	public static boolean isPrime(int n) {
		for (int i = 1; i < (int) (Math.sqrt(n)); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static int sumDivide(int n) {
		int sum = 1;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) {
				sum += i;
			}
		}
		return sum;
	}
	public static int each(int n) {
		int tot=0;
		while(n!=0) {
			tot +=n%10;
			n/=10;
		}
		return tot;
	}
	
	public static int sumDividePrime(int n) {
		int tot=0;
		int a=2;
		while(n!=1) {
			if(n%a==0) {
				tot+=each(a);
				n /=a;
			}
			else {
				a++;
			}
		}
		return tot;
	}
	
	public static void printSmith(int st, int ed) {
		for(int i =st; i < ed; i++) {
			if(isSmith(i)) {
				System.out.printf("%d is smith number !\n",i);
			}
		}
	}

	public static boolean isSmith(int n) {
		boolean isS=false;
		if(!isPrime(n) && (each(n)==sumDividePrime(n))) {
			System.out.printf("%d is smith number !!\n",n);
			isS=true;
		}
		
		return isS;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a = System.nanoTime();
		printAmicable(2, 100000);

		System.out.println((System.nanoTime() - a) / 1000000);
	}

}
