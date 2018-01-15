package algorithm.graph.shortestpath.unweighted;

import java.util.LinkedList;

import static algorithm.graph.shortestpath.unweighted.Graph.INFINITY;

public class Vertex {
    private String name;              // Vertex name
    private LinkedList<Vertex> adj;   // Adjacent vertices
    private int dist = INFINITY;     // distance from the starting vertex
    private Vertex path;              // the previous vertex on the unweighted shortest path

    public Vertex(String nm) {
        name = nm;
        adj = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public LinkedList<Vertex> getAdj() {
        return adj;
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
}