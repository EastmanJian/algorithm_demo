package algorithm.graph.depthfirstsearch.biconnectivity;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BiConnectivityTest {
    @Test
    public void findArticulationPoint() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/depthfirstsearch/biconnectivity/biConGraph.txt";
        Graph graph = Graph.createGraphFromFile(BiConnectivity.class.getResource("/").getPath() + File.separator +
                graphFileName);
        graph.printGraph();

        System.out.println("=====find articulation points from vertex A=====");
        BiConnectivity.findArticulationPoint(graph.getVertex("A"));

        System.out.println("=====graph after articulation points are found=====");
        graph.printGraph();

        //load again
        graph = Graph.createGraphFromFile(BiConnectivity.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("=====find articulation points from vertex C=====");
        BiConnectivity.findArticulationPoint(graph.getVertex("C"));

        System.out.println("=====graph after articulation points are found=====");
        graph.printGraph();

    }



}