package algorithm.graph.spanningtree.kruskal;


/**
 * A weighted edge start from the source Vertex to its adjacent Vertex (adj).
 */
public class Edge {
    private Vertex src;
    private Vertex adj;
    private int weight;

    public Edge(Vertex src, Vertex adj, int weight) {
        this.src = src;
        this.adj = adj;
        this.weight = weight;
    }

    public Vertex getSrc() {
        return src;
    }

    public void setSrc(Vertex src) {
        this.src = src;
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
