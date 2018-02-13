package algorithm.graph.depthfirstsearch.bridge7island4;

import java.util.LinkedList;

public class Bridge7Island4 {

    /**
     * Find all possible paths starting from each vertex (island)
     * @param g
     */
    public static void findAllPaths(Graph g) {
        for (Vertex v : g.getVertexMap().values()) {
            dfsAll(g, v, new LinkedList<>());
        }
    }

    private static int counter = 0;

    /**
     * Use depth-first search algorithm to explore the bridges. Store the visited bridges in a path.
     * @param g - the graph
     * @param s - the starting vertex
     * @param path - records the visited bridges in this path
     */
    private static void dfsAll(Graph g, Vertex s, LinkedList<Edge> path) {
        boolean ended = true;
        for (Edge e : s.getOutEdges().values() ) {
            if (!path.contains(e)) {
                ended = false;
                LinkedList<Edge> pathNext = new LinkedList<>(path); //clone the path for the next recursive call
                pathNext.add(e); pathNext.add(g.getEdge(e.getAdj(), e.getName())); //add both forward and backward edges because they are the same bridge
                dfsAll(g, e.getAdj(), pathNext);
            }
        }
        if (ended) { //strand on an island, all bridges from that island are visited.
            System.out.print("Try Path " + ++counter + ": ");
            for (int i=0; i<path.size(); i+=2) System.out.print(path.get(i) + " ");
            if (path.size() == 14) System.out.print(" [Solved!]"); //if all the edges are visited, problem solved.
            System.out.println();
        }
    }
}
