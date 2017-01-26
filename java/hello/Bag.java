package hello;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<E> implements Iterable<E> {
	
	private int N;
	private Node first;
	
	private class Node {
		private E element;
		private Node next;
	}
	
	public Bag() {
		first = null;
		N = 0;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public int size() {
		return N;
	}

	public void add(E elem) {
		Node oldFirst = first;
		first = new Node();
		first.element = elem;
		first.next = oldFirst;
		N++;
	}
	
	@Override
	public Iterator<E> iterator() {
		
		class ListIterator implements Iterator<E> {
			
			private Node current = first;

			@Override
			public boolean hasNext() {
				return current != null;
			}

			@Override
			public E next() {
				if (!hasNext()) throw new NoSuchElementException();
				E elem = current.element;
				current = current.next;
				return elem;
			}
			
		}
		
		return new ListIterator();
	}
	
	public static void main(String[] args) {
		Bag<Integer> intBags = new Bag<>();
		intBags.add(1);
		intBags.add(2);
		intBags.add(3);
		intBags.add(4);
		intBags.add(5);
		
		for (Integer i : intBags) {
			System.out.println(i);
		}
		
		Bag<String> strBags = new Bag<>();
		strBags.add("a");
		strBags.add("b");
		strBags.add("c");
		strBags.add("d");
		strBags.add("e");
		
		for (String s : strBags) {
			System.out.println(s);
		}
		
	}

}
