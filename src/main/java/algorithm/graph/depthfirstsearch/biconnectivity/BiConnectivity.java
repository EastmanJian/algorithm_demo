package algorithm.graph.depthfirstsearch.biconnectivity;

/**
 * Algorithm to find articulation points in a non-biconnected graph.
 * 		○ Use DFS algorithm to generate the depth-first spanning tree of the graph
 *      ○ Calculate Num(v) and Low(v) for each vertex, where
 *           - Num(v) is the preorder traversal vertex order number
 *           - Low(v) is the lowest vertex number that the node can reach through a few forward edges with a back edge.
 *      ○ Identify articulation points according to the following two rules
 *           i. The root is an articulation point if and only if it has more than one child.
 *          ii. Any other vertex v is an articulation point if and only if v has some child w such that Low(w) ≥ Num(v).
 */
public class BiConnectivity {
    public static void findArticulationPoint(Vertex v) {
        counter = 1;
        findArt(v);
        testRoot(v);
    }

    private static int counter;

    /**
     * Find articulation points from a depth-first search tree of a graph, except the tree root.
     *   Low(v) is the minimum of
     *     Rule 1. Num(v)
     *     Rule 2. the lowest Num(w) among all back edges (v, w)
     *     Rule 3. the lowest Low(w) among all forward edges (v, w)
     * @param v
     */
    private static void findArt(Vertex v) {
        v.setVisited(true);
        v.setNum(counter);
        v.setLow(counter);  // Rule 1
        counter++;

        for (Vertex w : v.getAdj()) {
            if (!w.isVisited()) { // Forward edge
                w.setParent(v);
                findArt(w);
                if (w.getLow() >= v.getNum() && v.getNum() != 1)
                    System.out.println(v + " is an articulation point");
                v.setLow(Math.min(v.getLow(), w.getLow())); // Rule 3
            } else if (v.getParent() != w) {// Back edge
                v.setLow(Math.min(v.getLow(), w.getNum())); // Rule 2
                if (v.getNum() > w.getNum()) System.out.println("Back Edge: " + v + "-->" + w);
            }
        }
    }

    /**
     * special rule to test if the tree root is an articulation point
     * @param r
     */
    private static void testRoot(Vertex r) {
        int childCnt = 0;
        for (Vertex w : r.getAdj())
            if (w.getParent() == r) childCnt++;
        if (childCnt > 1) System.out.println(r + " is an articulation point");
    }

}
