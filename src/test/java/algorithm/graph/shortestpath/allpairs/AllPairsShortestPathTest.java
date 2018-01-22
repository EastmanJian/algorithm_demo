package algorithm.graph.shortestpath.allpairs;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class AllPairsShortestPathTest {
    @Test
    public void testFloyd() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/shortestpath/allpairs/matrixGraph.txt";
        Graph graph = Graph.createGraphFromFile(AllPairsShortestPath.class.getResource("/").getPath() + File.separator +
                graphFileName);

        System.out.println("=========Loaded Graph into matrix=========");
        graph.printGraph(true, true, true);

        AllPairsShortestPath.floyd(graph);
        System.out.println("=========Graph after calculated all pairs shortest path using Floyd's algorithm=========");
        graph.printGraph(true, true, true);
        System.out.println("=========Print the shortest path for each pair=========");
        int n=graph.getAdjMatrix().length;
        for (int i=0; i<n; i++) {
            for (int j=0; j<n; j++) {
                System.out.print("Path(" + i + "," + j + ")[length=" + graph.getDistMatrix()[i][j] + "]: ");
                graph.printPath(i, j);
                System.out.println();
            }
        }

    }

}