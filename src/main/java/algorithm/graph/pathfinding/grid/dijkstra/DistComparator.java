package algorithm.graph.pathfinding.grid.dijkstra;


import algorithm.graph.pathfinding.grid.dijkstra.Graph.Grid;

import java.util.Comparator;

public class DistComparator implements Comparator<Grid> {
    public int compare(Grid a, Grid b) {
        return (int)((a.getDist() - b.getDist()) * 100);
    }
}
