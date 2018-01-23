package algorithm.tree.traversal.postorder;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TreePostorderTraversalTest {
    @Test
    public void testPostorderTraversal() throws Exception {
        String treeFileName = "algorithm/tree/traversal/postorder/demoTree.txt";
        Tree tree = Tree.createTreeFromFile(Tree.class.getResource("/").getPath() + File.separator +  treeFileName);
        tree.printTree();

        System.out.println("The total size of the tree is " + new PostOrderTraversal(tree).size(tree.getRoot()));
    }

}