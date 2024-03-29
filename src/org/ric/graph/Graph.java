package org.ric.graph;

import java.util.Stack;

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
		if (from >= verticesCount || to >= verticesCount)
			throw new IllegalArgumentException("wrong index");
		adjacencyMatrix[from][to] = weight;
		adjacencyMatrix[to][from] = weight;
	}

	public void addEdge(char from, char to, int weight) {
		int f = indexOf(from);
		int t = indexOf(to);
		try {
			addEdge(f, t, weight);
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException("vertex not found", e);
		}
	}

	private int indexOf(char label) {
		for (int i = 0; i < verticesCount; i++) {
			if (vertices[i].label == label)
				return i;
		}
		return -1;
	}

	public void show() {
		for (int i = 0; i < verticesCount; i++) {
			for (int j = 0; j < verticesCount; j++) {
				if (i == j || adjacencyMatrix[i][j] == 0)
					continue;
				System.out.printf("%c terhubung dengan %c dengan bobot %d%n",
						vertices[i].label, vertices[j].label,
						adjacencyMatrix[i][j]);
			}
		}
	}

	public void dfs() {
		int seed = 0;
		Stack<Integer> s = new Stack<>();
		s.push(seed);
		while (!s.isEmpty()) {
			int temp = s.pop();
			if (!vertices[temp].visited) {
				System.out.printf("%c ", vertices[temp].label);
				vertices[temp].visited = true;
			}
			for (int i = verticesCount - 1; i >= 0; i--) {
				if (adjacencyMatrix[temp][i] != 0 && !vertices[i].visited)
					s.push(i);
			}
		}
	}

	public static class Vertex {
		public char label;
		private boolean visited = false;

		public Vertex(char c) {
			label = c;
		}
	}

}
