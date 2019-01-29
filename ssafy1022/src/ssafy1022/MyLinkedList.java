package ssafy1022;

public class MyLinkedList {

	private Node head;
	private int size;
	private Node prev;
	
	public int size() {
		return this.size;
	}
	public MyLinkedList() {
		head = new Node();
		prev = new Node();
		this.size=0;
	}
	public void addToFirst(Object data) {
		Node newNode = new Node(data);
		if(head.nextNode==null) {
			head.nextNode=newNode;
			prev=newNode;
			this.size++;
		}
		else {
			Node temp = head.nextNode;
			head.nextNode=newNode;
			newNode.nextNode=temp;
			this.size++;
		}
	}
	
	public void addToLast(Object data) {
		if(this.size==0) {
			addToFirst(data);
		}
		else {
			Node newNode = new Node(data);
			prev.nextNode = newNode;
			prev = newNode;
			this.size++;
		}
	}
	public void add(int index, Object data) {
		if(index==0) {
			addToFirst(data);
			return;
		}
		Node find =getNode(index-1);
		Node newNode = new Node(data);
		newNode.nextNode = find.nextNode;
		find.nextNode = newNode;
		this.size++;
		return;
	}
	
	public Node delete(int index) {
		if(this.size()==0) {
			return null;
		}
		if(index==0) {
			Node temp = getNode(0);
			head.nextNode = getNode(1);
			this.size--;
			return temp;
		}
		else if(index>=size) {
			System.out.println("삭제불가");
			return null;
		}else {
			Node deleteNode = getNode(index);
			Node prevNode = getNode(index-1);
			
			prevNode.nextNode= deleteNode.nextNode;
			this.size--;
			return deleteNode;
		}
	}
	
	public Node getNode(int index) {
		if(index<0 || index>=size) {
			throw new IndexOutOfBoundsException("리스트범위를 벗어납니다!!!!!");
		}
		Node temp = head.nextNode;
		for(int i=0; i<index;i++) {
			temp= temp.nextNode;
		}
		return temp;
		
	}
	
	
	
	
	private class Node{
		private Object data;
		private Node nextNode;
		
		public Node() {
			this.data = null;
			nextNode=null;
		}
		public Node(Object data) {
			this.data = data;
			nextNode=null;
		}
	}
}
