package com.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution6856 {
	static int N, M;
	static Set<Integer>[] list = new HashSet[1001];
	static Set<Integer> left = new HashSet<>();
	static Set<Integer> right = new HashSet<>();
	static boolean[] isUse;
	
	public static boolean pushNum(Set<Integer> set, int num, boolean[] isUse) {
		Iterator<Integer> iter3 = list[num].iterator();
		while(iter3.hasNext()) {
			int temp = iter3.next();
			if(set.contains(temp)) {
				return false;
			}
			
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		int testCase = sc.nextInt();
		for (int i = 1; i < 1001; i++) {
			list[i] = new HashSet<>();
		}
		for (int test = 1; test <= testCase; test++) {

			N = sc.nextInt();
			M = sc.nextInt();

			for (int i = 0; i < M; i++) {
				int temp1 = sc.nextInt();
				int temp2 = sc.nextInt();
				list[temp1].add(temp2);
				list[temp2].add(temp1);
			}
			isUse = new boolean[N+1];
			boolean impossible = false;
			for (int i = 1; i < N + 1; i++) {
				if(isUse[i]) {
					continue;
				}
				Set<Integer> remainder;
				Set<Integer> prior = left;

				prior = left.size() > right.size() ? right : left;
				if (prior == left) {
					remainder = right;
				} else {
					remainder = left;
				}
				Iterator<Integer> iter = list[i].iterator();
				Iterator<Integer> iter2 = list[i].iterator();
				boolean flag1 = false;
				boolean flag2 = false;

				while (iter.hasNext()) {
					if (prior.contains(iter.next())) {
						flag1 = true;
						break;
					}
				}
				if (!flag1) {
					prior.add(i);
					isUse[i]=true;
					iter = list[i].iterator();
					while(iter.hasNext()) {
						int temp=iter.next();
						if(pushNum(remainder, temp,isUse)) {
							remainder.add(temp);
							isUse[temp]=true;
						}
						else {
							flag1=true;
							break;
						}
						
						
					}
				} else {
					while (iter2.hasNext()) {
						if (remainder.contains(iter2.next())) {
							flag2 = true;
							break;
						}
					}
					if (!flag2) {
						remainder.add(i);
						isUse[i]=true;
						iter2 = list[i].iterator();
						while(iter2.hasNext()) {
							int temp=iter2.next();
							if(pushNum(remainder, temp,isUse)) {
								remainder.add(temp);
								isUse[temp]=true;
							}
							else {
								flag2=true;
								break;
							}
							
						}
					}
				}

				if ((flag1 && flag2) == true) {
					impossible = true;
					break;
				}
			}
			if (impossible) {
				System.out.println("#" + test + " -1");
			} else {
				System.out.println("#" + test + " " + (left.size() < right.size() ? left.size() : right.size()));
			}
			for (int i = 1; i < N + 1; i++) {
				list[i].clear();
			}
			left.clear();
			right.clear();
		}
	}

	static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String readLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String readLineReplaceAll() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}

		static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
