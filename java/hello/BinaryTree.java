package hello;

public abstract class BinaryTree<E> {
	
	protected Node<E> root;
	
	protected static class Node<T> {
		protected T data;
		protected Node<T> left, right, parent;
		
		protected Node(T data, Node<T> parent) {
			this.data = data;
			this.parent = parent;
		}
		
		public String toString() {
			return data.toString();
		}
	}

	String breadthFirst() {
		return breadthFirst(root);
	}
	String inorder() {
		return inorder(root);
	}
	String preorder() {
		return preorder(root);
	}
	
	String postorder() {
		return postorder(root);
	}
	
	private String breadthFirst(Node<E> n) {
		// TODO Auto-generated method stub
		return null;
	}
	private String inorder(Node<E> n) {
		if (n == null) return "";
		return (preorder(n.left) + " " + n + " " + preorder(n.right)).trim();
	}
	private String preorder(Node<E> n) {
		if (n == null) return "";
		return (n + " " + preorder(n.left) + " " + preorder(n.right)).trim();
	}
	private String postorder(Node<E> n) {
		if (n == null) return "";
		return (preorder(n.left) + " " + preorder(n.right) + " " + n).trim();
	}
	
}
