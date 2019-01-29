package ssafy0114;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution1949 {
	static Scanner sc = new Scanner(System.in);
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int N, K;
	static int maxRoute;
	static int[][] arr;
	static boolean[][] visit;

	public static boolean canGo(int x, int y) {
		boolean isG = false;
		if (x >= 0 && x < N && y >= 0 && y < N) {
			isG = true;
		}
		return isG;
	}

	public static void solution(int i, int j, boolean kUsed, int count) {

		int nextX = 0;
		int nextY = 0;
		for (int k = 0; k < 4; k++) {
			nextX = i + dx[k];
			nextY = j + dy[k];
			if (kUsed) {
				if (canGo(nextX, nextY)&&!visit[nextX][nextY] && arr[i][j] > arr[nextX][nextY]) {
					visit[nextX][nextY]=true;
					solution(nextX, nextY, kUsed, count + 1);
					visit[nextX][nextY]=false;
				}

			} else {
				if (canGo(nextX, nextY)&&!visit[nextX][nextY]&& arr[i][j] > arr[nextX][nextY]) {
					visit[nextX][nextY]=true;
					solution(nextX, nextY, kUsed, count + 1);
					visit[nextX][nextY]=false;
				} else if (canGo(nextX, nextY)&&!visit[nextX][nextY]&& arr[i][j] > arr[nextX][nextY] - K) {
					for(int tempK=1; tempK<=K; tempK++) {
						if(arr[i][j] > arr[nextX][nextY] - tempK) {

							arr[nextX][nextY]-=tempK;
							visit[nextX][nextY]=true;
							solution(nextX, nextY, true, count + 1);
							arr[nextX][nextY]+=tempK;
							visit[nextX][nextY]=false;
							break;
						}
					}
				}

			}
		}

		if (count > maxRoute) {
			maxRoute = count;
		}
		return;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for (int test = 1; test <= testCase; test++) {
			N = sc.nextInt();
			K = sc.nextInt();
			int maxValue = 0;
			arr = new int[N][N];
			visit = new boolean[N][N];
			ArrayList<Pair> maxList = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
					maxValue = maxValue < arr[i][j] ? arr[i][j] : maxValue;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == maxValue) {
						maxList.add(new Pair(i, j));
					}
				}
			}
			for (Pair temp : maxList) {
				visit[temp.getX()][temp.getY()]=true;
				solution(temp.getX(), temp.getY(), false, 1);
				visit[temp.getX()][temp.getY()]=false;
			}
			
			System.out.println("#"+test+" "+maxRoute);
			maxRoute=0;
			
		}
	}

	public static class Pair {
		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public Pair(int inputX, int inputY) {
			this.x = inputX;
			this.y = inputY;
		}
	}

}
