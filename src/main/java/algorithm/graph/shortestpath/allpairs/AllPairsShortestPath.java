package algorithm.graph.shortestpath.allpairs;

public class AllPairsShortestPath {
    /**
     * Floyd's Algorithm - calculate the shortest paths for all pairs of vertices in the graph.
     * Main idea:
     *  Use the adjacency matrix for calculation
     *  1) Initially, consider the weighted edges as the paths for those adjacent vertices.
     *     i.e. Set initial distance matrix as the same as the adjacency matrix, path matrix as the same as the edges.
     *  2) loop each vertex (as k) and consider it is an intermediate vertex in the path for any pair of vertices (i, ..., j).
     *     hence the path is separated to (i, ..., k) and (k, ..., j). i.e. (i, ..., k, ..., j).
     *  3) if the path (i, ..., k, ..., j) is shorter then original path (i, ..., j), mark the shorter distance in d[i][j] and
     *     mark the last-but-one vertex in path (i, ..., k, ..., j) in p[i][j].
     * @param graph
     */
    static public void floyd(Graph graph) {
        int a[][] = graph.getAdjMatrix();
        int d[][] = graph.getDistMatrix();
        int p[][] = graph.getPathMatrix();
        int n = a.length;

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                d[i][j] = a[i][j];  //set initial distance as the weight of the edges
                if (d[i][j] != Graph.INFINITY && i != j) {
                    p[i][j] = i;  //set the initial prior vertex as i for adjacent path(i, j)
                }
            }
        }

        for (int k = 0; k < n; k++) {
            // Consider each vertex as an intermediate
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (d[i][k] + d[k][j] < d[i][j]) {
                        // Update shortest path
                        d[i][j] = d[i][k] + d[k][j]; //replace to the shorter distance
                        p[i][j] = p[k][j];  //replace the last-but-one vertex on path(i,j) to the last-but-one vertex on path(k,j)
                    }
        }
    }
}
