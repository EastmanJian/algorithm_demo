package algorithm.graph.spanningtree;

import java.util.LinkedList;

import static algorithm.graph.shortestpath.weighted.Graph.INFINITY;

public class Vertex {
    private String name;                    // Vertex name
    private LinkedList<OutEdge> outEdges;   // Weighted out edges
    private int dist = INFINITY;      // the weight of the edge connecting to the known vertex
    private Vertex path;              // the previous vertex on the weighted shortest path
    private boolean known = false;    // whether the shortest path/distance is known

    public Vertex(String nm) {
        name = nm;
        outEdges = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<OutEdge> getOutEdges() {
        return outEdges;
    }

    public int getDist() {
        return dist;
    }

    public void setDist(int dist) {
        this.dist = dist;
    }

    public Vertex getPath() {
        return path;
    }

    public void setPath(Vertex path) {
        this.path = path;
    }

    public String toString() {
        return name;
    }

    public boolean isKnown() {
        return known;
    }

    public void setKnown(boolean known) {
        this.known = known;
    }
}