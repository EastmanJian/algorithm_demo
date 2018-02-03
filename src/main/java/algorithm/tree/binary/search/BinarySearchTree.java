package algorithm.tree.binary.search;

public class BinarySearchTree<T extends Comparable<? super T>> {

    private BinaryNode<T> root;
    private static String NODE_TYPE_ROOT = "[root]";
    private static String NODE_TYPE_LEFT = "[left]";
    private static String NODE_TYPE_RIGHT = "[right]";
    private static String NODE_NULL = "(null)";

    public BinarySearchTree() {
        root = null;
    }

    public void makeEmpty() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean contains(T x) {
        return contains(x, root);
    }

    public T findMin() {
        if (isEmpty()) throw new UnderflowException();
        return findMin(root).element;
    }

    public T findMax() {
        if (isEmpty()) throw new UnderflowException();
        return findMax(root).element;
    }

    public void insert(T x) {
        root = insert(x, root);
    }

    public void remove(T x) {
        root = remove(x, root);
    }

    public void printTree() {
        printTree(root, "", NODE_TYPE_ROOT);
    }

    public int height() {
        return height(root);
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return true if the item is found; false otherwise.
     */
    private boolean contains(T x, BinaryNode<T> t) {
        if (t == null)
            return false;

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            return contains(x, t.left);
        else if (compareResult > 0)
            return contains(x, t.right);
        else
            return true; // Match
    }

    /**
     * Internal method to find the smallest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<T> findMin(BinaryNode<T> t) {
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        return findMin(t.left);
    }

    /**
     * Internal method to find the largest item in a subtree.
     *
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<T> findMax(BinaryNode<T> t) {
        if (t != null)
            while (t.right != null)
                t = t.right;

        return t;
    }

    /**
     * Internal method to insert into a subtree.
     *
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> insert(T x, BinaryNode<T> t) {
        if (t == null)
            return new BinaryNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<T> remove(T x, BinaryNode<T> t) {
        if (t == null)
            return t; // Item not found; do nothing

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null) // Two children
        {
            t.element = findMin(t.right).element;
            t.right = remove(t.element, t.right);
        } else
            t = (t.left != null) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to print the tree.
     * Using a preorder traversal algorithm.
     *
     * @param node   the root node of the tree to print
     * @param prefix drawing the edges for printing the tree
     * @param type   the type description of the node
     */
    private void printTree(BinaryNode node, String prefix, String type) {
        System.out.println(prefix + type + node);
        BinaryNode leftChild = node.left;
        BinaryNode rightChild = node.right;
        prefix = prefix.replace("├", "│").replace("─", " ").replace("└", " ");
        String newPrefix;
        newPrefix = " ├─ ";
        if (leftChild != null) {
            printTree(leftChild, prefix + newPrefix, NODE_TYPE_LEFT);
        } else if (leftChild == null && rightChild != null) {
            System.out.println(prefix + newPrefix + NODE_TYPE_LEFT + NODE_NULL);
        }
        newPrefix = " └─ ";
        if (rightChild != null) {
            printTree(rightChild, prefix + newPrefix, NODE_TYPE_RIGHT);
        } else if (leftChild != null && rightChild == null) {
            System.out.println(prefix + newPrefix + NODE_TYPE_RIGHT + NODE_NULL);
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * Using a postorder traversal algorithm.
     *
     * @param t the node that roots the subtree.
     */
    private int height(BinaryNode<T> t) {
        if (t == null)
            return -1;
        else
            return 1 + Math.max(height(t.left), height(t.right));
    }

}