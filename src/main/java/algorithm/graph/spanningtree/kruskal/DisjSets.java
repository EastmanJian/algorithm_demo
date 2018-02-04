package algorithm.graph.spanningtree.kruskal;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Disjoint Set Data Structure
 * @param <T>
 */
public class DisjSets<T> {

    private Map<T, T> s;

    /**
     * Construct the disjoint sets object.
     *
     * @param elements the disjoint sets.
     */
    public DisjSets(Collection<T> elements) {
        s = new HashMap<>();
        for (T e: elements) {
            s.put(e, null);
        }
    }


    /**
     * Union two disjoint sets.
     * and represent root of the set.
     *
     * @param root1 the root of set 1.
     * @param root2 the root of set 2.
     */
    public void union(T root1, T root2) {
        if (root1 != root2)
            s.put(root2, root1); //put the root2 tree under root1
    }

    /**
     * Perform a find.
     * Error checks omitted again for simplicity.
     *
     * @param e the element being searched for.
     * @return the root of the set containing e.
     */
    public T find(T e) {
        T result;
        if (s.get(e) == null) {
            result = e;
        } else {
            result = find(s.get(e));
            s.put(e, result); //compress the path
        }
        return result;
    }

}