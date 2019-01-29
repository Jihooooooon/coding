package com.ssafy.edu.second;

import java.util.Scanner;

public class PuzzleGoal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
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

		}
	}

	public static class move_info {
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

}
