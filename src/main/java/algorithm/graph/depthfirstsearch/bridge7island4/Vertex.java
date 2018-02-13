package algorithm.graph.depthfirstsearch.bridge7island4;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Vertex {
    private String name;                    // Vertex name
    private Map<String, Edge> outEdges;   //  out edges

    public Vertex(String nm) {
        name = nm;
        outEdges = new ConcurrentHashMap<>();
    }

    public String getName() {
        return name;
    }

    public Map<String,Edge> getOutEdges() {
        return outEdges;
    }

    public String toString() {
        return name;
    }

}