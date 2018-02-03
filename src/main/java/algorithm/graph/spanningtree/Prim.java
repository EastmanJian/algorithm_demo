package algorithm.graph.spanningtree;

import java.util.PriorityQueue;

/**
 * Prim's Algorithm to find the minimum spanning tree of a undirected graph
 */
public class Prim {
    /**
     * Idea of Prim's algorithm:
     * Start from vertex s, mark it as known, find the smallest weight edge to the unknown vertices. Add that vertex
     * to the tree (mark it as known) and store the weight (as Dist) and the path. And so on...
     * At any point in the algorithm, a new vertex to add to the tree by choosing the edge (u, v) such that the cost
     * of (u, v) is the smallest among all edges where u is in the tree and v is not.
     * The algorithm is essentially identical to Dijkstra’s algorithm, exception that the definition of Dist and the
     * update rule are different.
     *
     * @param graph - the graph
     * @param s - the start vertex
     */
    static public void prim (Graph graph, Vertex s) {
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
                    int newDist = e.getWeight();
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
