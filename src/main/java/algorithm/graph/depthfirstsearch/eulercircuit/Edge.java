package algorithm.graph.depthfirstsearch.eulercircuit;


/**
 * A weighted edge start from the source Vertex to its adjacent Vertex (adj).
 */
public class Edge {
    private Vertex src;
    private Vertex adj;

    public Edge(Vertex src, Vertex adj) {
        this.src = src;
        this.adj = adj;
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

    public String toString() {
        return "(" + src + "-->" + adj + ")";
    }
}
