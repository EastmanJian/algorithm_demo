package algorithm.graph.shortestpath.unweighted;

import java.util.concurrent.LinkedBlockingQueue;

import static algorithm.graph.shortestpath.unweighted.Graph.INFINITY;

public class UnweightedShortestPath {
    /**
     * Find the shortest path from a start vertex to all vertices in the graph.
     * Using a breadth-first algorithm, from the start vertex s, calculate its adjacency distance and path,
     * then put the adjacency into a queue. Remove the handled vertex from the queue.
     * @param graph - the target graph
     * @param s - the start vertex
     */
    static void findPath(Graph graph, Vertex s) {
        //define a queue to store the vertex being searched
        LinkedBlockingQueue<Vertex> q = new LinkedBlockingQueue<>( );

        //the shortest path from s to s is zero.
        s.setDist(0);
        q.offer(s);

        //handle each item in the queue
        Vertex v;
        while (!q.isEmpty()) {
            v = q.poll();
            //set the distance and path of each adjacent vertex, and put it in the queue
            for (Vertex w: v.getAdj()) {
                if (w.getDist() == INFINITY) {
                    w.setDist(v.getDist() + 1);
                    w.setPath(v);
                    q.offer(w);
                }
            }
        }
    }
}


