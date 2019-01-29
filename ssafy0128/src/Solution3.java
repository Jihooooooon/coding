import java.util.ArrayList;
import java.util.Scanner;

public class Solution3 {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		for (int test = 1; test <= 10; test++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				list.add(sc.nextInt());
			}
			int order = sc.nextInt();

			for (int i = 0; i < order; i++) {
				sc.next();
				int index = sc.nextInt();
				int count = sc.nextInt();
				for (int k = index, j = 0; j < count; j++, k++) {
					list.add(k, sc.nextInt());
				}
			}
			System.out.print("#"+test);
			for(int tt=0; tt<10; tt++) {
				System.out.print(" "+list.get(tt));
			}
            System.out.println();
		}
	}

}
