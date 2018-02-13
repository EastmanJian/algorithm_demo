package algorithm.graph.depthfirstsearch.bridge7island4;


/**
 * A weighted edge start from the source Vertex to its adjacent Vertex (adj).
 */
public class Edge {
    private Vertex src;
    private Vertex adj;
    private String name;
    private boolean visited;

    public Edge(Vertex src, Vertex adj, String name) {
        this.src = src;
        this.adj = adj;
        this.name = name;
        this.visited =false;
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
        return "(" + src + "--" + name + "-->" + adj + ")";
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
