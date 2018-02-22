package algorithm.heap.binary;

// BinaryHeap class
//
// CONSTRUCTION: with optional capacity (that defaults to 100)
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// Comparable deleteMin( )--> Return and remove smallest item
// Comparable findMin( )  --> Return smallest item
// boolean isEmpty( )     --> Return true if empty; else false
// boolean isFull( )      --> Return true if full; else false
// void makeEmpty( )      --> Remove all items
// ******************ERRORS********************************
// Throws ArrayIndexOutOfBoundsException if capacity exceeded

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
public class BinaryHeap {
    private static final int DEFAULT_CAPACITY = 100;

    private int currentSize;      // Number of elements in heap
    private Comparable[] array; // The heap array

    private static String NODE_TYPE_ROOT = "[root]";
    private static String NODE_TYPE_LEFT = "[L]";
    private static String NODE_TYPE_RIGHT = "[R]";
    private static String NODE_NULL = "(null)";

    /**
     * Construct the binary heap.
     */
    public BinaryHeap() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Construct the binary heap.
     *
     * @param capacity the capacity of the binary heap.
     */
    public BinaryHeap(int capacity) {
        currentSize = 0;
        array = new Comparable[capacity + 1];
    }

    /**
     * Construct the binary heap given an array of items.
     */
    public BinaryHeap(Comparable[] items) {
        currentSize = items.length;
        array = (Comparable[]) new Comparable[(currentSize + 2) * 11 / 10];

        int i = 1;
        for (Comparable item : items)
            array[i++] = item;
        buildHeap();
    }

    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     *
     * @param x the item to insert.
     * @throws ArrayIndexOutOfBoundsException if container is full.
     */
    public void insert(Comparable x) throws ArrayIndexOutOfBoundsException {
        if (isFull())
            throw new ArrayIndexOutOfBoundsException();

        // Percolate up
        int hole = ++currentSize;
        for (; hole > 1 && x.compareTo(array[hole / 2]) < 0; hole /= 2)
            array[hole] = array[hole / 2];
        array[hole] = x;
    }

    /**
     * Find the smallest item in the priority queue.
     *
     * @return the smallest item, or null, if empty.
     */
    public Comparable findMin() {
        if (isEmpty())
            return null;
        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     *
     * @return the smallest item, or null, if empty.
     */
    public Comparable deleteMin() {
        if (isEmpty())
            return null;

        Comparable minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    /**
     * Test if the priority queue is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Test if the priority queue is logically full.
     *
     * @return true if full, false otherwise.
     */
    public boolean isFull() {
        return currentSize == array.length - 1;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
    }


    public void printHeapTree() {
        printHeapTree(1, "", NODE_TYPE_ROOT);
    }

    /**
     * Internal method to percolate down in the heap.
     *
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        Comparable tmp = array[hole];

        for (; hole * 2 <= currentSize; hole = child) {
            child = hole * 2;
            if (child != currentSize &&
                    array[child + 1].compareTo(array[child]) < 0)
                child++;

            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }

        array[hole] = tmp;
    }

    /**
     * Internal method to print the heap tree.
     * Using a preorder traversal algorithm. (root -> right -> left)
     *
     * @param nodeIndex   the root node of the tree to print
     * @param prefix drawing the edges for printing the tree
     * @param type   the type description of the node
     */
    private void printHeapTree(int nodeIndex, String prefix, String type) {
        System.out.println(prefix + type + array[nodeIndex]);
        int leftChildIdx = nodeIndex * 2;
        int rightChildIdx = nodeIndex * 2 + 1;
        prefix = prefix.replace("├", "│").replace("─", " ").replace("└", " ");
        String newPrefix;
        newPrefix = " ├─ ";
        if (rightChildIdx <= currentSize) {
            printHeapTree(rightChildIdx, prefix + newPrefix, NODE_TYPE_RIGHT);
        } else if (rightChildIdx > currentSize && leftChildIdx <= currentSize) {
            System.out.println(prefix + newPrefix + NODE_TYPE_RIGHT + NODE_NULL);
        }
        newPrefix = " └─ ";
        if (leftChildIdx <= currentSize) {
            printHeapTree(leftChildIdx, prefix + newPrefix, NODE_TYPE_LEFT);
        } else if (leftChildIdx > currentSize && rightChildIdx <= currentSize) {
            System.out.println(prefix + newPrefix + NODE_TYPE_LEFT + NODE_NULL);
        }
    }

}
