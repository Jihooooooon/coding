package ssafy1022;

public class MyQueue2<T> {
	private T[] data;
	private int front;
	private int rear;
	private int arrSize;
	
	public MyQueue2(){
		data = (T[])new Object[100];
		arrSize=100;
	}
	
	public boolean enQueue(T d) {
		if(this.isFull()) {
			return false;
		}
		rear = ++rear%arrSize;
		data[rear]=d;
		return true;
	}
	public T deQueue() {
		if(isEmpty()) {
			return null;
		}
		front = ++front%arrSize;
		T temp = data[front];
		data[front]=null;
		return temp;
	}
	public boolean isEmpty() {
		return front==rear?true:false;
	}
	public boolean isFull() {
		return ((rear+1)%arrSize)==front?true:false;
	}
	public T Qpeek() {
		if(isEmpty()) return null;
		return data[(front+1)%arrSize];
	}
}
