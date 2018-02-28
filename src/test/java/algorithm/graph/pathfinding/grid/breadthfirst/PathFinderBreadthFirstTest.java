package algorithm.graph.pathfinding.grid.breadthfirst;

import org.junit.Test;

import java.io.File;

import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.PrintGraphType.*;
import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.Flag.*;
import algorithm.graph.pathfinding.grid.breadthfirst.Graph.Grid;

public class PathFinderBreadthFirstTest {
    @Test
    public void findAllPath() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/breadthfirst/unweightGraph1.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderBreadthFirst.class.getResource("/").getPath() +
                File.separator + graphFileName);

        System.out.println("=====Graph before unweighted shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search all paths from start point (x=8, y=7) to rest points=====");
        PathFinderBreadthFirst.setDebug(true); //set debug to true to see the traversal steps.
        PathFinderBreadthFirst.findAllPath(graph, graph.getGrid(8, 7));
        System.out.println("=====Distance Graph from start point (x=8, y=7)=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Path Graph from start point (x=8, y=7)=====");
        graph.printGraph(ALL_PATH);
    }

    @Test
    public void findSinglePath() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/breadthfirst/unweightGraph2.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderBreadthFirst.class.getResource("/").getPath() +
                File.separator + graphFileName);

        //define starting and destination grid
        Grid from = graph.getGrid(9, 7);
        Grid to = graph.getGrid(15, 6);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before unweighted shortest path found=====");
        graph.printGraph(ORIGIN);
        System.out.println("=====Search path from " +from + " to " + to + "=====");
        PathFinderBreadthFirst.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderBreadthFirst.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
    }


    @Test
    public void findSinglePath1() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/breadthfirst/unweightGraph2.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderBreadthFirst.class.getResource("/").getPath() +
                File.separator + graphFileName);
        Grid from = graph.getGrid(8, 7);
        Grid to = graph.getGrid(23, 6);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before unweighted shortest path found=====");
        graph.printGraph(ORIGIN);
        System.out.println("=====Search path from " +from + " to " + to + "=====");
        PathFinderBreadthFirst.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderBreadthFirst.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
    }

}