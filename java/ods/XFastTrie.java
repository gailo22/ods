package ods;

public class XFastTrie<Node extends XFastTrie.Node<Node,T>, T> 
	extends BinaryTrie<Node, T> {

	/**
	 * The hash tables used to store prefixes
	 */
	USet<Node>[] t;
	
	public static class Node<N extends Node<N, T>, T> 
		extends	BinaryTrie.Node<N, T> {
		int prefix;
		@SuppressWarnings("unchecked")
		public boolean equals(Object u) {
			return (u instanceof Node<?, ?>)
					&& this.prefix == ((Node<N,T>)u).prefix;
		}
		public int hashCode() {
			return prefix;
		}
	}

	@SuppressWarnings("unchecked")
	public XFastTrie(Node sampleNode, Integerizer<T> it)  {
		super(sampleNode, it);
		t = (USet<Node>[])new USet[w+1];
		Node nil = (Node)new XFastTrie.Node();
		nil.prefix = Integer.MIN_VALUE;
		for (int i = 0; i <= w; i++) {
			t[i] = new LinearHashTable<Node>(nil);
		}
		t[0].add((Node)r);
	}

	@SuppressWarnings("unchecked")
	public XFastTrie(Integerizer<T> it)  {
		this((Node)new XFastTrie.Node(), it);
	}
	
	public boolean add(T x) {
		if (super.add(x)) {
			int i, c = 0, ix = it.intValue(x);
			Node u = (Node<?, T>) r.child[(ix>>>w-1) & 1];
			for (i = 1; i <= w; i++) {
				u.prefix = ix >>> w-i;
				t[i].add(u);
				c = (ix >>> w-i-1) & 1;
				u = (Node<?, T>) u.child[c];
			}
			return true;
		}
		return false;
	}
	
	public boolean remove(T x) {
		// 1 - find leaf, u, containing x
		int i = 0, c, ix = it.intValue(x);
		Node u = (Node<?, T>) r;
		for (i = 0; i < w; i++) {
			c = (ix >>> w-i-1) & 1;
			if (u.child[c] == null) return false;
			u = (Node<?, T>) u.child[c];
		}
		// 2 - remove u from linked list
		Node pred = (Node<?, T>) u.child[prev];   // predecessor
		Node succ = (Node<?, T>) u.child[next];   // successor
		pred.child[next] = succ;
		succ.child[prev] = pred;
		u.child[next] = u.child[prev] = null;
		Node w = u;
		// 3 - delete nodes on path to u
		while (w != r && w.child[left] == null && w.child[right] == null) {
			if (w == w.parent.child[left])
				w.parent.child[left] = null;
			else // u == u.parent.child[right] 
				w.parent.child[right] = null;
			t[i--].remove(w);
			w = (Node<?, T>) w.parent;
		}
		// 4 - update jump pointers
		w.jump = (w.child[left] == null) ? succ : pred;
		w = (Node<?, T>) w.parent;
		while (w != null) {
			if (w.jump == u)
				w.jump = (w.child[left] == null) ? succ : pred;
			w = (Node<?, T>) w.parent;
		}
		n--;
		return true;
	}
	
	protected Node findNode(int ix) {
		// find lowest node that is an ancestor of ix
		int l = 0, h = w+1;
		Node v, u = (Node<?, T>) r, q = (Node<?, T>) newNode();
		while (h-l > 1) {
			int i = (l+h)/2;
			q.prefix = ix >>> w-i;
			if ((v = t[i].find(q)) == null) {
				h = i;
			} else {
				u = v;
				l = i;
			}
		}
		if (l == w) return u;
		Node pred = (((ix >>> w-l-1) & 1) == 1) ? (Node<?, T>) u.jump : (Node<?, T>) u.jump.child[0];
		return (pred.child[next] == dummy) ? null : (Node<?, T>) pred.child[next];
	}
	
	public void clear() {
		super.clear();
		for (USet<Node> s : t) 
			s.clear();
	}
	
	public T find(T x) {
		int l = 0, h = w+1, ix = it.intValue(x);
		Node<?, T> v, u = (Node<?, T>) r, q = (Node<?, T>) newNode();
		while (h-l > 1) {
			int i = (l+h)/2;
			q.prefix = ix >>> w-i;
			if ((v = t[i].find(q)) == null) {
				h = i;
			} else {
				u = v;
				l = i;
			}
		}
		if (l == w) return (T) u.x;
		Node<?, T> pred = (((ix >>> w-l-1) & 1) == 1) 
			     ? (Node<?, T>) u.jump : (Node<?, T>) u.jump.child[0];
		return (pred.child[next] == dummy) 
		             ? null : (T) pred.child[next].x;
	}
	
	public static void main(String[] args) {
		class N extends XFastTrie.Node<N, Integer> {};
		class I implements Integerizer<Integer> { 
			public int intValue(Integer i) { return i; }
		}
		XFastTrie<N, Integer> t = new XFastTrie<N, Integer>(new I()); 
		BinaryTrie.easyTests(t, 20);
	}
}
