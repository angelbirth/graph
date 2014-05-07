package org.ric.graph;

public class Graph {
	private static final int MAX_VERTEX = 10;
	private Vertex[] vertices;
	private int[][] adjacencyMatrix;
	private int verticesCount = 0;

	public Graph() {
		vertices = new Vertex[MAX_VERTEX];
		verticesCount = 0;
		adjacencyMatrix = new int[MAX_VERTEX][MAX_VERTEX];
	}

	public void addVertex(char c) {
		if (verticesCount < MAX_VERTEX) {
			Vertex temp = new Vertex(c);
			vertices[verticesCount++] = temp;
		} else {
			throw new IllegalStateException("Exceeds capacity");
		}
	}

	public void addEdge(int from, int to, int weight) {
		adjacencyMatrix[from][to] = weight;
		adjacencyMatrix[to][from] = weight;
	}

	public void addEdge(char from, char to, int weight) {
		int f = indexOf(from);
		int t = indexOf(to);
		addEdge(f, t, weight);
	}

	private int indexOf(char label) {
		for (int i = 0; i < verticesCount; i++) {
			if (vertices[i].label == label)
				return i;
		}
		return -1;
	}

	public static class Vertex {
		public char label;
		private boolean visited = false;

		public Vertex(char c) {
			label = c;
		}
	}
}
