package algorithm.graph.spanningtree.kruskal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Kruskal’s algorithm to find minimum spanning tree.
 *
 * This greedy strategy is continually to select the edges in order of smallest weight and accept an edge if it does not
 * cause a cycle.
 * Kruskal’s algorithm maintains a forest - a collection of trees. Initially, there are |V| single-node trees. Adding an
 * edge merges two trees into one. When the algorithm terminates, there is only one tree, and this is the minimum
 * spanning tree.
 * Use Disjoint Set data structure to decide if a new edge causes a cycle. Two vertices belong to the same set if and
 * only if they are connected in the current spanning forest. Each vertex is initially in its own set. If u and v are
 * in the same set, the edge is rejected, because since they are already connected, adding (u, v) would form a cycle.
 * Otherwise, the edge is accepted, and a union is performed on the two sets containing u and v.
 *
 */
public class Kruskal {
    public static List<Edge> kruskal(List<Edge> edges, Map<String, Vertex> vertices)
    {
        PriorityQueue<Edge> pq = new PriorityQueue<>(new WeightComparator());
        //Insert the edges into the queue
        for (Edge e: edges) {
            pq.add(e);
        }

        //put the vertices into a disjoint set.
        DisjSets<Vertex> ds = new DisjSets<>( vertices.values() );

        //declare the minimum spanning tree acceptance edges list
        List<Edge> mst = new ArrayList<>( );

        while( mst.size() != vertices.size() - 1 ) //loop until all vertices are connected
        {
            Edge e = pq.poll( ); // Edge e = (u, v), find the edge with smallest weight
            Vertex uSet = ds.find( e.getSrc());
            Vertex vSet = ds.find( e.getAdj());
            if( uSet != vSet ) //check if two vertices are already connected
            {
                // Accept the edge
                mst.add( e );
                ds.union( uSet, vSet );
            }
        }
        return mst;
    }
}
