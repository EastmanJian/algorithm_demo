package algorithm.graph.depthfirstsearch.biconnectivity;

import java.util.LinkedList;

public class Vertex {
    private String name;              // Vertex name
    private LinkedList<Vertex> adj;   // Adjacent vertices
    private boolean visited = false; //whether the vertex is visited by the DFS algorithm
    private Vertex parent;           //the parent vertex in the depth spanning tree
    private int num;                 //preorder number
    private int low;      //the the lowest vertex number that the node can reach through forward edges with a back edge

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

    public String toString() {
        return name;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public Vertex getParent() {
        return parent;
    }

    public void setParent(Vertex parent) {
        this.parent = parent;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }
}