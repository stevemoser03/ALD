package com.campus02.ald.routefinder;

import java.util.ArrayList;
import java.util.List;

import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.VertexHeap;
import com.campus02.ald.datastructures.WeightedEdge;

public class Dijkstra 
{

	//orientierung an Aufbau Tiefensuche
	private int start;
	private int ziel;
	private ListGraph graph; 
	private GraphLoader gl = new GraphLoader();
	private boolean maut;
	
	public Dijkstra(int start, int ziel, GraphLoader gl, boolean maut) 
	{
		super();
		this.start = start;
		this.ziel = ziel;
		this.graph = gl.getGraph();
		this.maut = maut;
	}


	public String findByDijkstra()
	{
		
		int[] pred = new int[graph.numVertices()];
		int[] dist = new int[graph.numVertices()];
		boolean[] visited = new boolean[graph.numVertices()];
		
		VertexHeap heap = new VertexHeap(graph.numVertices()); //eigen Heapklasse fuer Prioritaetsvergabe nach Gewichtung
		for(int i=0; i<dist.length; i++)
		{
			dist[i] = 99999;
			heap.insert(new WeightedEdge(i, 999999, false, i));
			pred[i] = 1;
		}
		
		dist[start] = 0;
        heap.setPriority(start, 0);
        
        while(!heap.isEmpty()) 
        {
            WeightedEdge cur = heap.remove(); // Setzt den min heap wert auf cur 
            
            if (cur.vertex == ziel) break;
            
            List<WeightedEdge> nachbarn = graph.getEdges(cur.vertex);
            
            for(WeightedEdge nachbar: nachbarn) 
            {
            	if ((nachbar.maut == true)&& !(maut == true))
            	{
            		continue;//wenn der nachbar eine maut hat und maut auf true ist dann geh weiter
            	}
                int distBisHier = dist[cur.vertex]; //Alt: cur.weight
                int distZumNachbar = nachbar.weight;
                
                int distInsg = distBisHier + distZumNachbar;
                
                if (distInsg < dist[nachbar.vertex] ) 
                {
                    dist[nachbar.vertex] = distInsg;
                    heap.setPriority(nachbar.vertex, distInsg);
                    
                    pred[nachbar.vertex] = cur.vertex;
                }
            }
        }
// 		  pred ausgeben
//        String way = "";
//        for(int i=0; i<pred.length; i++) 
//        {
//            way += i + " ueber " + pred[i] + "\n";
//        }
        
      //Rekursions Methode unten aufrufen
      	ArrayList<Integer> wayArray = findWay(pred, ziel, start, ziel);
      	
      //Array mit IDs in Strings umwandeln und umgedreht ausgeben
      	String way = "";
      	int sum=0;
      	int maut=0;
      	for (int i = wayArray.size()-1; i >= 0; i--) 
      	{
      		if(i == 0) 
      		{
      			way += gl.translateID(wayArray.get(i)) + " : Gesamt(" + sum + ") Maut(" + maut + ")";
      		}
      		else 
      		{
      			way += gl.translateID(wayArray.get(i)) + " -("+graph.getEdgeWeight(wayArray.get(i), wayArray.get(i-1)) + ")-> ";
      			sum += graph.getEdgeWeight(wayArray.get(i), wayArray.get(i-1));
      			maut += graph.getEdgeMaut(wayArray.get(i), wayArray.get(i-1));//zaehlung maut
      		}
      		
      	}
        return way;   
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
		
}


