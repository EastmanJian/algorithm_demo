package algorithm.hashing.quadraticprobing;

import java.math.BigInteger;

public class QuadraticProbingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 11;

    private HashEntry<T>[] array; // The array of elements
    private int currentSize; // The number of occupied cells

    /**
     * Construct the hash table.
     */
    public QuadraticProbingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size the approximate initial size.
     */
    public QuadraticProbingHashTable(int size) {
        allocateArray(size);
        makeEmpty();
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++)
            array[i] = null;
    }


    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains(T x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }


    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     *
     * @param x the item to insert.
     */
    public void insert(T x) { // Insert x as active
        int currentPos = findPos(x);
        if (isActive(currentPos))
            return;

        array[currentPos] = new HashEntry<>(x, true);

        // Rehash
        if (++currentSize > array.length / 2)
            rehash();
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     */
    public void remove(T x) {
        int currentPos = findPos(x);
        if (isActive(currentPos))
            array[currentPos].isActive = false;
    }

    public void printDataStructure() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                System.out.println("array[" + i + "] = null");
            } else {
                System.out.println("array[" + i + "] = " + array[i].element
                        + "(" + (array[i].isActive ? "active" : "inactive") + ")");
            }
        }
    }


    private static class HashEntry<T> {
        public T element; // the element
        public boolean isActive; // false if marked deleted

        public HashEntry(T e) {
            this(e, true);
        }

        public HashEntry(T e, boolean i) {
            element = e;
            isActive = i;
        }
    }


    /**
     * Internal method to allocate array.
     *
     * @param arraySize the size of the array.
     */
    private void allocateArray(int arraySize) {
        array = new HashEntry[nextPrime(arraySize)];
    }

    /**
     * Method that performs quadratic probing resolution in half-empty table.
     *
     * @param x the item to search for.
     * @return the position where the search terminates. The position might contain the element already, or it's
     * empty (null) for insertion.
     */
    private int findPos(T x) {
        int offset = 1;
        int currentPos = myhash(x);

        while (array[currentPos] != null && !array[currentPos].element.equals(x)) { //detect collision
            System.out.print("Debug: Collision detected while findPos(" + x + "), position=" + currentPos);
            currentPos += offset; // Compute ith probe
            System.out.println(", offset position=" + currentPos);
            offset += 2; //because (k+1)^2 - k^2= 2k+1 is the offset, k=0,1,2,..., hence each diff of offset is 2
            if (currentPos >= array.length) currentPos -= array.length; //mod operation
        }

        return currentPos;
    }

    /**
     * Return true if currentPos exists and is active.
     *
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active. false if currentPos is empty or inactive.
     */
    private boolean isActive(int currentPos) {
        return array[currentPos] != null && array[currentPos].isActive;
    }

    /**
     * Rehashing for quadratic probing hash table.
     */
    private void rehash() {
        HashEntry<T>[] oldArray = array;

        System.out.print("Debug: rehash, array.length resize from " + array.length);
        // Create a new double-sized, empty table
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;
        System.out.println(" to " + array.length + ".");

        // Copy table over
        for (int i = 0; i < oldArray.length; i++)
            if (oldArray[i] != null && oldArray[i].isActive)
                insert(oldArray[i].element);
    }

    private int myhash(T x) {
        int hashVal = x.hashCode();

        hashVal %= array.length;
        if (hashVal < 0)
            hashVal += array.length;

        return hashVal;
    }

    private static int nextPrime(int n) {
        BigInteger bi = BigInteger.valueOf((long) n);
        return bi.nextProbablePrime().intValue();
    }
}