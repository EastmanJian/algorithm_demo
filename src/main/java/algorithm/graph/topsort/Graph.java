package algorithm.graph.topsort;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

/**
 * Represent a graph using a map in which the key is the vertex name and the value is a Vertex and each Vertex object
 * keeps a list of adjacent vertices.
 */
public class Graph {
    // Maps vertices to internal Vertex. Use TreeMap to sort the vertexName
    private TreeMap<String, Vertex> vertexMap = new TreeMap<>();

    public TreeMap<String, Vertex> getVertexMap() {
        return vertexMap;
    }

    public void addEdge(String sourceName, String destName) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        v.getAdj().add(w);
    }


    // If vertexName is not present, add it to vertexMap.
    // In either case, return the Vertex.
    public Vertex getVertex(String vertexName) {
        Vertex v = vertexMap.get(vertexName);
        if (v == null) {
            v = new Vertex(vertexName);
            vertexMap.put(vertexName, v);
        }
        return v;
    }

    public void printGraph() {
        for (Vertex v: vertexMap.values()) {
            System.out.print(v + ": indegree=" + v.getIndegree() + ", sortNum=" + v.getSortNum() + ", adjacency=");
            for (Vertex w: v.getAdj()) {
                System.out.print(w.getName() + " ");
            }
            System.out.println();
        }
    }

    public void calculateIndegree() {
        //reset all indegree to zero
        for (Vertex v: vertexMap.values())
            v.setIndegree(0);
        //calculate the indegree for each vertex by its adjacency.
        for (Vertex v: vertexMap.values()) {
            for (Vertex w: v.getAdj()) {
                w.increaseIndegree();
            }
        }
    }


    /**
     * Create the graph by reading a file. Each line in the file represent an edge by two vertices, separated by space.
     * @param fileName - the file represent the graph
     * @return - the graph
     */
    static public Graph createGraphFromFile(String fileName) {
        Graph g = new Graph();
        try {
            FileReader fin = new FileReader(fileName);
            BufferedReader graphFile = new BufferedReader(fin);

            // Read the edges and insert
            String line;
            while ((line = graphFile.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);

                try {
                    if (st.countTokens() != 2)
                        throw new Exception();
                    String source = st.nextToken();
                    String dest = st.nextToken();
                    g.addEdge(source, dest);
                } catch (Exception e) {
                    System.err.println(e + " " + line);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        g.calculateIndegree();

        return g;
    }
}
