package algorithm.graph.pathfinding.grid.dijkstra;

import org.junit.Test;

import java.io.File;

import static algorithm.graph.pathfinding.grid.dijkstra.Graph.PrintGraphType.*;
import static algorithm.graph.pathfinding.grid.dijkstra.Graph.Flag.*;

import algorithm.graph.pathfinding.grid.dijkstra.Graph.Grid;

public class PathFinderDijkstraTest {
    @Test
    public void findSinglePath() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/dijkstra/weightedGraph1.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderDijkstra.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(true);

        Grid from = graph.getGrid(1, 4);
        Grid to = graph.getGrid(8, 5);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from start point " + from + " to destination point " + to + "=====");
        PathFinderDijkstra.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderDijkstra.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
    }

    @Test
    public void findPathCompareHeuristic() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/graphHeuristicTest2.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderDijkstra.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(true);
        Grid from = graph.getGrid(0, 13);
        Grid to = graph.getGrid(15, 2);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from " + from + " to " + to + "=====");
        PathFinderDijkstra.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderDijkstra.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
    }

    @Test
    public void findPathInConcave() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/graphAStar1.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderDijkstra.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(true);
        Grid from = graph.getGrid(0, 12);
        Grid to = graph.getGrid(14, 2);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from " + from + " to " + to + "=====");
        PathFinderDijkstra.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderDijkstra.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
    }

    @Test
    public void findPathInConcave2() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/graphAStar2.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderDijkstra.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(true);
        Grid from = graph.getGrid(0, 27);
        Grid to = graph.getGrid(29, 2);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from " + from + " to " + to + "=====");
        PathFinderDijkstra.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderDijkstra.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
    }
}