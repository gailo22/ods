package hello;

public class FixedLengthQueue<E> extends ArrayQueue<E> {

	private int drops;
	
	public FixedLengthQueue(int capacity) {
		super(capacity);
	}
	
	@Override
	public void enqueue(E item) {
		if (size == capacity) {
			drops++;
		} else {
			super.enqueue(item);
		}
	}
	
	public int drops() {
		return drops;
	}
}
