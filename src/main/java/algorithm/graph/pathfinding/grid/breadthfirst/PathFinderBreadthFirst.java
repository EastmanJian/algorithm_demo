package algorithm.graph.pathfinding.grid.breadthfirst;

import java.util.concurrent.LinkedBlockingQueue;
import algorithm.graph.pathfinding.grid.breadthfirst.Graph.Grid;
import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.INFINITY;
import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.PrintGraphType.*;
import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.Flag.*;


public class PathFinderBreadthFirst {
    private static boolean debug=false;

    /**
     * Breadth-first search algorithm to find path from grid s to d.
     *
     * @param g - the graph represented by grids.
     * @param s - the starting grid.
     * @param d - the destination grid. If d is null, find all paths from s to all rest grids.
     * @throws InterruptedException
     */
    public static void findPath(Graph g, Grid s, Grid d) throws InterruptedException {
        //define an FIFO queue to store the grids being searched
        LinkedBlockingQueue<Grid> frontier = new LinkedBlockingQueue<>( );

        //the shortest path from s to s is zero.
        s.setDist(0);
        frontier.offer(s);

        //handle each item in the frontier queue
        Grid current;
        while (!frontier.isEmpty()) {
            current = frontier.poll();

            if (current.getFlag() == DESTINATION) break;

            //visit and set the distance and path of each adjacent grid, and put it in the frontier queue
            for (Grid neighbour: current.getNeighbours()) {
                if (neighbour.getDist() == INFINITY) {
                    neighbour.setDist(current.getDist() + 1);
                    neighbour.setPath(current);
                    frontier.offer(neighbour);
                }
            }
            if (debug) {
                g.printGraph(DISTANCE);
                Thread.sleep(50);
            }
        }
    }

    /**
     * Breadth-first search algorithm to find path from grid s to all rest grids.
     */
    public static void  findAllPath(Graph g, Grid s) throws InterruptedException {
        findPath(g, s, null);
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean d) {
        debug = d;
    }
}
