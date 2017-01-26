package hello;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {

	void add(E item) {
		// TODO: implement me
	}
	
	boolean contains(E item) {
		return findNode(item, root) != null;
	}
	
	private Node<E> findNode(E item, Node<E> n) {
		if (item == null || n == null) return null;
		int result = item.compareTo(n.data);
		if (result == 0) {
			return n;
		} else if (result < 0) {
			return findNode(item, n.left);
		} else {
			return findNode(item, n.right);
		}
	}
	
	E min() {
		// TODO: implement me
		return null;
	}
	
	E max() {
		// TODO: implement me
		return null;
	}
	
	E pred(E item) {
		Node<E> n = findNode(item, root);
		if (n == null) return null;
		Node<E> pred = predNode(n);
		return (pred != null) ? pred.data : null;
	}
	
	private Node<E> predNode(Node<E> n) {
		if (n.left != null) return maxNode(n.left);
		Node<E> p = n.parent;
		while (p != null && p.right != null) {
			n = p;
			p = n.parent;
		}
		return p;
	}
	
	private Node<E> maxNode(Node<E> left) {
		// TODO Auto-generated method stub
		return null;
	}
	
	boolean remove(E item) {
		// TODO: implement me
		return false;
	}
	
	E succ(E item) {
		// TODO: implement me
		return null;
	}
	
}
