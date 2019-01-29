package ssafy1022;

import java.util.LinkedList;
import java.util.ListIterator;

public class Test05 {

	public static void main(String[] args) {
		int n = 10;
		int k=3;
		
		LinkedList<Integer> list = new LinkedList<>();
		
		for(int i=0; i<=10; i++) {
			list.add(i);
		}
		
		int jumpCnt=1;
		while(list.size()>(k-1)) {
			ListIterator<Integer> iterator = list.listIterator();
			
			while(iterator.hasNext()) {
				int x = iterator.next();
				if(jumpCnt%k==0) {
					System.out.println(x+"삭제함.");
					iterator.remove();
				}
				jumpCnt++;
			}
		}
		System.out.println("남은 번호:"+list.toString());
	}
}
