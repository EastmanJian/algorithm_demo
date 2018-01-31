package algorithm.tree.binary.search;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {
    @Test
    public void contains() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer[] data = {6, 2, 8, 1, 4, 3, 5};
        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
        }

        tree.printTree();

        System.out.println("The tree contains element 4? " + tree.contains(4));
    }

    @Test
    public void findMinMax() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        //randomly insert data into the tree
        for (int i = 0; i < 30; i++) {
            tree.insert((int) (Math.random() * 5000));
        }
        tree.printTree();
        System.out.println("Minimum element in the tree is " + tree.findMin());
        System.out.println("Maximum element in the tree is " + tree.findMax());
    }


    @Test
    public void insert() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        Integer[] data = {6, 2, 8, 1, 4, 3, 5};
        for (int i = 0; i < data.length; i++) {
            tree.insert(data[i]);
        }

        tree.printTree();
    }

    @Test
    public void remove() throws Exception {
        BinarySearchTree<Integer> tree = new BinarySearchTree<>();
        //randomly insert data into the tree,
        for (int i = 0; i < 300; i++) { //insert more times to fill continuous numbers in the tree
            tree.insert((int) (Math.random() * 20));
        }
        System.out.println("-----tree before remove-----");
        tree.printTree();
        Integer x = (int) (Math.random() * 20);
        System.out.println("Remove " + x);
        tree.remove(x);
        System.out.println("-----tree after remove-----");
        tree.printTree();
    }

}