package hello;

public interface PiorityQueue<E> {
	
	void add(E item);
	boolean isEmpty();
	E peek();
	E remove();
	int size();

}
