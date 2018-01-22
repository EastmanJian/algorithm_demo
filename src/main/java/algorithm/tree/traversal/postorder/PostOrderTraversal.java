package algorithm.tree.traversal.postorder;

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
