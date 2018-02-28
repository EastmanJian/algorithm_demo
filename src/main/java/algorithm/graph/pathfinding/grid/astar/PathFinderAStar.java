package algorithm.graph.pathfinding.grid.astar;

import algorithm.graph.pathfinding.grid.astar.Graph.Grid;

import java.util.PriorityQueue;

import static algorithm.graph.pathfinding.grid.astar.Graph.Flag.DESTINATION;
import static algorithm.graph.pathfinding.grid.astar.Graph.PrintGraphType.*;


public class PathFinderAStar {
    private static boolean debug = false;
    private static int stepCnt = 0;

    /**
     * A* algorithm finding path from grid s to d.
     *
     * @param g - the graph represented by grids.
     * @param s - the starting grid.
     * @param d - the destination grid.
     * @throws InterruptedException
     */
    public static void findPath(Graph g, Grid s, Grid d) throws InterruptedException {
        //define a priority queue to store the grids being searched, sorted by priority
        PriorityQueue<Grid> frontier = new PriorityQueue<>(new PriorityComparator());

        //the shortest path from s to s is zero.
        s.setPriority(0);
        s.setDist(0);
        frontier.offer(s);

        //handle each item in the frontier queue
        Grid current;
        while (!frontier.isEmpty()) { //main loop
            current = frontier.poll();
            current.setKnown(true);

            if (current.getFlag() == DESTINATION) break;

            //visit and set the distance, path, and priority of each unknown adjacent grid, and put it in the frontier priority queue
            for (Grid neighbour : current.getNeighbours()) {
                if (!neighbour.isKnown()) {
                    float newDist = current.getDist() + g.getDist(current, neighbour);
                    if (newDist < neighbour.getDist()) {
                        neighbour.setDist(newDist);
                        float heuristic, p = 0.2f; //tie breaker p
                        if (g.isAllowDiagonal()) {
                            heuristic = heuristicDiagonal(neighbour, d);
                        } else {
                            heuristic = heuristicManhattanWithTie(neighbour, d, s);
                        }
                        //set the grid's priority f(n) = g(n) + h(n), because of the priority queue, each main loop examine the lowest f(n)
                        float priority = newDist + (1 + p) * heuristic;
                        neighbour.setPriority(priority);
                        neighbour.setPath(current);
                        frontier.offer(neighbour);
                        neighbour.visitCnt++; //just for debug, counting the number of visits for each grid
                    }
                }
            }
            if (debug) {
                g.printGraph(PRIORITY);
                System.out.println("Step: " + ++stepCnt);
                Thread.sleep(50);
            }
        }
    }

    /**
     * Normal 4-direction grid map heuristic function - Manhattan distance
     */
    private static float heuristicManhattan(Grid a, Grid b) {
        // Manhattan distance from a to b
        float dx = Math.abs(a.getX() - b.getX());
        float dy = Math.abs(a.getY() - b.getY());
        return dx + dy;
    }

    /**
     * Manhattan distance with Tie Breaker for better straight line up
     */
    private static float heuristicManhattanWithTie(Grid current, Grid goal, Grid start) {
        // Manhattan distance from a to b
        float dx = Math.abs(current.getX() - goal.getX());
        float dy = Math.abs(current.getY() - goal.getY());

        //tie breaker to prefer paths that are along the straight line from the starting point to the goal
        float dx1 = current.getX() - goal.getX();
        float dy1 = current.getY() - goal.getY();
        float dx2 = start.getX() - goal.getX();
        float dy2 = start.getY() - goal.getY();
        //vector cross-product between the start to goal vector and the current point to goal vector
        float cross = Math.abs(dx1*dy2 - dx2*dy1);

        return dx + dy + cross*0.001f;
    }

    /**
     * heuristic function for 8-direction (with diagonal direction) grid map
     */
    private static float heuristicDiagonal(Grid a, Grid b) {
        // Euclid distance from a to b
        float dx = Math.abs(a.getX() - b.getX());
        float dy = Math.abs(a.getY() - b.getY());
        return (dx + dy) + (1.4142f - 2) * Math.min(dx, dy);
    }

    /**
     * If your units can move at any angle, use Euclidean heuristic function
     */
    private static float heuristicEuclid(Grid a, Grid b) {
        // Euclid distance from a to b
        float dx = Math.abs(a.getX() - b.getX());
        float dy = Math.abs(a.getY() - b.getY());
        return (float) Math.sqrt(dx * dx + dy * dy);
    }

    public static boolean isDebug() {
        return debug;
    }

    public static void setDebug(boolean d) {
        debug = d;
    }
}
