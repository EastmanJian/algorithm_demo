package algorithm.graph.topsort;

import java.util.LinkedList;

public class Vertex {
    private String name;              // Vertex name
    private LinkedList<Vertex> adj;   // Adjacent vertices
    private int indegree = 0;         // Indegree of the Vertex
    private int sortNum = 0;           // the topological sorting number

    public Vertex(String nm) {
        name = nm;
        adj = new LinkedList<>();
    }

    public int getIndegree() {
        return indegree;
    }

    public void setIndegree(int indegree) {
        this.indegree = indegree;
    }

    public void increaseIndegree () {
        this.indegree++;
    }

    public void decreaseIndegree () {
        this.indegree--;
    }

    public String getName() {
        return name;
    }

    public LinkedList<Vertex> getAdj() {
        return adj;
    }


    public int getSortNum() {
        return sortNum;
    }

    public void setSortNum(int sortNum) {
        this.sortNum = sortNum;
    }
}