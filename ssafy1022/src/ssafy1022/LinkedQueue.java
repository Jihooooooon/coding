package ssafy1022;

public class LinkedQueue {
	private MyLinkedList data;
	
	public LinkedQueue() {
		data = new MyLinkedList();
	}
	public boolean isEmpty() {
		return data.size()==0?true:false;
	}
	public void enQueue(Object data) {
		this.data.addToLast(data);
	}
	public Object deQueue() {
		if(data.size()==0) {
			return null;
		}
		else {
			
			return data.delete(0);
		}
	}
	public Object Qpeek() {
		if(data.size()==0) {
			return null;
		}
		else {
			return data.getNode(0);
		}
	}
	
}
