package com.original.code;
import java.util.ArrayList;
import java.util.List;


public class _ListGraph extends _Graph {

	private ArrayList<_WeightedEdge>[] graph;
	private int numVertices;
	private boolean directed;
	
	@SuppressWarnings("unchecked")
	public _ListGraph(int numVertices, boolean directed) {
		graph = new ArrayList[numVertices];
		for (int i=0; i < numVertices; i++)
			graph[i] = new ArrayList<_WeightedEdge>();
		this.numVertices = numVertices;
		this.directed = directed;
	}
	
	public int numVertices() {
		return numVertices;
	}

	private _WeightedEdge findEdge(int u, int v) {
		for (int i=0; i < graph[u].size(); i++) {
			if (graph[u].get(i).vertex == v)
				return graph[u].get(i);
		}
		return null;
	}
	
	public boolean hasEdge(int u, int v) {
		_WeightedEdge pv = findEdge(u, v);
		return pv != null;
	}
	
	public int getEdgeWeight(int u, int v) {
		_WeightedEdge pv = findEdge(u, v);
		return pv.weight;
	}

	public void addEdge(int u, int v) {
		addEdge(u, v, 1);
	}
	
	public void addEdge(int u, int v, int weight) {
		_WeightedEdge pv = new _WeightedEdge(v, weight);
		graph[u].add(pv);
		if (!directed) {
			pv = new _WeightedEdge(u, weight);
			graph[v].add(pv);
		}
	}
	


	public void removeEdge(int u, int v) {
		_WeightedEdge pv = findEdge(u, v);
		graph[u].remove(pv);
		if (!directed) {
			pv = findEdge(v, u);
			graph[u].remove(pv);
		}
	}

	public List<_WeightedEdge> getEdges(int v) {
		return graph[v];
	}
}
