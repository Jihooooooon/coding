package ssafy1022;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue2<Integer> test = new MyQueue2<>();
		System.out.println(test.enQueue(1));
		System.out.println(test.enQueue(2));
		System.out.println(test.enQueue(3));
		System.out.println(test.enQueue(4));
		System.out.println(test.enQueue(5));
		System.out.println(test.Qpeek());
		System.out.println(test.deQueue());
		System.out.println(test.deQueue());
		System.out.println(test.deQueue());
		System.out.println(test.isEmpty());
		System.out.println(test.enQueue(3));
		System.out.println(test.enQueue(4));
		System.out.println(test.enQueue(5));
		System.out.println(test.enQueue(3));
		System.out.println(test.enQueue(4));
		System.out.println(test.isFull());
		
	}

}
