package algorithm.graph.depthfirstsearch.eulercircuit;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Vertex {
    private String name;                    // Vertex name
    private Map<Vertex, Edge> outEdges;   // Weighted out edges

    public Vertex(String nm) {
        name = nm;
        outEdges = new ConcurrentHashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<Vertex,Edge> getOutEdges() {
        return outEdges;
    }

    public String toString() {
        return name;
    }

}