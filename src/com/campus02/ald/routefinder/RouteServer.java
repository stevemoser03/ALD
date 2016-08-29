package com.campus02.ald.routefinder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class RouteServer 
{

	public static void main(String[] args) 
	{
		GraphLoader gl = new GraphLoader();
		gl.printTrees();
		try (
			ServerSocket server = new ServerSocket(1111);
			) 
		{
			while(true) 
			{
				Socket client = server.accept();
				ProcessClient pc = new ProcessClient(client,gl);
				
				Thread t = new Thread(pc);
				t.start();
			}
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
