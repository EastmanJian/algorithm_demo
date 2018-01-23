package algorithm.tree.binary.traversal.inorder;

public class BinaryNode {
    private String nodeName; // The data in the node
    private BinaryNode leftChild; // Left child
    private BinaryNode rightChild; // Right child
    int depth;

    public BinaryNode (String name) {
        this.nodeName = name;
    }

    public BinaryNode (String name, int depth) {
        this.nodeName = name;
        this.depth = depth;
    }

    public BinaryNode (String name, BinaryNode left, BinaryNode right) {
        this.nodeName = name;
        this.leftChild = left;
        this.rightChild = right;
    }

    public String toString() {
        return this.nodeName;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public BinaryNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(BinaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(BinaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }
}
