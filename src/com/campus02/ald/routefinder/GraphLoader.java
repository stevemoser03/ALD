package com.campus02.ald.routefinder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.campus02.ald.datastructures.AvlTree;
import com.campus02.ald.datastructures.BaseTree;
import com.campus02.ald.datastructures.ListGraph;
import com.campus02.ald.datastructures.WeightedEdge;
import com.campus02.ald.datastructures.Node;


@SuppressWarnings("unused")
public class GraphLoader 
{
	
	private File file;
	private ArrayList<String> list = new ArrayList<>();
	private ListGraph graph;

	public ListGraph getGraph() 
	{
		return graph;
	}

	public GraphLoader() 
	{
		File file = new File("Citylist.txt");
		graph = new ListGraph(getGraphSize(file), false);
		buildTree(file);
		loadGraph(file);
	}
	
	//Build graph--------------------------------------------------------------------------------

	public void loadGraph(File file) 
	{
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) 
		{
			//ListGraph graph = new ListGraph(getGraphSize(file), false); //getGraphSize gibt die Anzhal der Knoten an
			String line;
			while((line=br.readLine()) != null) 
			{
				String[] array = line.split(";");
				int idStart = ctree.find(array[0]).getKey(); //findet Start Knoten ID
				int idZiel = ctree.find(array[1]).getKey(); //findet Ziel Knoten ID
				if (array.length == 3)
				{
				graph.addEdge(idStart, idZiel, Integer.parseInt(array[2])); //fuegen Verbindung ein in Graph
				}
				if (array.length == 5)
				{
				graph.addEdge(idStart, idZiel, Integer.parseInt(array[2]),Boolean.valueOf(array[3]),Integer.parseInt(array[4])); //fuegen Verbindung ein in Graph
				}
				if (array.length == 4)
				{
				graph.addEdge(idStart, idZiel, Integer.parseInt(array[2]),Boolean.valueOf(array[3]),1); //fuegen Verbindung ein in Graph
				}
				
				}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
	
	public int getGraphSize(File file) 
	{
		try (
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			) 
		{
				String line;
				while((line=br.readLine()) != null) 
				{
					String[] array = line.split(";");
					if(list.contains(array[0])==false) 
					{
						list.add(array[0]);
					}
				}	
			} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return list.size();
	}
	
	//Build tree--------------------------------------------------------------------------------
	
	private AvlTree<Integer,String> ctree = new AvlTree<Integer,String>() //Wenn BaseTree Verwendet dann BaseTree statt AVL Tree 
	{
		@Override
		protected int compareKey(Integer a, Integer b) 
		{
			if (a<b)
				return -1;
			if (a>b)
				return 1;
			else 
				return 0;
		}
		@Override
		protected int compareValue(String a, String b) 
		{
			return a.compareTo(b);
		}
	};
			
	private AvlTree<String, Integer> stree = new AvlTree<String, Integer>() 
	{
		@Override
		protected int compareKey(String a, String b) 
		{
			return a.compareTo(b);
		}
		@Override
		protected int compareValue(Integer a, Integer b) 
		{
			if (a<b)
				return -1;
			if (a>b)
				return 1;
			else 
				return 0;
		}
	};
	
	private void buildTree(File file) 
	{
		try (BufferedReader br = new BufferedReader(new FileReader(file));)
		{
			
			String line;
			Integer counter = -1;// ist dafür verantwortlich das die ID's mit 0 starten
			while ((line=br.readLine())!=null)
			{
				String[]array=line.split(";");
				String node = array[0];
				if (ctree.find(node) == null)
				{
					counter++; //weil bereits hier um eines erhöht wird
				}
				ctree.insert(counter,node); //Bei BaseTree add statt insert
				stree.insert(node, counter);//Bei BaseTree add statt insert
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
					
	}
	
	public void printTrees()
	{
		ctree.printTree();
		stree.printTree();
	}
	
	public int checkTree(String start, String target)
	{
		if (((ctree.find(start)) != null && (ctree.find(target)) != null))
			return 1;
		else 
			return 0;	
	}
	
	public int translateString(String ort)
	{
		return ctree.find(ort).getKey();
	}
	
	public String translateID(int id)
	{
		return stree.find(id).getKey();
	}

}
