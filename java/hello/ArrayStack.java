package hello;

public class ArrayStack<E> implements Stack<E>, ArrayCollection<E> {

	private E[] data;
	private int top = -1;
	private static final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayStack() {
		data = (E[]) new Object[DEFAULT_CAPACITY];
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
