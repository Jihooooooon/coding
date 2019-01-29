package ssafy1022;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Maijju {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<Node> list = new LinkedList<Node>();
		Scanner sc = new Scanner(System.in);
		int candy =6;
		int num=1;
		list.add(new Node(1));
		while(candy>0) {
			sc.nextLine();
			System.out.println("큐에 있는 사람 수"+list.size());
			Node temp = list.poll();
			temp.setCount(temp.getCount()+1);
			System.out.println("현재 일인당 나눠주는 사탕의 수:"+temp.getCount());
	
			if(candy-temp.getCount()>0) {
				candy-=temp.getCount();
				int temp2 = 20-candy;
				System.out.println("현재까지 나눠준 사탕의 수 : "+temp2);
				temp.setMaijju(temp.getMaijju()+temp.getCount());
			}
			else {
				
				temp.setMaijju(temp.getMaijju()+candy);
				candy=0;
				System.out.println("마지막 캔디를 가져간 사람은???   "+temp.getNum());
				break;
			}
			
			
			list.add(temp);
			num++;
			list.add(new Node(num));
		}
	}
	
	public static class Node{
		
		int num;
		int count;
		int maijju;
		
		
		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getMaijju() {
			return maijju;
		}

		public void setMaijju(int maijju) {
			this.maijju = maijju;
		}

		public Node(int num) {
			this.num=num;
			this.count=0;
			this.maijju=0;
		}
		
		public Node(int num, int count, int maijju) {
			this.num=num;
			this.count=count;
			this.maijju=maijju;
		}
	}

}
