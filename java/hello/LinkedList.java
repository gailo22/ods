package hello;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<E> implements List<E>, LinkedCollection<E> {
	
	private Node<E> head;
	
	class Node<T> {
		T data;
		Node<T> next;
	}

	@Override
	public void add(E item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(int index, E item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(E item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E removeAt(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E item) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator();
	}
	
	private class LinkedListIterator implements Iterator<E> {

		private Node<E> next = head.next; // skip dummy
		
		@Override
		public boolean hasNext() {
			return next != null;
		}

		@Override
		public E next() {
			if (!hasNext()) throw new NoSuchElementException();
			E result = next.data;
			next = next.next;
			return result;
		}
		
	}

}
