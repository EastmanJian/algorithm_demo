package algorithm.graph.pathfinding.grid.breadthfirst;

import algorithm.shuffle.knuthdurstenfeld.KnuthShuffle;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.PrintGraphType.*;
import static algorithm.graph.pathfinding.grid.breadthfirst.Graph.Flag.*;


public class Graph {
    static public int INFINITY = 99;
    private boolean debug = false;
    private boolean allowDiagonal = false; //whether allow to walk in diagonal direction
    private Grid[][] graph;

    public enum PrintGraphType {ORIGIN, DISTANCE, ALL_PATH, SINGLE_PATH, X, Y}

    public enum Flag {START, DESTINATION, ON_PATH}

    public class Grid {
        private int x, y;                 //the coordinate of this grid in the graph
        private int cost;                //the cost walk through this grid
        private int dist = INFINITY;     // distance from the starting grid
        private Grid path;          // the previous grid on the unweighted shortest path
        private Flag flag;   // a flag indicates if the grid is a start point, destination point, or a grid on the path

        public Grid(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dist = INFINITY;
            this.flag = null;
        }

        public int getDist() {
            return dist;
        }

        public void setDist(int dist) {
            this.dist = dist;
        }

        public Grid getPath() {
            return path;
        }

        public void setPath(Grid path) {
            this.path = path;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Flag getFlag() {
            return flag;
        }

        public void setFlag(Flag flag) {
            this.flag = flag;
        }

        public String toString() {
            return "(" + x + ", " + y +")";
        }

        public List<Grid> getNeighbours() {
            List<Grid> neighbours = new ArrayList<>();
            //up
            if (y > 0 && graph[y - 1][x].getCost() != INFINITY) neighbours.add(graph[y - 1][x]);
            //right
            if (x < getWidth() - 1 && graph[y][x + 1].getCost() != INFINITY) neighbours.add(graph[y][x + 1]);
            //down
            if (y < getHeight() - 1 && graph[y + 1][x].getCost() != INFINITY) neighbours.add(graph[y + 1][x]);
            //left
            if (x > 0 && graph[y][x - 1].getCost() != INFINITY) neighbours.add(graph[y][x - 1]);

            if (allowDiagonal) {
                //up-left
                if (y > 0 && x > 0 && graph[y - 1][x - 1].getCost() != INFINITY) neighbours.add(graph[y - 1][x - 1]);
                //up-right
                if (y > 0 && x < getWidth() - 1 && graph[y - 1][x + 1].getCost() != INFINITY)
                    neighbours.add(graph[y - 1][x + 1]);
                //left-down
                if (y < getHeight() - 1 && x > 0 && graph[y + 1][x - 1].getCost() != INFINITY)
                    neighbours.add(graph[y + 1][x - 1]);
                //right-down
                if (y < getHeight() - 1 && x < getWidth() - 1 && graph[y + 1][x + 1].getCost() != INFINITY)
                    neighbours.add(graph[y + 1][x + 1]);
            }

            //Optional - return the neighbours in random order in order to make the path more natural.
            Grid[] array = neighbours.toArray(new Grid[0]);
            KnuthShuffle.shuffle(array);
            neighbours = Arrays.asList(array);
            return neighbours;
        }
    }



    public int getWidth() {
        return graph[0].length;
    }

