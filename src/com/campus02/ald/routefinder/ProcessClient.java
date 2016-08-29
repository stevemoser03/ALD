package com.campus02.ald.routefinder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class ProcessClient implements Runnable 
{

	private Socket client;
	private GraphLoader gl;
	public boolean maut=true;
	
	public ProcessClient(Socket client,GraphLoader gl) 
	{
		super();
		this.client = client;
		this.gl = gl;
	}

	@Override
	public void run() 
	{
		try (
			InputStreamReader isr = new InputStreamReader(client.getInputStream());
			BufferedReader br = new BufferedReader(isr);
			OutputStreamWriter osw = new OutputStreamWriter(client.getOutputStream());
			PrintWriter pw = new PrintWriter(osw);
			) 
		{
			sendGreeting(pw);
			String line;
			while((line=br.readLine()) != null) 
			{
				String[] array = line.split(" ");
				/*
				if (array.length == 1 && array[0].equalsIgnoreCase("4"))
				{
					Tiefensuche t = new Tiefensuche(0, 1, gl);
					pw.println(t.checkGraph());
					pw.flush();
				}			
				*/
				if(array.length == 3)
				{	
					if ((checkNode(array[0],array[1])) != 0)
					{
						int start = gl.translateString(array[0]);
						int ziel = gl.translateString(array[1]);			
						
						if(Integer.parseInt(array[2]) == 1) //array[2] Possition der Suchmethoden auswahl
						{
							Tiefensuche t = new Tiefensuche(start, ziel, gl);
							String weg = t.findByTiefenSucheRekursiv();
							pw.println(weg);
							pw.flush();
						}
						else if(Integer.parseInt(array[2]) == 2) 
						{
							Breitensuche b = new Breitensuche(start, ziel, gl);
							String weg = b.findByBreitenSuche();
							pw.println(weg);
							pw.flush();
						}
						else if(Integer.parseInt(array[2]) == 3) 
						{
							Dijkstra d = new Dijkstra(start, ziel, gl, true); //Maut boolena wird manuell gesetzt derzeit
							String weg = d.findByDijkstra();
							pw.println(weg);
							pw.flush();
						}
						/*
						else if(Integer.parseInt(array[2]) == 4)
						{
							Tiefensuche t = new Tiefensuche(0, 1, gl);
							pw.println(t.checkGraph());
							pw.flush();
						}*/
						else 
						{
							pw.println("Kein gueltiger Algorythmus ausgewaehlt! Bitte neu waehlen!");
						}
					}
					else 
					{
						pw.println("Ziel Nicht vorhanden, bitte neues Ziel waehlen.");
					}
				}
				else 
				{
					pw.println("Ungueltiges Befehlsformat!");
				}
				pw.flush();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	private int checkNode(String start, String target) 
	{
		return gl.checkTree(start, target);
	}

	private void sendGreeting(PrintWriter pw) 
	{
		pw.println("Hallo");
		pw.println("Bitte geben Sie einen Start- und Zielpunt ein (z.B. Graz Wien) und");
		pw.println("welchen Suchalgorithmus Sie verwenden wollen:");
		pw.println("1 = Tiefensuche");
		pw.println("2 = Breitensuche");
		pw.println("3 = Dijkstra Algorithmus");
		//pw.println("4 = Checken ob Graph Zusammenhängend");
		pw.flush();
	}
	
}
