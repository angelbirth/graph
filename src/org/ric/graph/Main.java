package org.ric.graph;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph();
		char[] edges = { 'a', 'b', 'c', 'e', 'f' };
		for (char c : edges) {
			g.addVertex(c);
		}
		g.addEdge('a', 'b', 4);
		g.addEdge('a', 'f', 5);
		g.addEdge('c', 'b', 5);
		g.addEdge('e', 'b', 4);
		g.addEdge('f', 'b', 2);
		g.addEdge('c', 'e', 2);
		g.addEdge('e', 'f', 10);
		g.addEdge('c', 'f', 3);
		g.show();
	}

}
