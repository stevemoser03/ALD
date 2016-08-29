package com.campus02.ald.routefinder;

import java.util.ArrayList;
import java.util.List;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;

public class Tiefensuche 
{
	
	private int start;
	private int ziel;
	private ListGraph graph; //war mal nur "g."
	private GraphLoader gl=new GraphLoader();
	
	public Tiefensuche(int start, int ziel, GraphLoader gl) 
	{
		super();
		this.start = start;
		this.ziel = ziel;
		this.graph=gl.getGraph();
	}
	
	
	public String findByTiefenSucheRekursiv() 
	{
		boolean[] visited = new boolean[graph.numVertices()];
		int[] pred = new int[graph.numVertices()];
		
		for (int i=0;i<pred.length;i++) // hier werden alle pred auf minus 1 gesetz um sp�ter besuchte von nicht besuchten zu unterschieden 
		{
			pred[i]=-1;
		}
		
		_findByTiefenSucheRekursiv(start, ziel, visited, pred);
		
		//Rekursions Methode unten aufrufen
		ArrayList<Integer> wayArray = findWay(pred, ziel, start, ziel);
		
		//Array mit IDs in Strings umwandeln und umgedreht ausgeben
		String way = "";
		for (int i = wayArray.size()-1; i >= 0; i--) 
		{
			if(i == 0) 
			{
				way += gl.translateID(wayArray.get(i));
			}
			else 
			{
				way += gl.translateID(wayArray.get(i)) + " -> ";
			}
		}
		return way;
	}
	
	private boolean _findByTiefenSucheRekursiv(int current, int nach, boolean[] visited, int[] pred) 
	{
		if (current == nach) return true;
	
		visited[current] = true;
		
		List<WeightedEdge> nachbarn = graph.getEdges(current);
		for(WeightedEdge n: nachbarn) 
		{
			if (!visited[n.vertex]) 
			{
				pred[n.vertex] = current;
				
				boolean found = _findByTiefenSucheRekursiv(n.vertex, nach, visited, pred);
				if (found) return true;
			}
		}
		return false;
	}
	
	//Gefundenen Weg in eine Array packen von Ziel zum Start
	private ArrayList<Integer> way = new ArrayList<>();
	private ArrayList<Integer> findWay(int[] pred,int current, int start, int ziel) 
	{
			if(current == ziel) 
			{
				way.add(ziel);
				findWay(pred, pred[current], start, ziel);
			}
			else if(current == start) 
			{
				way.add(start);
				return way;
			}
			else if(current != start) 
			{
				way.add(current);
				findWay(pred, pred[current], start, ziel);
			}
		return way;
	}
	/*
	public String checkGraph(){
	
	boolean result = checkGraph(0);
	
	if(result == true){
		return "Es handelt sich um einen zusammenhängenden Graphen";
	}
	else
		return "Es handelt sich um keinen zusammenhängenden Graphen";
	}
	
	public boolean checkGraph(int current){
		//Tiefensuche wird durchlaufen und Knoten auf besucht gesetzt.
		List<WeightedEdge> nachbarn = graph.getEdges(current);
		for (WeightedEdge n : nachbarn) {
			if(n.isVisited()!=true){
				n.setVisited(true);
				checkGraph(n.vertex);
			}
		}
		//Knoten werden durchgegangen und geprüft ob alle besucht wurden.
		for (int i = 0; i < graph.numVertices(); i++){
			List<WeightedEdge> check = graph.getEdges(i);
			for (WeightedEdge we : check) {
				if(we.isVisited() == false){
					return false;
				}
			}
		}
		
		
		return true;	
	}
	*/
	
	
	
	
	
	
}
