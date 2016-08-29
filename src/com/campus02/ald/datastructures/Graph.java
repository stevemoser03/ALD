package com.campus02.ald.datastructures;
import java.util.List;

/*
 * Basis der Datenstrucktur Graph, wird von anderen Klassen extendet
 */

public abstract class Graph 
{
	public abstract int numVertices();
	public abstract boolean hasEdge(int u, int v);
	public abstract WeightedEdge findEdge(int u, int v);
	public abstract void addEdge(int u, int v);
	public abstract void addEdge(int u, int v, int weight,boolean maut, int mautkosten);
	public abstract void removeEdge(int u, int v);
	public abstract List<WeightedEdge> getEdges(int v);
}
