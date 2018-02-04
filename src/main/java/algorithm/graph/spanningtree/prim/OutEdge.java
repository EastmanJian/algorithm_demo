package algorithm.graph.spanningtree.prim;


/**
 * A weighted edge start from the owning Vertex to its adjacent Vertex (adj).
 */
public class OutEdge {
    private Vertex adj;
    private int weight;

    public OutEdge(Vertex adj, int weight) {
        this.adj = adj;
        this.weight = weight;
    }

    public Vertex getAdj() {
        return adj;
    }

    public void setAdj(Vertex adj) {
        this.adj = adj;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return adj + "(" + weight + ")";
    }
}
