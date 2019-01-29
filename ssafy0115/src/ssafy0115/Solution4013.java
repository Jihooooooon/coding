package ssafy0115;

import java.util.Scanner;

public class Solution4013 {

	static Scanner sc = new Scanner(System.in);
	static Gear[] list = new Gear[5];
	static int[] score= {0,1,2,4,8};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int testCase = sc.nextInt();
		for (int t = 1; t <= testCase; t++) {
			int command = sc.nextInt();
			for (int i = 1; i <= 4; i++) {
				int temp[] = new int[8];
				for (int j = 0; j < 8; j++) {
					temp[j] = sc.nextInt();
				}
				list[i] = new Gear(temp);
			}
			for (int k = 0; k < command; k++) {
				int gearNum = sc.nextInt();
				int direct = sc.nextInt();
				int temp = gearNum % 2;
				for (int i = 1; i <= 4; i++) {
					if (i % 2 == temp) {
						list[i].setRotate_direction(direct);
					}
					else {
						list[i].setRotate_direction(-direct);
					}
				}
				boolean[] isturn = new boolean[5];
				isturn[gearNum]=true;
				for(int i=gearNum-1; i>=1; i--) {
					if(list[i+1].getNsList()[list[i+1].getLeft()]!=list[i].getNsList()[list[i].getRight()]) {
						isturn[i]=true;
					}
					else {
						break;
					}
				}
				for(int i=gearNum+1; i<=4; i++) {
					if(list[i].getNsList()[list[i].getLeft()]!=list[i-1].getNsList()[list[i-1].getRight()]) {
						isturn[i]=true;
					}
					else {
						break;
					}
				}
				for(int i=1; i<=4; i++) {
					if(isturn[i]) {
						list[i].turn();
					}
				}
			}
			
			int result=0;
			for(int i=1; i<=4; i++) {
				if(list[i].getNsList()[list[i].getTop()]==1) {
					result+=score[i];
				}
			}
			System.out.println("#" + t + " "+result);
		}
	}

	public static class Gear {
		private int rotate_direction;
		private int[] nsList;
		private int top;// 0
		private int left;// 2
		private int right;// 6

		public int getRotate_direction() {
			return rotate_direction;
		}

		public void setRotate_direction(int rotate_direction) {
			this.rotate_direction = rotate_direction;
		}

		public int[] getNsList() {
			return nsList;
		}

		public void setNsList(int[] nsList) {
			this.nsList = nsList;
		}

		public int getTop() {
			return top;
		}

		public void setTop(int top) {
			this.top = top;
		}

		public int getLeft() {
			return left;
		}

		public void setLeft(int left) {
			this.left = left;
		}

		public int getRight() {
			return right;
		}

		public void setRight(int right) {
			this.right = right;
		}

		public Gear(int[] inputList) {
			this.nsList = inputList;
			this.top = 0;
			this.left = 6;
			this.right = 2;
			this.rotate_direction = 1;
		}

		public Gear(int[] inputList, int inputRotate) {
			this.nsList = inputList;
			this.top = 0;
			this.left = 6;
			this.right = 2;
			this.rotate_direction = inputRotate;
		}

		public void turn() {
			// 시계방향 회전
			if (this.rotate_direction == 1) {
				this.top--;
				this.left--;
				this.right--;
				if (this.top < 0) {
					this.top = 7;
				}
				if (this.left < 0) {
					this.left = 7;
				}
				if (this.right < 0) {
					this.right = 7;
				}
			}
			// 반시계방향 회전
			else {
				top = (top + 1) % 8;
				left = (left + 1) % 8;
				right = (right + 1) % 8;
			}
		}
	}

}
