package algorithm.tree.traversal.preorder;

class TreeNode {
    private String nodeName;
    private TreeNode firstChild;
    private TreeNode nextSibling;
    private int depth;

    public TreeNode (String nodeName, int depth) {
        this.nodeName = nodeName;
        this.depth = depth;
    }

    public TreeNode (String nodeName) {
        this.nodeName = nodeName;
        this.depth = -1;
    }

    public String toString () {
        return this.nodeName;
    }

    /*
     * Getters and Setters
     */

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public TreeNode getFirstChild() {
        return firstChild;
    }

    public void setFirstChild(TreeNode firstChild) {
        this.firstChild = firstChild;
    }

    public TreeNode getNextSibling() {
        return nextSibling;
    }

    public void setNextSibling(TreeNode nextSibling) {
        this.nextSibling = nextSibling;
    }
}
