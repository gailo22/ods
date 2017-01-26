package hello;

public class IntArrayStack implements IntStack {

	private int top = -1;
	private int[] data;
	private static final int DEFAULT_CAPACITY = 10;
	
	public IntArrayStack() {
		data = new int[DEFAULT_CAPACITY];
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
