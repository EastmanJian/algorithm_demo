package algorithm.graph.topsort;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Topological Sort Algorithm
 */
public class TopSort {

    /**
     * Do topological sort for the graph, and store the sorting result for each vertex in Vertex.sortNum.
     * @param graph - the graph to be sorted
     * @throws CycleFoundException - a topological ordering is not possible if the graph has a cycle
     */
    static void topSort(Graph graph) throws CycleFoundException {
        //define a queue to store the vertex whose indegree is zero
        LinkedBlockingQueue<Vertex> q = new LinkedBlockingQueue<>( );
        int counter = 0;

        //put initial vertices into the queue
        Map<String, Vertex> vertexMap = graph.getVertexMap();
        for (Vertex v: vertexMap.values()) {
            if (v.getIndegree()==0) q.offer(v);
        }

        /* From the zero indegree vertex, decrease the indegree of its adjacent vertices.
         * If the adjacent vertex's indegree is dropped to zero, add it into the queue.
         * Set the sort number for each zero indegree vertex.
         */
        Vertex v = q.poll();
        while( v != null ) {
            v.setSortNum(++counter); // Assign the sort number
            for (Vertex w: v.getAdj()) {
                w.decreaseIndegree();
                if (w.getIndegree() == 0) {
                    q.offer(w);
                }
            }
            v = q.poll();
        }

        //in case there are cycle path in the graph, the counter will not be equal to the number of vertices.
        if( counter != vertexMap.size() )
            throw new CycleFoundException( );

    }
}
