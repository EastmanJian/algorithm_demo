package algorithm.graph.spanningtree;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class PrimTest {
    @Test
    public void prim() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/spanningtree/graphSpanningTree.txt";
        Graph graph = Graph.createGraphFromFile(Prim.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("==============Graph before spanning tree is found==============");
        graph.printGraph();

        Prim.prim(graph, graph.getVertex("v1"));
        System.out.println("======Graph after spanning tree is found by Prim's algorithm=====");
        graph.printGraph();

        System.out.println("===================Print the edges of the spanning tree====================");
        for (Vertex v: graph.getVertexMap().values()) {
            System.out.println("(" + v + ", " + v.getPath() + ") cost=" + v.getDist());
        }
        System.out.println();
    }

}