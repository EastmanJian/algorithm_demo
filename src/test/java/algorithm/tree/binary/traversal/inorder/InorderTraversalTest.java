package algorithm.tree.binary.traversal.inorder;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class InorderTraversalTest {
    @Test
    public void printExpression() throws Exception {
        String treeFileName = "algorithm/tree/binary/traversal/inorder/expressionTree.txt";
        BinaryTree tree = BinaryTree.createTreeFromFile(BinaryTree.class.getResource("/").getPath() + File.separator +  treeFileName);
        tree.printTree();

        InorderTraversal.printExpression(tree.getRoot());
        System.out.println();
    }

}