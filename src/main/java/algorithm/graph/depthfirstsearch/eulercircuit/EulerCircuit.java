package algorithm.graph.depthfirstsearch.eulercircuit;

import java.util.LinkedList;

/**
 * Euler Circuit Algorithm
 *  1. find the initial cycle from the starting vertex in the graph
 *  2. for other unvisited edges, find adjacent cycles and slice into the initial cycle one by one until all edges are
 *  visited.
 */
public class EulerCircuit {
    /**
     * find Euler Circuit from a graph g starting from vertex s
     * @param g - the graph
     * @param s - the starting vertex
     * @return - the Euler Circuit path
     */
    public static LinkedList<Edge> findEulerCircuit(Graph g, Vertex s) {
        LinkedList<Edge> eulerCircuit;

        //find the first cycled path
        start = s;
        path = new LinkedList<>();
        isCycled = false;
        dfsCycle(g, s);
        System.out.print("Debug: initial cycled path - "); for (Edge e : path) System.out.print(e); System.out.println();
        eulerCircuit = path;

        //find and slice in other cycled paths if the graph has outstanding edges 
        int i = 0;
        while (i < eulerCircuit.size()) {
            Vertex nextStart = eulerCircuit.get(i).getSrc();
            if (nextStart.getOutEdges().size() !=0) {
                start = nextStart;
                path = new LinkedList<>();
                isCycled = false;
                dfsCycle(g, nextStart);
                System.out.print("Debug: adjacent cycled path - "); for (Edge e : path) System.out.print(e); System.out.println();
                eulerCircuit.addAll(i, path); //slice in the new cycled path
                System.out.print("Debug: slice in - "); for (Edge e : eulerCircuit) System.out.print(e); System.out.println();
            }
            i++;
        }
        return eulerCircuit;
    }

    
    private static LinkedList<Edge> path; // the cycled path found on each depth-first search
    private static Vertex start;  //the starting vertex
    private static boolean isCycled; //a flag to indicate the depth-first search is back to the start vertex

    /**
     * Depth-first search algorithm to find a cycle from the start vertex
     * @param g - the graph
     * @param s - the start vertex
     */
    private static void dfsCycle(Graph g, Vertex s) {
        for (Edge e : s.getOutEdges().values()) {
            if (isCycled) break;
            path.add(e);
            g.removeEdge(e.getAdj(), e.getSrc()); g.removeEdge(e); //remove both direction edges
            Vertex next = e.getAdj();
            if (next != start) {
                dfsCycle(g, next);
            } else {
                isCycled = true;
            }
        }
    }
}
