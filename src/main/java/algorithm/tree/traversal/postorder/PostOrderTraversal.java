package algorithm.tree.traversal.postorder;

/**
 * Calculate the total size of the tree using a postorder traversal algorithm
 */
public class PostOrderTraversal {
    private Tree tree;
    public PostOrderTraversal (Tree tree) {
        this.tree = tree;
    }

    public int size(TreeNode node) {
        int totalSize = node.getSize();

        TreeNode child = node.getFirstChild();
        while (child != null) {
            totalSize += size(child);
            child = child.getNextSibling();
        }

        System.out.println(node + " - " + totalSize);
        return totalSize;
    }
}
