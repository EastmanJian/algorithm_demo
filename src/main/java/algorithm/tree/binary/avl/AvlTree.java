package algorithm.tree.binary.avl;

public class AvlTree<T extends Comparable<? super T>> {

    private AvlNode<T> root;
    private static String NODE_TYPE_ROOT = "[root]";
    private static String NODE_TYPE_LEFT = "[L]";
    private static String NODE_TYPE_RIGHT = "[R]";
    private static String NODE_NULL = "(null)";

    public AvlTree() {
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

    public void inorderTraversal() {
        inorder(root);
    }

    /**
     * Return the height of node t, or -1, if null.
     */
    private int height(AvlNode<T> t) {
        return t == null ? -1 : t.height;
    }

    /**
     * Internal method to find an item in a subtree.
     *
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return true if the item is found; false otherwise.
     */
    private boolean contains(T x, AvlNode<T> t) {
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
    private AvlNode<T> findMin(AvlNode<T> t) {
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
    private AvlNode<T> findMax(AvlNode<T> t) {
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
    private AvlNode<T> insert(T x, AvlNode<T> t) {
        if (t == null)
            return new AvlNode<>(x, null, null);

        int compareResult = x.compareTo(t.element);

        if (compareResult < 0)
            t.left = insert(x, t.left);
        else if (compareResult > 0)
            t.right = insert(x, t.right);
        else
            ; // Duplicate; do nothing
        return balance(t);
    }

    private static final int ALLOWED_IMBALANCE = 1;

    // Assume t is either balanced or within one of being balanced
    private AvlNode<T> balance(AvlNode<T> t) {
        if (t == null)
            return t;

        if (height(t.left) - height(t.right) > ALLOWED_IMBALANCE)
            if (height(t.left.left) >= height(t.left.right))
                t = rotateWithLeftChild(t);
            else
                t = doubleWithLeftChild(t);
        else if (height(t.right) - height(t.left) > ALLOWED_IMBALANCE)
            if (height(t.right.right) >= height(t.right.left))
                t = rotateWithRightChild(t);
            else
                t = doubleWithRightChild(t);

        t.height = Math.max(height(t.left), height(t.right)) + 1;
        return t;
    }

    /**
     * Rotate binary tree node with left child.
     * For AVL trees, this is a single rotation for case 1:
     * An insertion into the left subtree of the left child of α, where α is the node that must be rebalanced.
     * Update heights, then return new root.
     */
    private AvlNode<T> rotateWithLeftChild(AvlNode<T> k2) {
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max(height(k2.left), height(k2.right)) + 1;
        k1.height = Math.max(height(k1.left), k2.height) + 1;
        return k1;
    }

    /**
     * Rotate binary tree node with right child.
     * For AVL trees, this is a single rotation for case 4:
     * An insertion into the right subtree of the right child of α.
     * Update heights, then return new root.
     */
    private AvlNode<T> rotateWithRightChild(AvlNode<T> k1) {
        AvlNode<T> k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        k1.height = Math.max(height(k1.left), height(k1.right)) + 1;
        k2.height = Math.max(k1.height, height(k2.right)) + 1;
        return k2;
    }

    /**
     * Double rotate binary tree node: first left child (k1)
     * with its right child (k2); then node k3 with new left child (k2).
     * For AVL trees, this is a double rotation for case 2:
     *     An insertion into the right subtree of the left child of α.
     * Update heights, then return new root.
     */
    private AvlNode<T> doubleWithLeftChild(AvlNode<T> k3) {
        k3.left = rotateWithRightChild(k3.left);
        return rotateWithLeftChild(k3);
    }

    /**
     * Double rotate binary tree node: first right child (k3)
     * with its left child (k2); then node k1 with new right child (k2).
     * For AVL trees, this is a double rotation for case 3:
     *     An insertion into the left subtree of the right child of α.
     * Update heights, then return new root.
     */
    private AvlNode<T> doubleWithRightChild(AvlNode<T> k1) {
        k1.right = rotateWithLeftChild(k1.right);
        return rotateWithRightChild(k1);
    }

    /**
     * Internal method to remove from a subtree.
     *
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private AvlNode<T> remove(T x, AvlNode<T> t) {
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
        return balance(t);
    }

    /**
     * Internal method to print the tree.
     * Using a preorder traversal algorithm. (root -> right -> left)
     *
     * @param node   the root node of the tree to print
     * @param prefix drawing the edges for printing the tree
     * @param type   the type description of the node
     */
    private void printTree(AvlNode node, String prefix, String type) {
        System.out.println(prefix + type + node);
        AvlNode leftChild = node.left;
        AvlNode rightChild = node.right;
        prefix = prefix.replace("├", "│").replace("─", " ").replace("└", " ");
        String newPrefix;
        newPrefix = " ├─ ";
        if (rightChild != null) {
            printTree(rightChild, prefix + newPrefix, NODE_TYPE_RIGHT);
        } else if (rightChild == null && leftChild != null) {
            System.out.println(prefix + newPrefix + NODE_TYPE_RIGHT + NODE_NULL);
        }
        newPrefix = " └─ ";
        if (leftChild != null) {
            printTree(leftChild, prefix + newPrefix, NODE_TYPE_LEFT);
        } else if (leftChild == null && rightChild != null) {
            System.out.println(prefix + newPrefix + NODE_TYPE_LEFT + NODE_NULL);
        }
    }

    /**
     * Inorder traversal
     * @param node
     */
    private void inorder(AvlNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node + " ");
            inorder(node.right);
        }
    }
}