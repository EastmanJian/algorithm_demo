package algorithm.graph.shortestpath.weighted;

import java.util.PriorityQueue;


public class WeightedShortestPath {

    /**
     * Dijkstra's algorithm to find the shortest path from s to all vertices in the graph. It picks the unvisited vertex
     * with the lowest distance, calculates the distance through it to each unvisited neighbor, and updates the
     * neighbor's distance if smaller. Mark visited when done with neighbors.
     * @param graph
     * @param s
     */
    static public void dijkstra (Graph graph, Vertex s) {
        //define a priority queue to store the vertex being searched, sorted by distance
        PriorityQueue<Vertex> q = new PriorityQueue<>(new DistComparator());

        s.setDist(0);
        q.offer(s);

        Vertex v;
        while (!q.isEmpty()) {
            v = q.poll(); //dequeue the shortest distance Vertex
            v.setKnown(true);
            //calculate the distance through all adjacent vertices of v
            for (OutEdge e: v.getOutEdges()) {
                Vertex w = e.getAdj();
                if (!w.isKnown()) {
                    int newDist = v.getDist() + e.getWeight();
                    if (newDist < w.getDist()) {
                         w.setDist(newDist);
                         w.setPath(v);
                         q.offer(w);
                    }
                }
            }
        }
    }
}
