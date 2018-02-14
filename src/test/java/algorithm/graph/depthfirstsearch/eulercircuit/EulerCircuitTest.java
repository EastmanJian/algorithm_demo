package algorithm.graph.depthfirstsearch.eulercircuit;

import org.junit.Test;

import java.io.File;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class EulerCircuitTest {
    @Test
    public void findEulerCircuit() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/depthfirstsearch/eulercircuit/eulerGraph.txt";
        Graph graph = Graph.createGraphFromFile(EulerCircuit.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("==============Graph has Euler Circuit==============");
        graph.printGraph();

        System.out.println("==============Find Euler Circuit==============");
        LinkedList<Edge> path = EulerCircuit.findEulerCircuit(graph, graph.getVertex("5"));
        System.out.print("Euler Circuit found:"); for (Edge e : path) System.out.print(e);
        System.out.println();

        System.out.println("==============Graph after Euler Circuit is found==============");
        graph.printGraph();
    }

}