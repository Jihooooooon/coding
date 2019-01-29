package com.ssafy.algo;

public class LinkedList {

	private Node head;
	private Node tail;
	private int size;

	public LinkedList() {
		this.size = 0;
		this.head = new Node(null);
		this.tail = new Node(null);
	}

	public int size() {
		return this.size;
	}

	public void addFirst(Object input) {
		Node newNode = new Node(input);
		newNode.next = head.next;
		head.next = newNode;
		this.size++;
		if (this.size == 1) {
			tail = head.next;
		}
	}

	public void addLast(Object input) {
		if (this.size == 0) {
			addFirst(input);
		} else {
			Node newNode = new Node(input);
			tail.next = newNode;
			tail = newNode;
			this.size++;
		}
	}

	public Node getNode(int index) {
		Node temp = head.next;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public Node remove(int index) {
		Node temp1 = head;
		Node temp2 = temp1.next;
		for (int i = 0; i < index; i++) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		temp1.next = temp2.next;
		this.size--;

		return temp2;
	}

	public class Node {
		private Object data;
		private Node next;

		public Node(Object input) {
			this.data = input;
			this.next = null;
		}

		public String toString() {
			return String.valueOf(this.data);
		}
	}

}
