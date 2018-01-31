package algorithm.tree.binary.search;

public class BinaryNode<T> {

    BinaryNode(T theElement) {
        this(theElement, null, null);
    }

    BinaryNode(T theElement, BinaryNode<T> lt, BinaryNode<T> rt) {
        element = theElement;
        left = lt;
        right = rt;
    }

    T element; // The data in the node
    BinaryNode<T> left; // Left child
    BinaryNode<T> right; // Right child

    public String toString() {
        return element.toString();
    }
}