package algorithm.graph.spanningtree.kruskal;

import java.util.LinkedList;

import static algorithm.graph.shortestpath.weighted.Graph.INFINITY;

public class Vertex {
    private String name;                    // Vertex name
    private LinkedList<Edge> outEdges;   // Weighted out edges

    public Vertex(String nm) {
        name = nm;
        outEdges = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Edge> getOutEdges() {
        return outEdges;
    }

    public String toString() {
        return name;
    }

}