    public int getHeight() {
        return graph.length;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isAllowDiagonal() {
        return allowDiagonal;
    }

    public void setAllowDiagonal(boolean allowDiagonal) {
        this.allowDiagonal = allowDiagonal;
    }

    public Grid getGrid(int x, int y) {
        return graph[y][x];
    }

    public List<Grid> getPath(Grid dest) {
        List<Grid> path = new ArrayList<>();
        path.add(dest);
        Grid comeFrom = dest.getPath();
        while (comeFrom != null) {
            if (comeFrom.getFlag() != START) comeFrom.setFlag(ON_PATH);
            path.add(comeFrom);
            comeFrom = comeFrom.getPath();

        }
        return path;
    }

    public void printGraph(PrintGraphType type) {
        int width = this.getWidth();
        int height = this.getHeight();
        if (isDebug()) System.out.println("Debug - width=" + width + ", height=" + height);

        StringBuilder sb = new StringBuilder();
        sb.setLength(width * 2);
        String upDownBorder = "+-" + sb.toString().replace("\u0000", "-") + "-+";
        System.out.println(upDownBorder);
        for (int y = 0; y < height; y++) {
            sb = new StringBuilder();
            sb.append("| ");
            for (int x = 0; x < width; x++) {
                sb.append(printGrid(type, graph[y][x]));
            }
            sb.append(" |");
            System.out.println(sb);
        }
        System.out.println(upDownBorder);
    }

    private String printGrid(PrintGraphType type, Grid grid) {
        String gridStr = "  ";
        if (grid.getCost() == INFINITY) {
            gridStr = "█";
        } else if (grid.getFlag() == START) {
            gridStr = "●";
        } else if (grid.getFlag() == DESTINATION) {
            gridStr = "★";
        } else {
            switch (type) {
                case ORIGIN:
                    gridStr = "  ";
                    break;
                case DISTANCE:
                    if (grid.getDist() == INFINITY) {
                        gridStr = "  ";
                    } else {
                        gridStr = String.format("%2d", grid.getDist());
                    }
                    break;
                case ALL_PATH:
                    gridStr = "  ";
                    if (grid.getPath() != null) {
                        //up
                        if (grid.getPath().getY() == grid.getY() - 1 && grid.getPath().getX() == grid.getX())
                            gridStr = "↑";
                        //right
                        if (grid.getPath().getX() == grid.getX() + 1 && grid.getPath().getY() == grid.getY())
                            gridStr = "→";
                        //down
                        if (grid.getPath().getY() == grid.getY() + 1 && grid.getPath().getX() == grid.getX())
                            gridStr = "↓";
                        //left
                        if (grid.getPath().getX() == grid.getX() - 1 && grid.getPath().getY() == grid.getY())
                            gridStr = "←";
                        //up-left
                        if (grid.getPath().getX() == grid.getX() - 1 && grid.getPath().getY() == grid.getY() - 1)
                            gridStr = "↖";
                        //up-right
                        if (grid.getPath().getX() == grid.getX() + 1 && grid.getPath().getY() == grid.getY() - 1)
                            gridStr = "↗";
                        //left-down
                        if (grid.getPath().getX() == grid.getX() - 1 && grid.getPath().getY() == grid.getY() + 1)
                            gridStr = "↙";
                        //right-down
                        if (grid.getPath().getX() == grid.getX() + 1 && grid.getPath().getY() == grid.getY() + 1)
                            gridStr = "↘";
                    }
                    break;
                case SINGLE_PATH:
                    if (grid.getFlag() == ON_PATH) gridStr = "○";
                    break;
                case X:
                    gridStr = String.format("%2d", grid.getX());
                    break;
                case Y:
                    gridStr = String.format("%2d", grid.getY());
                    break;
                default:
                    gridStr = "  ";
            }
        }
        return gridStr;
    }

    /**
     * Create the graph by reading a file.
     * The file should contain a matrix represents the grids in the graph. Each has is number of cost.
     *
     * @param fileName - the file represent the graph
     * @return - the graph
     */
    static public Graph createGraphFromFile(String fileName) {
        Graph g = new Graph();
        try {
            FileReader fin = new FileReader(fileName);
            BufferedReader graphFile = new BufferedReader(fin);

            // Read the first line to identify with width of the graph and create the first line of grids
            String line = graphFile.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int width = st.countTokens();
            Grid[] gridLine = new Grid[width];
            int y = 0;
            for (int x = 0; x < width; x++) {
                gridLine[x] = g.new Grid(x, y, Integer.valueOf(st.nextToken()));
            }
            List<Grid[]> gridLineArray = new ArrayList<>();
            gridLineArray.add(gridLine);

            //read the rest of lines
            while ((line = graphFile.readLine()) != null) {
                st = new StringTokenizer(line);
                if (st.countTokens() != width) throw new Exception();
                gridLine = new Grid[width];
                y++;
                for (int x = 0; x < width; x++) {
                    gridLine[x] = g.new Grid(x, y, Integer.valueOf(st.nextToken()));
                }
                gridLineArray.add(gridLine);
            }

            int height = gridLineArray.size();
            g.graph = new Grid[height][];
            for (y = 0; y < height; y++) {
                g.graph[y] = gridLineArray.get(y);
            }

        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

        return g;
    }

}
