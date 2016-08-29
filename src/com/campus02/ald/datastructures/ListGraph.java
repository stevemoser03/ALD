package com.campus02.ald.datastructures;

import java.util.ArrayList;
import java.util.List;

public class ListGraph extends Graph 
{
	private ArrayList<WeightedEdge>[] graph;	//Liste der verbunden gewichteten Knoten
	private int numVertices; 					//Anzahl der Knoten
	private boolean directed; 					//gerichtet oder nicht, werden wir nicht verwenden
									 
	@SuppressWarnings("unchecked") 				//Konstruktor
	public ListGraph(int numVertices, boolean directed) 
	{
		graph = new ArrayList[numVertices];
		
		//Legen Arrays an die bei 0 beginnen aber die IDs beginnen bei 1 wenn de ID's mit 1 beginnen w�rden, w�rden wir einen out of bounds erreichen 
		for (int i=0; i < numVertices; i++)
			graph[i] = new ArrayList<WeightedEdge>();	//i* leere ArrayList vom Typ WeigthedEdge initalisiert
		this.numVertices = numVertices;
		this.directed = directed;
	}
	
	//Getter
	public int numVertices() 
	{
		return numVertices;
	}
	
	//Findet raus ob es zwischen u(AusgangsKnoten) und v(ZielKnoten) einen Weg gibt
	public WeightedEdge findEdge(int u, int v) 
	{
		for (int i=0; i < graph[u].size(); i++) 
		{//array an der position zb.: 0 hat eine groesse von 3
			if (graph[u].get(i).vertex == v)//.vertex der andere punkt auf der kante
				return graph[u].get(i);
		}
		return null;
	}
	
	public boolean hasEdge(int u, int v) //pr�ft auf ob Kante vorhanden ist
	{
		WeightedEdge pv = findEdge(u, v);
		return pv != null;
	}
	
	public int getEdgeWeight(int u, int v) //gibt Kantengewicht zurück
	{
		WeightedEdge pv = findEdge(u, v);
		return pv.weight;
	}
	
	public int getEdgeMaut(int u, int v) //gibt Kantenmaut zurück
	{
		WeightedEdge pv = findEdge(u, v);
		return pv.mautkosten;
	}
	
	public void addEdge(int u, int v) 
	{
		addEdge(u, v, 1, false, 0); // wenn nur start und Ziel angegeben wird angenommen das es sich nicht um eine Mautstra�e handelt
	}
	
	public void addEdge(int u, int v, int weight)  
	{
		addEdge(u, v, weight, false, 0); // wenn nur start und Ziel angegeben wird angenommen das es sich nicht um eine Mautstra�e handelt
	}
	
	//neuen Weg zu einem Knoten hinzufuegen
	public void addEdge(int u, int v, int weight, boolean maut, int mautkosten) 
	{
		WeightedEdge pv = new WeightedEdge(v, weight,maut,mautkosten);
		graph[u].add(pv);
//Wir geben im File die Rueckwege an. Wenn wir das aktivieren dann darf das File keine doppelten Wege haben.
//		if (!directed) 
//		{
//			pv = new WeightedEdge(u, weight);
//			graph[v].add(pv);
//		}
	}
	
	public void removeEdge(int u, int v) 
	{
		WeightedEdge pv = findEdge(u, v);
		graph[u].remove(pv);
//Wir geben im File die Rueckwege an. Wenn wir das aktivieren dann darf das File keine doppelten Wege haben.
//		if (!directed) 
//		{
//			pv = findEdge(v, u);
//			graph[u].remove(pv);
//		}
	}

	public List<WeightedEdge> getEdges(int v) 
	{
		return graph[v];
	}
	
}