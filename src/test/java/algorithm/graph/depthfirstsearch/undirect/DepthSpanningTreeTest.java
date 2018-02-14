package algorithm.graph.depthfirstsearch.undirect;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class DepthSpanningTreeTest {
    @Test
    public void dfs() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/depthfirstsearch/undirect/dfsGraph.txt";
        Graph graph = Graph.createGraphFromFile(DepthSpanningTree.class.getResource("/").getPath() + File.separator +
                graphFileName);
        graph.printGraph();

        System.out.println("=====Depth First Search and Spanning Tree=====");
        DepthSpanningTree.depthFirstSearch(graph.getVertex("A"));
    }

}