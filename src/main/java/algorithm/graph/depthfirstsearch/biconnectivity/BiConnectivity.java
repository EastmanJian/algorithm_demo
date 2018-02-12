package algorithm.graph.depthfirstsearch.biconnectivity;

public class BiConnectivity {
    public static void findArticulationPoint(Vertex v) {
        counter = 1;
        findArt(v);
        testRoot(v);
    }

    private static int counter;

    private static void findArt(Vertex v) {
        v.setVisited(true);
        v.setNum(counter);
        v.setLow(counter);  // Rule 1
        counter++;

        for (Vertex w : v.getAdj()) {
            if (!w.isVisited()) { // Forward edge
                w.setParent(v);
                findArt(w);
                if (w.getLow() >= v.getNum() && v.getNum() != 1)
                    System.out.println(v + " is an articulation point");
                v.setLow(Math.min(v.getLow(), w.getLow())); // Rule 3
            } else if (v.getParent() != w) {// Back edge

                v.setLow(Math.min(v.getLow(), w.getNum())); // Rule 2
                if (v.getNum() > w.getNum()) System.out.println("Back Edge: " + v + "-->" + w);
            }
        }
    }

    private static void testRoot(Vertex r) {
        int childCnt = 0;
        for (Vertex w : r.getAdj())
            if (w.getParent() == r) childCnt++;
        if (childCnt > 1) System.out.println(r + " is an articulation point");
    }

}
