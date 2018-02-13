package algorithm.graph.depthfirstsearch.bridge7island4;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Represent a graph using a map in which the key is the vertex name and the value is a Vertex and each Vertex object
 * keeps a list of out edges.
 */
public class Graph {
    static public int INFINITY = Integer.MAX_VALUE;
    // Maps vertices to internal Vertex. Use TreeMap to sort the vertexName
    private TreeMap<String, Vertex> vertexMap = new TreeMap<>();

    public TreeMap<String, Vertex> getVertexMap() {
        return vertexMap;
    }

    public void addEdge(String srcVertexName, String destVertexName, String name) {
        Vertex v = getVertex(srcVertexName);
        Vertex w = getVertex(destVertexName);
        Edge outEdge = new Edge(v, w, name);
        v.getOutEdges().put(name, outEdge);
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

    public List<Edge> getEdges () {
        List<Edge> edges = new ArrayList<>();
        for(Vertex v: vertexMap.values()) {
            for (Edge e: v.getOutEdges().values()) {
                edges.add(e);
            }
        }
        return edges;
    }

    public Edge getEdge (String srcVertexName, String edgeName) {
        Vertex srcVertex = getVertex(srcVertexName);
        return getEdge(srcVertex, edgeName);
    }

    public Edge getEdge (Vertex srcVertex, String edgeName) {
        return srcVertex.getOutEdges().get(edgeName);
    }

    public Edge removeEdge (String srcVertexName, String destVertexName) {
        Vertex srcVertex = getVertex(srcVertexName);
        Vertex destVertex = getVertex(destVertexName);
        return removeEdge(srcVertex, destVertex);
    }

    public Edge removeEdge (Vertex srcVertex, Vertex destVertex) {
        return srcVertex.getOutEdges().remove(destVertex);
    }

    public Edge removeEdge (Edge e) {
        return removeEdge (e.getSrc(), e.getAdj());
    }

    public void printGraph() {
        for (Vertex v: vertexMap.values()) {
            System.out.print(v + ", adjacency=");
            for (Edge e: v.getOutEdges().values()) {
                System.out.print(e + " ");
            }
            System.out.println();
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
                    if (st.countTokens() != 3)
                        throw new Exception();
                    String source = st.nextToken();
                    String dest = st.nextToken();
                    String name = st.nextToken();
                    g.addEdge(source, dest, name);
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
