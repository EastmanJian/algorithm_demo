package algorithm.graph.topsort;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Topological Sort Algorithm
 */
public class TopSort {
    public static void main(String[] args) throws CycleFoundException {
        TopSort topSort = new TopSort();

        //import the graph from file
        String graphFileName = "algorithm/graph/topsort/topSortGraph.txt";
        Graph graph = Graph.createGraphFromFile(TopSort.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("===================Graph before topological sort====================");
        graph.printGraph();

        //sort
        topSort(graph);
        System.out.println("===================Graph after topological sort====================");
        graph.printGraph();
    }

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
        Set<String> vertexMapKeys = vertexMap.keySet();
        Vertex v;
        for (String vertexName: vertexMapKeys) {
            v = vertexMap.get(vertexName);
            if (v.getIndegree()==0) q.offer(v);
        }

        /* From the zero indegree vertex, decrease the indegree of its adjacent vertices.
         * If the adjacent vertex's indegree is dropped to zero, add it into the queue.
         * Set the sort number for each zero indegree vertex.
         */
        v = q.poll();
        while( v != null )
        {
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
        if( counter != vertexMapKeys.size() )
            throw new CycleFoundException( );

    }
}
