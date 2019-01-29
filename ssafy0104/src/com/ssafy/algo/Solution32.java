package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution32 {

	public int cal_reward(Attend_info[] attendArr, int[][] map, int arrX, int arrY) {
		int temp_reward = -1000 * (attendArr.length);

		for (int i = 0; i < attendArr.length; i++) {

			Attend_info temp = attendArr[i];
			int tempX = temp.getStartX();
			int tempY = temp.getStartY();
			int tempCount = temp.getJumping_count();

			boolean isLose = false;
			// 우:1 하:2 왼 :3 위:4
			// 상금: 도착지점 숫자*100
			for (int j = 0; j < tempCount; j++) {
				
				if (tempX < 1 || tempY < 1 || tempX >= arrX || tempY >= arrY || map[tempX][tempY] < 0) {
					// temp_reward -= 1000;
					isLose = true;
					break;
				}

				int direction = map[tempX][tempY] / 10;
				int move_num = map[tempX][tempY] % 10;
				switch (direction) {
				case 1:
					// 우
					tempY += move_num;
					break;

				case 2:
					tempX += move_num;
					// 하
					break;

				case 3:
					tempY -= move_num;
					// 좌
					break;

				case 4:
					tempX -= move_num;
					// 북
					break;

				default:
					break;

				}
				if (tempCount == 1) {
					if (tempX < 0 || tempY < 0 || tempX >= arrX || tempY >= arrY || map[tempX][tempY] < 0) {
						// temp_reward -= 1000;
						isLose = true;
						break;
					}

				}

			}
			if (!isLose&& map[tempX][tempY]!=-1) {
				temp_reward += 100 * map[tempX][tempY];
			}
		}
		return temp_reward;
	}

	public void solution() {
		int test_case = sc.nextInt();
		int total_reward = 0;
		for (int testCase = 1; testCase <= test_case; testCase++) {
			int arrX = sc.nextInt() + 1;
			int arrY = sc.nextInt() + 1;
			int attend_Num = sc.nextInt();
			Attend_info[] attendance = new Attend_info[attend_Num];

			int map[][] = new int[arrX][arrY];
			for (int i = 1; i < arrX; i++) {
				for (int j = 1; j < arrY; j++) {
					map[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < attend_Num; i++) {
				int startX = sc.nextInt();
				int startY = sc.nextInt();
				int jump_count = sc.nextInt();
				attendance[i] = new Attend_info(startX, startY, jump_count);
			}

			int trap_num = sc.nextInt();
			for (int i = 0; i < trap_num; i++) {
				int trapX = sc.nextInt();
				int trapY = sc.nextInt();
				map[trapX][trapY] = -1;
			}

			total_reward = cal_reward(attendance, map, arrX, arrY);
			System.out.println("#" + testCase + " " + total_reward);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sc.init();
		new Solution32().solution();
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

	public class Attend_info {
		private int startX;
		private int startY;
		private int jumping_count;

		public int getStartX() {
			return startX;
		}

		public int getStartY() {
			return startY;
		}

		public int getJumping_count() {
			return jumping_count;
		}

		public Attend_info(int inputX, int inputY, int inputCount) {
			this.startX = inputX;
			this.startY = inputY;
			this.jumping_count = inputCount;
		}
	}

}
