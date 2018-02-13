package algorithm.graph.depthfirstsearch.bridge7island4;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class Bridge7Island4Test {
    @Test
    public void findAllPaths() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/depthfirstsearch/bridge7island4/bridge7island4.txt";
        Graph graph = Graph.createGraphFromFile(Bridge7Island4.class.getResource("/").getPath() + File.separator +
                graphFileName);
        graph.printGraph();

        Bridge7Island4.findAllPaths(graph);
    }

}