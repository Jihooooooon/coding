package ssafy1022;

public class MyQueue<T> {
	private int size;
	private int front;
	private int rear;
	private T[] data;
	
	public MyQueue(){
		size=100;
		front=-1;
		rear=-1;
		data = (T[])new Object[size];
	}
	
	public boolean enQueue(T d) {
		if(this.isFull()) {
			return false;
		}
		if(front<0) {
			front=0;
		}
		data[++rear]=d;
		return true;
	}
	public T deQueue() {
		if(!this.isEmpty()) {
			T temp = this.data[front];
			data[front++]=null;
			return temp;
		}
		return null;
	}
	public boolean isEmpty() {
		if(front>rear) {
			return true;
		}
		else if(front==rear&&front==-1) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isFull() {
		if(rear==this.size-1) {
			return true;
		}
		else {
			return false;
		}
	}
	public T Qpeek() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.data[front];
		}
	}
	public int size() {
		return this.rear;
	}

}
