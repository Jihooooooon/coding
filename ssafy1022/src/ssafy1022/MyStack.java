package ssafy1022;

public class MyStack<T> {
	private T[] data ;
	private int top;
	private int size;
	public MyStack() {
		size=100;
		data = (T[])new Object[size];
		top =0;
		
	}
	
	public void push(T d) {
		if(top>=this.size) {
			size *=2;
			T[] temp = (T[])new Object[size];
			System.arraycopy(data, 0, temp, 0, data.length);
			data = temp;
			data[top++]=d;
		}
		else {
			data[top++]=d;
		}
	}
	public T pop() {
		T temp = data[top-1];
		data[top--]=null;
		return temp;
	}
	public boolean isEmpty() {
		if(top==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public int size() {
		return this.top;
	}
	public T peek() {
		return data[top-1];
	}
}
