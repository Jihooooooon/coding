package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution42 {

	public int[] canMove(int[][] puzzle, move_info[] info, int moveCount, int startX, int startY) {
		int[] result = new int[2];
		if (startX < 1 || startY < 1 || startX >= puzzle.length || startY >= puzzle.length
				|| puzzle[startX][startY] == 1) {
			return result;
		}
		// 위:1 오:2 아 :3 왼 :4
		int nextX = startX;
		int nextY = startY;
		boolean inTrap=false;
		for (int i = 0; i < moveCount; i++) {
			int direction = info[i].getDirection();
			int move_num = info[i].getMove_count();
			
			for (int j = 0; j < move_num; j++) {
				if (direction == 1) {
					nextX--;
				} else if (direction == 2) {
					nextY++;
				} else if (direction == 3) {
					nextX++;
				} else {
					nextY--;
				}
				if(nextX < 1 || nextY < 1 || nextX >= puzzle.length || nextY >= puzzle.length
						|| puzzle[nextX][nextY] == 1) {
					inTrap=true;
					break;
				}
			}
			if(inTrap) {
				break;
			}
		}
		if(!inTrap) {
			result[0]=nextX;
			result[1]=nextY;
		}
		return result;
	}

	public void solution() {

		int testcase = sc.nextInt();
		for (int i = 1; i <= testcase; i++) {
			int arrSize = sc.nextInt();
			int startX = sc.nextInt();
			int startY = sc.nextInt();
			int jumper_num = sc.nextInt();
			int puzzle[][] = new int[arrSize + 1][arrSize + 1];
			for (int j = 0; j < jumper_num; j++) {
				int tempX = sc.nextInt();
				int tempY = sc.nextInt();
				puzzle[tempX][tempY] = 1;

			}
			int move_count = sc.nextInt();
			// 위:1 오:2 아 :3 왼 :4
			move_info infoArr[] = new move_info[move_count];
			for (int j = 0; j < move_count; j++) {
				int direction = sc.nextInt();
				int move_num = sc.nextInt();
				infoArr[j] = new move_info(direction, move_num);

			}
			int[] result = canMove(puzzle, infoArr, move_count, startX, startY);
			System.out.println("#" + i + " " + result[0] + " " + result[1]);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Solution42().solution();
	}

	public class move_info {
		private int direction;
		private int move_count;

		public int getDirection() {
			return direction;
		}

		public void setDirection(int direction) {
			this.direction = direction;
		}

		public int getMove_count() {
			return move_count;
		}

		public void setMove_count(int move_count) {
			this.move_count = move_count;
		}

		public move_info(int inputDirec, int inputMove) {
			this.direction = inputDirec;
			this.move_count = inputMove;
		}

	}

	public static class sc {
		static BufferedReader br;
		static StringTokenizer st;

		public static void init() {
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		public static String readLine() {
			try {
				return br.readLine();
			} catch (IOException e) {
				// TODO: handle exception
				return null;
			}
		}

		public static String readLineReplace() {
			try {
				return br.readLine().replaceAll("\\s+", "");
			} catch (IOException e) {
				return null;
			}
		}

		public static String next() {
			while (!st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			return st.nextToken();
		}

		public static char nextChar() {
			return next().charAt(0);
		}

		public static int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
