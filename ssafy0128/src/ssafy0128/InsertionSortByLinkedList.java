package ssafy0128;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;



public class InsertionSortByLinkedList {
	
	
	public static void insertionSort(DoubleLinkedList temp, int inputSize) {
		for (int i = 1; i < inputSize; i++) {
			int pivot =(int)temp.get(i);
			temp.remove(i);
			int j=i-1;
			for (; j >= 0; j--) {
				
			if((int)temp.get(j)<=pivot) {
					break;
				}
			}
			temp.add(j+1, pivot);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp[]= {2,269,10,30,2,16,8,31,22};
		DoubleLinkedList list = new DoubleLinkedList();
		for(int i=0; i<temp.length; i++) {
			list.addLast(temp[i]);
		}
		insertionSort(list, 9);
		for(int i=0; i<list.size; i++) {
			System.out.print(list.get(i)+" ");
		}
	}
	
	

	public static class DoubleLinkedList {
		private Node header;
		private int size;

		public DoubleLinkedList() {
			header = new Node(null);
			size = 0;
		}

		public Object get(int index) {
			return getNode(index).data;
		}

		public void addFirst(Object data) {

			Node newNode = new Node(data);
			newNode.nextNode = header.nextNode;

			if (header.nextNode != null) {
				header.nextNode.previousNode = newNode;

			} else {

				header.previousNode = newNode;

			}

			header.nextNode = newNode;
			size++;
		}

		public void addLast(Object data) {
			add(size, data);
		}

		public void add(int index, Object data) {

			if (index == 0) {

				addFirst(data);
				return;
			}
			Node previous = getNode(index - 1);
			Node next = previous.nextNode;
			Node newNode = new Node(data);
			previous.nextNode = newNode;
			newNode.previousNode = previous;
			newNode.nextNode = next;

			if (newNode.nextNode != null) {

				next.previousNode = newNode;

			} else {

				header.previousNode = newNode;
			}

			size++;
		}

		public Object removeFirst() {
			Node firstNode = getNode(0);
			header.nextNode = firstNode.nextNode;
			if (header.nextNode != null) {

				firstNode.nextNode.previousNode = null;

			} else {
				header.previousNode = null;

			}

			size--;
			return firstNode.data;
		}
		public Object removeLast(){
	        return remove(size-1);
	    }

		private Node getNode(int index) {

			if (index < 0 || index > size) {
				throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
			}

			Node node = header;

			if (index < (size / 2)) {

				for (int i = 0; i <= index; i++) {
					node = node.nextNode;
				}

			} else {

				for (int i = size; i > index; i--) {
					node = node.previousNode;

				}
			}

			return node;
		}

		public Object remove(int index) {

			if (index < 0 || index >= size) {
				throw new IndexOutOfBoundsException("Index : " + index + ", Size : " + size);
			} else if (index == 0) {
				return removeFirst();
			}

			Node removeNode = getNode(index);

			Node previous = removeNode.previousNode;

			Node next = removeNode.nextNode;
			previous.nextNode = next;

			if (next != null) {

				next.previousNode = previous;

			} else {
				header.previousNode = previous;

			}

			size--;

			return removeNode.data;
		}

		private class Node {

			private Object data;
			private Node previousNode;
			private Node nextNode;

			Node(Object data) {

				this.data = data;
				this.previousNode = null;
				this.nextNode = null;

			}
		}

	}


}
