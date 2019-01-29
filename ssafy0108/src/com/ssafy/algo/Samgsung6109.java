package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Samgsung6109 {
	// left 0,right 1,up 2,down 3
	static int[] dx = { 0, 0, +1, -1 };
	static int[] dy = { +1, -1, 0, 0 };
	static int[][] map;
	static int N;
	static int direct;

	public void printArr() {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	

	public void findRowLeft(int row, int colIndex) {
		if(colIndex ==N) {
			for(int i=0; i<N-1; i++) {
				if(map[row][i]!=0) {
					continue;
				}
				for(int j=0; j<N;j++) {
					if(map[row][j]!=0) {
						map[row][i]=map[row][j];
						map[row][j]=0;
						break;
					}	
				}
			}
			return;
		}
		if(map[row][colIndex]==0) {
			findRowLeft(row, colIndex+1);
		}

		for(int i=colIndex+1; i<N;i++) {
			if(map[row][i]!=0&&map[row][i]!=map[row][colIndex]) {
				
				
				break;
			}
			if(map[row][i]==map[row][colIndex]) {
				map[row][colIndex] += map[row][i];
				map[row][i]=0;
			}
		}
		findRowLeft(row, colIndex+1);
		
	}

	public void findRowRight(int row, int colIndex) {
		if(colIndex ==0) {
			for(int i=N-1; i>0; i--) {
				if(map[row][i]!=0) {
					continue;
				}
				for(int j=i-1; j>=0;j--) {
					if(map[row][j]!=0) {
						map[row][i]=map[row][j];
						map[row][j]=0;
						break;
					}	
				}
			}
			return;
		}
		if(map[row][colIndex]==0) {
			findRowRight(row, colIndex-1);
		}
		
		for(int i=colIndex-1; i>=0;i--) {
			if(map[row][i]!=0&&map[row][i]!=map[row][colIndex]) {
				
				
				break;
			}
			if(map[row][i]==map[row][colIndex]) {
				map[row][colIndex] += map[row][i];
				map[row][i]=0;
			}
		}
		findRowRight(row, colIndex-1);

	}

	public void findColUp(int col, int rowIndex) {
		if(rowIndex ==N) {
			for(int i=0; i<N-1; i++) {
				if(map[i][col]!=0) {
					continue;
				}
				for(int j=0; j<N;j++) {
					if(map[j][col]!=0) {
						map[i][col]=map[j][col];
						map[j][col]=0;
						break;
					}	
				}
			}
			return;
		}
		if(map[rowIndex][col]==0) {
			findColUp(col, rowIndex+1);
		}
		
		for(int i=rowIndex+1; i<N;i++) {
			if(map[i][col]!=0&&map[i][col]!=map[rowIndex][col]) {
			
				
				break;
			}
			if(map[i][col]==map[rowIndex][col]) {
				map[rowIndex][col] += map[i][col];
				map[i][col]=0;
			}
		}
		findColUp(col, rowIndex+1);
		
	}

	public void findColDown(int col, int rowIndex) {
		if(rowIndex ==0) {
			for(int i=N-1; i>0; i--) {
				if(map[i][col]!=0) {
					continue;
				}
				for(int j=i-1; j>=0;j--) {
					if(map[j][col]!=0) {
						map[i][col]=map[j][col];
						map[j][col]=0;
						break;
					}	
				}
			}
			return;
		}
		if(map[rowIndex][col]==0) {
			findColDown(col, rowIndex-1);
		}

		for(int i=rowIndex-1; i>=0;i--) {
			if(map[i][col]!=0&&map[i][col]!=map[rowIndex][col]) {
				
				
				break;
			}
			if(map[i][col]==map[rowIndex][col]) {
				map[rowIndex][col] += map[i][col];
				map[i][col]=0;
			}
		}
		findRowRight(col, rowIndex-1);
	}

	public void makeSolution() {
		
		int tempI;
		int tempJ;
		if (direct == 0) {
			for (int i = 0; i < N; i++) {
				findRowLeft(i,0);
			}
		} else if (direct == 1) {
			for (int i = 0; i < N; i++) {
				findRowRight(i,N-1);
			}
		} else if (direct == 2) {
			for (int i = 0; i < N; i++) {
			//	findColUp(i);
			}
		} else {
			for (int i = 0; i < N; i++) {
			//	findColDown(i);
			}
		}

	}

	public void solution() {
		int test_case = sc.nextInt();
		for (int test = 1; test <= test_case; test++) {
			N = sc.nextInt();
			String tempDirect = sc.next();
			if (tempDirect.equals("left")) {
				direct = 0;
			} else if (tempDirect.equals("right")) {
				direct = 1;
			} else if (tempDirect.equals("up")) {
				direct = 2;
			} else {
				direct = 3;
			}
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			makeSolution();

			System.out.println("#"+test);
			printArr();
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Samgsung6109().solution();
	}

	static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		static String nextLine() {
			try {
				return br.readLine();
			} catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}

		static String nextLineReplaceAll() {
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
