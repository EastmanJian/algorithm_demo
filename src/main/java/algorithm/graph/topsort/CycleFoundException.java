package algorithm.graph.topsort;

public class CycleFoundException extends Exception {
    public CycleFoundException() {

    }

    public CycleFoundException(String msg) {
        super(msg);
    }
}
