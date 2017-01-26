package hello;

public class LinkedStack<E> implements Stack<E>, LinkedCollection<E> {
	
	private Node<E> top;
	
	private static class Node<T> {
		private T data;
		private Node<T> next;
		
		private Node(T data, Node<T> next) {
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
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void push(E item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

}
