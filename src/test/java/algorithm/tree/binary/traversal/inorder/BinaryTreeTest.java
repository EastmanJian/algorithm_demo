package algorithm.tree.binary.traversal.inorder;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    @Test
    public void expressionTree() throws Exception {
        String treeFileName = "algorithm/tree/binary/traversal/inorder/expressionTree.txt";
        BinaryTree tree = BinaryTree.createTreeFromFile(BinaryTree.class.getResource("/").getPath() + File.separator +  treeFileName);
        tree.printTree();
    }

    @Test
    public void nonCompleteBinaryTree() throws Exception {
        String treeFileName = "algorithm/tree/binary/traversal/inorder/nonCompleteBinaryTree.txt";
        BinaryTree tree = BinaryTree.createTreeFromFile(BinaryTree.class.getResource("/").getPath() + File.separator +  treeFileName);
        tree.printTree();
    }

}