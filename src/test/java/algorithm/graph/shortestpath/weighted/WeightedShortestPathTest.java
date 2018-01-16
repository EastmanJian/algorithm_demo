package algorithm.graph.shortestpath.weighted;

import org.junit.Test;

import java.io.File;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class WeightedShortestPathTest {
    @Test
    public void testPriorityQueue() throws Exception {
        PriorityQueue<Vertex> q = new PriorityQueue<>(new DistComparator());
        Vertex v;
        v = new Vertex("v1"); v.setDist(10); q.offer(v);
        v = new Vertex("v2"); v.setDist(15); q.offer(v);
        v = new Vertex("v3"); v.setDist(8); q.offer(v);
        //the result is not ordered using for loop because the Iterator result of a PriorityQueue is not ordered.
        for (Vertex w: q) {
            System.out.println(w + ": dist=" + w.getDist());
        }
        //the poll result is ordered from smallest distance to biggest distance.
        do {
            v = q.poll();
            System.out.println(v + ": dist=" + v.getDist());
        } while (!q.isEmpty());
    }

    @Test
    public void testDijkstra() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/shortestpath/weighted/weightedGraph.txt";
        Graph graph = Graph.createGraphFromFile(WeightedShortestPath.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("==============Graph before weighted shortest path found==============");
        graph.printGraph();

        WeightedShortestPath.dijkstra(graph, graph.getVertex("v1"));
        System.out.println("======Graph after weighted shortest path found by Dijkstra's algorithm=====");
        graph.printGraph();

        System.out.println("===================Print the path to each vertex====================");
        for (Vertex v: graph.getVertexMap().values()) {
            graph.printPath(v);
            System.out.println();
        }
        System.out.println();
    }

}