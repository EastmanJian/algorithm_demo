package algorithm.graph.spanningtree.prim;

import java.util.Comparator;

public class DistComparator implements Comparator<Vertex> {
    public int compare(Vertex a, Vertex b) {
        return a.getDist() - b.getDist();
    }
}
