package algorithm.graph.pathfinding.grid.astar;

import org.junit.Test;

import java.io.File;
import algorithm.graph.pathfinding.grid.astar.Graph.Grid;

import static algorithm.graph.pathfinding.grid.astar.Graph.Flag.*;
import static algorithm.graph.pathfinding.grid.astar.Graph.PrintGraphType.*;

public class PathFinderAStarTest {
    @Test
    public void findPath() throws Exception {
        //import the graph from file
        String graphFileName = "algorithm/graph/pathfinding/grid/graphHeuristicTest2.txt";
        Graph graph = Graph.createGraphFromFile(PathFinderAStar.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(false);
        Grid from = graph.getGrid(0, 13);
        Grid to = graph.getGrid(15, 2);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from start point " + from + " to destination point " + to + "=====");
        PathFinderAStar.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderAStar.findPath(graph, from, to);
        System.out.println("=====Priority Graph=====");
        graph.printGraph(PRIORITY);
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
        Graph graph = Graph.createGraphFromFile(PathFinderAStar.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(true);
        Grid from = graph.getGrid(0, 12);
        Grid to = graph.getGrid(14, 2);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from start point " + from + " to destination point " + to + "=====");
        PathFinderAStar.setDebug(true); //set debug to true to see the traversal steps.
        PathFinderAStar.findPath(graph, from, to);
        System.out.println("=====Priority Graph=====");
        graph.printGraph(PRIORITY);
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
        Graph graph = Graph.createGraphFromFile(PathFinderAStar.class.getResource("/").getPath() +
                File.separator + graphFileName);
        graph.setAllowDiagonal(false);
        Grid from = graph.getGrid(0, 27);
        Grid to = graph.getGrid(29, 2);
        from.setFlag(START);
        to.setFlag(DESTINATION);

        System.out.println("=====Graph before shortest path found=====");
        graph.printGraph(ORIGIN);

        System.out.println("=====Search path from start point " + from + " to destination point " + to + "=====");
        PathFinderAStar.setDebug(false); //set debug to true to see the traversal steps.
        PathFinderAStar.findPath(graph, from, to);
        System.out.println("=====Distance Graph=====");
        graph.printGraph(DISTANCE);
        System.out.println("=====Priority Graph=====");
        graph.printGraph(PRIORITY);
        System.out.println("=====Target Path=====");
        graph.getPath(to);
        graph.printGraph(SINGLE_PATH);
        System.out.println("=====Path Graph=====");
        graph.printGraph(ALL_PATH);
        System.out.println("=====Visit Count Graph=====");
        graph.printGraph(VISIT_CNT);

    }
}