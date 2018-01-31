package algorithm.tree.binary.avl;

import org.junit.Test;

import static org.junit.Assert.*;

public class AvlTreeTest {
    @Test
    public void insert() throws Exception {
        AvlTree<Integer> tree = new AvlTree<>();
        Integer[] data = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
            System.out.println("\nAfter insert " + data[i]);
            tree.printTree();
        }
    }

}