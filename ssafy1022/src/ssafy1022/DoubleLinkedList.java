package ssafy1022;

public class DoubleLinkedList {
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
