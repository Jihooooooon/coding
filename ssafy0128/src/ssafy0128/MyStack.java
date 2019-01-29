package ssafy0128;

public class MyStack<T> {
	private Node head;
	private Node top;
	private int size;
	
	public int size() {
		return this.size;
	}
	public MyStack() {
		this.head= new Node();
		this.top = new Node();
		this.size=0;
	}
	public void push(T data) {
		if(size==0) {
			head.next=new Node(data);
			size++;
			top = head.next;
		}
		else {
			top.next = new Node(data);
			top = top.next;
			size++;
		}
		
	}
	
	public void print() {
		Node<T> temp = head;
	
		while(temp.next!=null) {
			temp = temp.next;
			System.out.print(temp.data+" ");
		}
	}
	
	private Node<T> getNode(int index){
		if(index>=size) {
			return null;
		}
		else {
			int count=0;
			Node<T> pivot = head;
			while(true) {
				if(count==index+1) {
					break;
				}
				pivot = pivot.next;
				count++;
			}
			return pivot;
		}
	}
	public Node<T> pop() {
		if(isEmpty()) {
			return null;
		}
	
		Node<T> temp = top;
		Node<T> temp2 = getNode(this.size-2);
		top=temp2;
		top.next=null;
		
		size--;
		return temp;
		
	}
	
	public Node<T> peek() {
		return this.top;
	}
	public boolean isEmpty() {
		return size==0?true:false;
		
	}
	
	private class Node<E>{
		private T data;
		public Node next;
		
		public Node() {
			this.data=null;
			this.next=null;
		}
		
		public Node(T data) {
			this.data =data;
			this.next=null;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + "]";
		}
		
		
	}

}
