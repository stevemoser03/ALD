package com.campus02.ald.routefinder;

public class Demo {

	public static void main(String[] args) {
		
		int start=1;
		int ziel =0;
		
		GraphLoader gl = new GraphLoader();

		Tiefensuche t = new Tiefensuche(start, ziel, gl);
		System.out.println(t.findByTiefenSucheRekursiv());

		System.out.println();
		
		Breitensuche b = new Breitensuche(start, ziel, gl);
		System.out.println(b.findByBreitenSuche());
		
		System.out.println();
		
		Dijkstra d = new Dijkstra(start, ziel, gl, true);
		System.out.println(d.findByDijkstra());
		
	}	

}
