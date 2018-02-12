package algorithm.graph.depthfirstsearch.undirect;

public class DepthSpanningTree {
    /**
     * Depth First Search Algorithm.
     * It's a preorder traversal algorithm.
     * Mark the vertices preorder numbers, and generate a depth spanning tree with tree edges and back edges
     * @param v the begin vertex
     */
    public static void depthFirstSearch(Vertex v) {
        counter = 1;
        dfs(v);
    }

    private static int counter;
    private static void dfs(Vertex v) {
        v.setVisited(true);
        v.setNum(counter++);
        System.out.println(v + " visited. Preorder Number is " + v.getNum());
        for (Vertex w : v.getAdj()) {
            if (!w.isVisited()) {
                w.setParent(v);
                System.out.println(" (forward edge: " + v + "==>" + w + ") ");
                dfs(w);
            } else if (w.isVisited() && v.getParent() != w && w.getNum() < v.getNum()){
                System.out.println(" (back edge: " + v + "-->" + w + ") ");
            }
        }
    }
}
