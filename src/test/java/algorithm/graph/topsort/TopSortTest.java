package algorithm.graph.topsort;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;


public class TopSortTest {
    @Test
    public void testTopSort() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/topsort/topSortGraph.txt";
        Graph graph = Graph.createGraphFromFile(TopSort.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("===================Graph before topological sort====================");
        graph.printGraph();

        //sort
        TopSort.topSort(graph);
        System.out.println("===================Graph after topological sort====================");
        graph.printGraph();

    }

}