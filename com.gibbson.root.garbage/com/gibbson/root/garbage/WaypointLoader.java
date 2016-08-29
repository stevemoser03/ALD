package com.gibbson.root.garbage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WaypointLoader {

	public ArrayList<Waypoint> load(String path)
	{
		ArrayList<Waypoint>list=new ArrayList<>();
		
		File file =new File(path);
		
		try(FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr)) 
		{
			String line;
			while ((line=br.readLine())!=null)
			{
				String[]array=line.split(";");
				list.add(new Waypoint(array[0], array[1], Integer.parseInt(array[2])));
			}
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
		
	}
}
