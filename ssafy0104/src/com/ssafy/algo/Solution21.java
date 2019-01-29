package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Scanner;



public class Solution21 {
	static Scanner sc = new Scanner(System.in);

	public static boolean jump_in_pond(int num, int row, int col, int direction, int[][] pond) {
		if (pond[row][col] != 0) {
			return true;
		}
		pond[row][col] = num;
		int next_row = row;
		int next_col = col;
		int jump_width = 3;
		if (direction == 1) {
			for (int i = 0; i < 3; i++) {
				next_row += jump_width--;
				if (next_row >= pond.length) {
					break;
				}
				if (pond[next_row][col] != 0) {
					return true;
				}
				pond[next_row][col] = num;
			}
		} else {
			for (int i = 0; i < 3; i++) {
				next_col += jump_width--;
				if (next_col >= pond.length) {
					break;
				}
				if (pond[row][next_col] != 0) {
					return true;
				}
				pond[row][next_col] = num;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testcase = sc.nextInt();
		for (int i = 1; i <= testcase; i++) {
			int pondSize = sc.nextInt();
			int saltWater_num = sc.nextInt();
			int pond[][] = new int[pondSize][pondSize];
			boolean isExist = false;
			ArrayList<info_saltWater> waterSalt_arr = new ArrayList<info_saltWater>();
			for (int j = 1; j <= saltWater_num; j++) {
				int row = sc.nextInt();
				int col = sc.nextInt();
				// 하:1, 우:2
				int direction = sc.nextInt();
				waterSalt_arr.add(new info_saltWater(j, row, col, direction));

			}

			for (int j = 0; j < waterSalt_arr.size(); j++) {
				int row = waterSalt_arr.get(j).getRow();
				int col = waterSalt_arr.get(j).getCol();
				// 하:1, 우:2
				int direction = waterSalt_arr.get(j).getDirection();
				if (jump_in_pond(waterSalt_arr.get(j).getNum(), row, col, direction, pond)) {
					System.out.println("#" + i + " " + waterSalt_arr.get(j).getNum());
					isExist = true;
					break;
				}

			}
			if (!isExist) {
				System.out.println("#" + i + " 0");
			}
		}
	}

	public static class info_saltWater {
		private int row;
		private int col;
		private int direction;
		private int num;

		public int getNum() {
			return this.num;
		}

		public int getRow() {
			return this.row;
		}

		public int getCol() {
			return this.col;
		}

		public int getDirection() {
			return this.direction;
		}

		public info_saltWater(int num, int row, int col, int direction) {
			this.num = num;
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
}
