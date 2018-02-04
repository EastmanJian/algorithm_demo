package algorithm.graph.spanningtree.kruskal;

import java.util.Comparator;

public class WeightComparator implements Comparator<Edge> {
    public int compare(Edge a, Edge b) {
        return a.getWeight() - b.getWeight();
    }
}
