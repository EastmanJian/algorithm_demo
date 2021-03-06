package algorithm.graph.shortestpath;

import java.util.LinkedList;

public class Vertex
{
    String     name;   // Vertex name
    LinkedList adj;    // Adjacent vertices
    int        dist;   // Cost
    Vertex     path;   // Previous vertex on shortest path

    public Vertex( String nm )
    { name = nm; adj = new LinkedList( ); reset( ); }

    public void reset( )
    { dist = Graph.INFINITY; path = null; }
}