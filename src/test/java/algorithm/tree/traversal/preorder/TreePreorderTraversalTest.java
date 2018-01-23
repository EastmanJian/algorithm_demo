package algorithm.tree.traversal.preorder;

import org.junit.Test;

import java.io.File;

public class TreePreorderTraversalTest {

    @Test
    public void preorderTraversal() throws Exception {
        String treeFileName = "algorithm/tree/traversal/preorder/demoTree.txt";
        Tree tree = Tree.createTreeFromFile(Tree.class.getResource("/").getPath() + File.separator +  treeFileName);
        tree.printTree();
    }

}