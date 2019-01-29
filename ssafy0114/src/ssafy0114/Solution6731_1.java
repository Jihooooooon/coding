package ssafy0114;

import java.util.Scanner;

public class Solution6731_1 {
	static Scanner sc = new Scanner(System.in);
	static int minCount;
	static int N;
	static int map[][] = new int[1000][1000];
	static boolean flag=true;
	// 주어진 행과 열을 뒤집는다
	// 0은 W, 1은 B
	// 모두 W인 배열을 주어진 배열로 바꾸는 것을 거꾸로 생각해서
	// 주어진 배열을 모두 W인 배열로 바꾼다. 이때 같은 자리를 두번 뒤집으면
	// 자기자신이므로 각 index는 한번만 뒤집는다고 가정한다. 또 w인 index는
	// 뒤집을 필요가 없으므로 B인 index만 뒤집는다.
	public static void chageMap(int a, int b) {

		for (int i = 0; i < N; i++) {
			map[i][b] = (map[i][b] ^ 1);
		}
		for (int i = 0; i < N; i++) {
			if (i == b)
				continue;
			map[a][i] = (map[a][i] ^ 1);
		}
	}

	// 배열이 다 0인지를 검사하는 함수
	public static boolean is0() {
		boolean is0 = true;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if ((map[i][j] ^ 0) != 0) {
					is0 = false;
					break;
				}
			}
			if (!is0) {
				break;
			}
		}
		return is0;
	}

	public static void init() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}
	}

	public static void swap(pair[] temp, int a, int b) {
		pair x = temp[a];
		temp[a] = temp[b];
		temp[b] = x;
	}

	public static void solution(pair[] tempArr, int bCount, int count, int i) {
		// map 이 다 0이거나 B숫자만큼 검사를 햇을 경우 종료
		if (count >= bCount || is0()) {
			if (is0()) {
				minCount = minCount > count ? count : minCount;
				if (minCount == 3&& flag) {
					flag=false;
					for (int k = 0; k < bCount; k++) {
						System.out.print(tempArr[k].getX() + "," + tempArr[k].getY() + "->");
					}
					System.out.println();
				}
			}
			return;
		}
		// 검은색 좌표들을 순열로 만들어서 재귀
		for (int j = i; j < bCount; j++) {
			swap(tempArr, i, j);
			chageMap(tempArr[i].getX(), tempArr[i].getY());
			solution(tempArr, bCount, count + 1, i + 1);
			chageMap(tempArr[i].getX(), tempArr[i].getY());
			swap(tempArr, i, j);
		}
	}

	public static void main(String[] args) {

		int t = sc.nextInt();

		for (int test = 1; test <= t; test++) {
			N = sc.nextInt();
			map = new int[N][N];
			int bCount = 0;
			pair[] tempArr = new pair[N * N];
			minCount = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < N; j++) {
					char temp = s.charAt(j);
					int tempResult = 0;
					if (temp == 'B') {
						// 검은색일때 pair로 좌표를 저장
						tempResult = 1;
						tempArr[bCount++] = new pair(i, j);
					}
					map[i][j] = tempResult;
				}
			}
			solution(tempArr, bCount, 0, 0);
			System.out.println("#" + test + " " + minCount);

		}
	}

	public static class pair {
		private int x;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		private int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}