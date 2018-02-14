package algorithm.graph.depthfirstsearch.eulertour;

import org.junit.Test;

import java.io.File;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class EulerTourTest {
    @Test
    public void findEulerTourPath() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/depthfirstsearch/eulertour/eulerTourGraph.txt";
        Graph graph = Graph.createGraphFromFile(EulerTour.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("==============Graph has Euler Tour Path==============");
        graph.printGraph();

        System.out.println("==============Find Euler Tour Path==============");
        LinkedList<Edge> path = EulerTour.findEulerTourPath(graph, graph.getVertex("E"), graph.getVertex("F"));
        System.out.print("Euler Tour Path found:"); for (Edge e : path) System.out.print(e);
        System.out.println();

        System.out.println("==============Graph after Euler Tour Path is found==============");
        graph.printGraph();
    }

}