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
        System.out.println("===================Graph after unweighted shortest path found (start from v3)====================");
        graph.printGraph();

        System.out.println("===================Print the shortest path from v3 to v5 and v7====================");
        graph.printPath(graph.getVertex("v5"));
        System.out.println();
        graph.printPath(graph.getVertex("v7"));
        System.out.println();
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

        System.out.println("===================Print the path from v9 to v1====================");
        graph.printPath(graph.getVertex("v1"));
        System.out.println();
    }

}