package algorithm.graph.shortestpath.weighted;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Represent a graph using a map in which the key is the vertex name and the value is a Vertex and each Vertex object
 * keeps a list of adjacent vertices.
 */
public class Graph {
    static public int INFINITY = Integer.MAX_VALUE;
    // Maps vertices to internal Vertex. Use TreeMap to sort the vertexName
    private TreeMap<String, Vertex> vertexMap = new TreeMap<>();

    public TreeMap<String, Vertex> getVertexMap() {
        return vertexMap;
    }

    public void addEdge(String sourceName, String destName, int weight) {
        Vertex v = getVertex(sourceName);
        Vertex w = getVertex(destName);
        OutEdge outEdge = new OutEdge(w, weight);
        v.getOutEdges().add(outEdge);
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
            System.out.print(v + ": distance=" + v.getDist() + ", path(prior Vertex)=" + v.getPath()
                    + ", known=" + v.isKnown() + ", adjacency=");
            for (OutEdge e: v.getOutEdges()) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }

    /**
     * Use a recursive method to print the path from the start vertex to the toVertex, by using the
     * prior Vertex (Vertex.path) in the path.
     * @param toVertex
     */
    public void printPath(Vertex toVertex) {
        Vertex prior = toVertex.getPath();
        if (prior != null) {
            printPath(prior);
            System.out.print(" -> " + toVertex);
        } else {
            System.out.print(toVertex);
        }
    }

    /**
     * Create the graph by reading a file. Each line in the file represent an edge by two vertices and a cost, separated
     * by space.
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
                    if (st.countTokens() != 3)
                        throw new Exception();
                    String source = st.nextToken();
                    String dest = st.nextToken();
                    int weight = Integer.parseInt(st.nextToken());
                    g.addEdge(source, dest, weight);
                } catch (Exception e) {
                    System.err.println(e + " " + line);
                }
            }
        } catch (Exception e) {
            System.err.println(e);
        }

        return g;
    }
}
