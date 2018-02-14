package algorithm.graph.depthfirstsearch.eulertour;



import java.util.LinkedList;

/**
 * Euler Tour Algorithm
 *  1. find the initial path from the starting vertex to the ending vertex in the graph
 *  2. for other unvisited edges, find adjacent cycles and slice into the initial cycle one by one until all edges are
 *  visited.
 */
public class EulerTour {
    /**
     * find Euler Tour path from a graph g starting from vertex s and ending at vertex e
     * @param g - the graph
     * @param s - the starting vertex
     * @param e - the ending vertex
     * @return - the Euler Tour path
     */
    public static LinkedList<Edge> findEulerTourPath(Graph g, Vertex s, Vertex e) {
        LinkedList<Edge> eulerTourPath;

        //find the initial path
        path = new LinkedList<>();
        isThrough = false;
        dfsPath(g, s, e);
        System.out.print("Debug: initial path - "); for (Edge edge : path) System.out.print(edge); System.out.println();
        eulerTourPath = path;

        //find and slice in other cycled paths if the graph has outstanding edges 
        int i = 0;
        while (i < eulerTourPath.size()) {
            Vertex nextStart = eulerTourPath.get(i).getSrc();
            if (nextStart.getOutEdges().size() !=0) {
                path = new LinkedList<>();
                isThrough = false;
                dfsPath(g, nextStart, nextStart);
                System.out.print("Debug: adjacent cycled path - "); for (Edge edge : path) System.out.print(edge); System.out.println();
                eulerTourPath.addAll(i, path); //slice in the new cycled path
                System.out.print("Debug: slice in - "); for (Edge edge : eulerTourPath) System.out.print(edge); System.out.println();
            }
            i++;
        }
        return eulerTourPath;
    }

    
    private static LinkedList<Edge> path; // the path found on each depth-first search
    private static boolean isThrough; //a flag to indicate the depth-first search is done from start to end vertex

    /**
     * Depth-first search algorithm to find a path from the starting vertex to the ending vertex
     * @param g - the graph
     * @param s - the start vertex
     */
    private static void dfsPath(Graph g, Vertex s, Vertex e) {
        for (Edge edge : s.getOutEdges().values()) {
            if (isThrough) break;
            path.add(edge);
            g.removeEdge(edge.getAdj(), edge.getSrc()); g.removeEdge(edge); //remove both direction edges
            Vertex nextStart = edge.getAdj();
            if (nextStart != e) {
                dfsPath(g, nextStart, e);
            } else {
                isThrough = true;
            }
        }
    }
}
