package algorithm.graph.topsort;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by jiany on 2018-01-15.
 */
public class GraphTest {
    @Test
    public void printGraph() throws Exception {
        String graphFileName = "algorithm/graph/topsort/topSortGraph.txt";
        Graph graph = Graph.createGraphFromFile(TopSort.class.getResource("/").getPath() + File.separator +
                graphFileName);
        graph.printGraph();

    }

}