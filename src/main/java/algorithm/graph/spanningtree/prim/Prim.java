package algorithm.graph.spanningtree.prim;

import java.util.PriorityQueue;

/**
 * Prim's Algorithm to find the minimum spanning tree of a undirected graph
 */
public class Prim {
    /**
     * Idea of Prim's algorithm:
     * Start from vertex s, mark it as known, find all its adjacent vertices, update the edge weight (as Dist) and the
     * path, find the smallest weight edge and the related adjacent vertex, mark as known, add that vertex to the tree,
     * find that vertex's adjacent vertices from the unknown vertices, update the weight (as Dist) and path if the
     * weight is smaller than the original Dist, also update the path. And so on...
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
            v = q.poll(); //dequeue the Vertex who has the smallest Dist (i.e. the weight of the edge to this vertex)
            v.setKnown(true);
            //calculate the new cost through all adjacent vertices of v
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
