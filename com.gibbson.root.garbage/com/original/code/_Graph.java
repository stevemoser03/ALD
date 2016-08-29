package com.original.code;
import java.util.List;


public abstract class _Graph {
	public abstract int numVertices();
	public abstract boolean hasEdge(int u, int v);
	public abstract int getEdgeWeight(int u, int v);
	public abstract void addEdge(int u, int v);
	public abstract void addEdge(int u, int v, int weight);
	public abstract void removeEdge(int u, int v);
	public abstract List<_WeightedEdge> getEdges(int v);
}
