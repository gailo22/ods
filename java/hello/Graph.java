package hello;

import java.util.List;

public interface Graph {
	
	int nVertices();
	void addEdge(int i, int j);
	void removeEdge(int i, int j);
	boolean hasEdge(int i, int j);
	List<Integer> outEdges(int i);
	List<Integer> inEdges(int i);
	int outDegree(int i);
	int inDegree(int i);

}
