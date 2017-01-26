package hello;

import java.util.Iterator;

public class ArrayList<E> implements List<E>, ArrayCollection<E> {

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
		return new ArrayListIterator();
	}
	
	private class ArrayListIterator implements Iterator<E> {

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
