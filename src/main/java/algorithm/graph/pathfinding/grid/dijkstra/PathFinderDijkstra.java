package algorithm.graph.pathfinding.grid.dijkstra;

import algorithm.graph.pathfinding.grid.dijkstra.Graph.Grid;

import java.util.PriorityQueue;
import java.util.concurrent.LinkedBlockingQueue;

import static algorithm.graph.pathfinding.grid.dijkstra.Graph.Flag.*;
import static algorithm.graph.pathfinding.grid.dijkstra.Graph.PrintGraphType.*;


public class PathFinderDijkstra {
    private static boolean debug = false;
    private static int stepCnt = 0;

    /**
     * Find path from grid s to d.
     *
     * @param g - the graph represented by grids.
     * @param s - the starting grid.
     * @param d - the destination grid. If d is null, find all paths from s to all rest grids.
     * @throws InterruptedException
     */
    public static void findPath(Graph g, Grid s, Grid d) throws InterruptedException {
        //define a priority queue to store the grids being searched, sorted by distance
        PriorityQueue<Grid> frontier = new PriorityQueue<>(new DistComparator());

        //the shortest path from s to s is zero.
        s.setDist(0);
        frontier.offer(s);

        //handle each item in the frontier queue
        Grid current;
        while (!frontier.isEmpty()) {
            current = frontier.poll();
            current.setKnown(true);

            if (current.getFlag() == DESTINATION) break;

            //visit and set the distance and path of each unknown adjacent grid, and put it in the frontier priority queue
            for (Grid neighbour : current.getNeighbours()) {
                if (!neighbour.isKnown()) {
                    float newDist = current.getDist() + g.getDist(current, neighbour);
                    if (newDist < neighbour.getDist()) {
                        neighbour.setDist(newDist);
                        neighbour.setPath(current);
                        frontier.offer(neighbour);
                    }
                }
            }
            if (debug) {
                g.printGraph(DISTANCE);
                System.out.println("Step: " + ++stepCnt);
                Thread.sleep(50);
            }
        }
    }

    public static void findAllPath(Graph g, Grid s) throws InterruptedException {
        findPath(g, s, null);
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean d) {
        debug = d;
    }
}
