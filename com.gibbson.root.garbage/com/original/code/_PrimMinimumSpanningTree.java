package com.original.code;
import java.util.List;

public class _PrimMinimumSpanningTree {
	
	public int[] findMST(_Graph g) {
		int numv = g.numVertices();
		int[] pred = new int[numv];
		int[] weight = new int[numv];
		for (int i=0; i < numv; i++) {
			weight[i] = 9999;		// Gewichte im Graph dürfen nie größer sein
			pred[i] = -1;
		}
		weight[0] = 0;		// Start bei beliebigem Knoten
		
		_VertexHeap vheap = new _VertexHeap(g.numVertices());
		for (int i=0; i < g.numVertices(); i++)
			vheap.insert(new _WeightedEdge(i, weight[i]));

		while (!vheap.isEmpty()) {
			int u = vheap.remove().vertex;
			List<_WeightedEdge> le = g.getEdges(u);
			for (int i=0; i < le.size(); i++) {
				_WeightedEdge we = le.get(i);
				int v = we.vertex;
				if (vheap.contains(we)) {
					if (we.weight < weight[v]) {
						weight[v] = we.weight;
						pred[v] = u;
						vheap.setPriority(v, we.weight);
					}
				}
			}
		}
		return pred;
	}
}
