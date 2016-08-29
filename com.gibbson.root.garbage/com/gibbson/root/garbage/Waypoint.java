package com.gibbson.root.garbage;


public class Waypoint {
	
	
	private String stadte;
	private String neighbor;
	private int distance;
	
	public Waypoint(String stadte, String neighbor, int distance) {
		super();
		this.stadte = stadte;
		this.neighbor = neighbor;
		this.distance = distance;
	}

	public String getStadte() {
		return stadte;
	}

	public String getNeighbor() {
		return neighbor;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return "Waypoint [stadte=" + stadte + ", neighbor=" + neighbor + ", distance=" + distance + "]";
	}
	

}
