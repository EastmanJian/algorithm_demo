package algorithm.graph.shortestpath.unweighted;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class UnweightedShortestPathTest {
    @Test
    public void testFindPath() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/shortestpath/unweighted/unweightedGraph.txt";
        Graph graph = Graph.createGraphFromFile(UnweightedShortestPath.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("===================Graph before unweighted shortest path found====================");
        graph.printGraph();

        UnweightedShortestPath.findPath(graph, graph.getVertex("v3"));
        System.out.println("===================Graph after unweighted shortest path found====================");
        graph.printGraph();
    }


    @Test
    public void testFindPath2() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/shortestpath/unweighted/unweightedGraph2.txt";
        Graph graph = Graph.createGraphFromFile(UnweightedShortestPath.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("===================Graph before unweighted shortest path found====================");
        graph.printGraph();

        UnweightedShortestPath.findPath(graph, graph.getVertex("v9"));
        System.out.println("===================Graph after unweighted shortest path found====================");
        graph.printGraph();
    }

}