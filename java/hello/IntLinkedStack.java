package hello;

public class IntLinkedStack implements IntStack {
	
	private Node top;
	
	private class Node {
		private int data;
		private Node next;
		
		private Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int peek() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int pop() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void push(int item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
