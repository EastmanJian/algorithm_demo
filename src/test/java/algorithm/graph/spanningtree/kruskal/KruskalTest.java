package algorithm.graph.spanningtree.kruskal;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class KruskalTest {
    @Test
    public void kruskal() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/spanningtree/kruskal/graphSpanningTree.txt";
        Graph graph = Graph.createGraphFromFile(Kruskal.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("==============Graph before spanning tree is found==============");
        graph.printGraph();


        List<Edge> mst = Kruskal.kruskal(graph.getEdges(), graph.getVertexMap());
        System.out.println("===================Print the edges of the spanning tree====================");
        for (Edge e: mst) {
            System.out.println("(" + e.getSrc() + ", " + e.getAdj() + ") cost=" + e.getWeight());
        }
    }

    @Test
    public void disjSets() throws Exception {
        List<String> elements = new ArrayList<>();
        elements.add("v1");
        elements.add("v2");
        elements.add("v3");
        elements.add("v4");
        elements.add("v5");
        DisjSets<String> disjSets = new DisjSets<>(elements);

        System.out.println("=====after init=====");
        for (String e: elements) System.out.println(e+ ": " + disjSets.find(e));

        disjSets.union("v2","v3");
        System.out.println("=====after union v2 and v3=====");
        for (String e: elements) System.out.println(e+ ": " + disjSets.find(e));

        disjSets.union("v4","v5");
        System.out.println("=====after union v4 and v5=====");
        for (String e: elements) System.out.println(e+ ": " + disjSets.find(e));

        disjSets.union("v1","v2");
        System.out.println("=====after union v1 and v2=====");
        for (String e: elements) System.out.println(e+ ": " + disjSets.find(e));

        disjSets.union("v4","v1");
        System.out.println("=====after union v4 and v1=====");
        for (String e: elements) System.out.println(e+ ": " + disjSets.find(e));

    }

}