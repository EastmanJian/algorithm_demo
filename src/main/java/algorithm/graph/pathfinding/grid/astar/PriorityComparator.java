package algorithm.graph.pathfinding.grid.astar;


import algorithm.graph.pathfinding.grid.astar.Graph.Grid;

import java.util.Comparator;

public class PriorityComparator implements Comparator<Grid> {
    public int compare(Grid a, Grid b) {
        return (int)((a.getPriority() - b.getPriority()) * 100);
    }
}
