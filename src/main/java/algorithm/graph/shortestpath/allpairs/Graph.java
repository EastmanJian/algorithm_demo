package algorithm.graph.shortestpath.allpairs;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 * Represent a graph using a adjacency matrix a[][], distance matrix d[][], and path matrix p[][].
 * The vertex are named by natural order 0, 1, 2, 3, ...
 */
public class Graph {
    static public int INFINITY = 99999;
    static public int NOT_A_VERTEX = -1;
    private int a[][];   //adjacency matrix, a[i][j] stores the weight of edge(i, j)
    private int d[][];   //distance matrix, d[i][j] stores the distances of the path(i, j)
    private int p[][];   //path matrix, p[i][j] stores the last but one vertex on the shortest path(i, j).

    public Graph(int dimension) {
        //initiate the graph matrix
        a = new int[dimension][dimension];
        d = new int[dimension][dimension];
        p = new int[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                a[i][j] = INFINITY;
                d[i][j] = INFINITY;
                p[i][j] = NOT_A_VERTEX;
            }

        }
    }

    public int[][] getAdjMatrix() {
        return a;
    }

    public int[][] getDistMatrix() {
        return d;
    }

    public int[][] getPathMatrix() {
        return p;
    }

    public void addEdge(int i, int j, int weight) {
        a[i][j] = weight;
    }

    public void printGraph(boolean printEdges, boolean printDist, boolean printPath) {
        if (printEdges) {
            System.out.println("-----Adjacency Matrix-----");
            printMatrix(a);
        }

        if (printDist) {
            System.out.println("-----Distance Matrix-----");
            printMatrix(d);

        }

        if (printPath) {
            System.out.println("-----Paths Matrix-----");
            printMatrix(p);

        }
    }

    private void printMatrix(int m[][]) {
        for (int i = 0; i < m.length; i++) {
            System.out.print("|");
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] == INFINITY) {
                    System.out.print(" ∞ ");
                } else {
                    System.out.printf("%3d ", m[i][j]);
                }
            }
            System.out.println("|");
        }
    }

    public void printPath(int i, int j) {
        int prior = p[i][j];
        if (prior != NOT_A_VERTEX) {
            printPath(i, prior);
            System.out.print(" -> " + j);
        } else {
            System.out.print(i);
        }
    }

    /**
     * Create the graph by reading a file.
     * The content of the file represent a adjacency matrix which contains weighted edges for each pair of vertices.
     *
     * @param fileName - the file represent the graph
     * @return - the graph
     */
    static public Graph createGraphFromFile(String fileName) {
        int dimension = 0;
        Graph g = null;
        try {
            FileReader fin = new FileReader(fileName);
            BufferedReader graphFile = new BufferedReader(fin);

            // Read the edges and insert
            String line;
            int i = 0;
            while ((line = graphFile.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(line);
                dimension = st.countTokens();
                if (g == null) {
                    g = new Graph(dimension);
                }
                try {
                    if (st.countTokens() != dimension)
                        throw new Exception();
                    for (int j = 0; j < dimension; j++) {
                        String nextToken = st.nextToken();
                        if ("∞".equals(nextToken)) {
                            g.addEdge(i, j, INFINITY);
                        } else {
                            g.addEdge(i, j, Integer.parseInt(nextToken));
                        }
                    }
                } catch (Exception e) {
                    System.err.println(e + " " + line);
                    e.printStackTrace();
                }
                i++;
            }
        } catch (Exception e) {
            System.err.println(e);
        }


        return g;
    }
}
