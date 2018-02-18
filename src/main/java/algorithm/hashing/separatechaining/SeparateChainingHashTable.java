package algorithm.hashing.separatechaining;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;

public class SeparateChainingHashTable<T> {
    private static final int DEFAULT_TABLE_SIZE = 101;
    private List<T>[] theLists;
    private int currentSize;

    /**
     * Construct the hash table.
     */
    public SeparateChainingHashTable() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     *
     * @param size approximate table size.
     */
    public SeparateChainingHashTable(int size) {
        theLists = new LinkedList[nextPrime(size)];
        for (int i = 0; i < theLists.length; i++)
            theLists[i] = new LinkedList<>();
    }

    /**
     * Insert into the hash table. If the item is
     * already present, then do nothing.
     *
     * @param x the item to insert.
     */
    public void insert(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (!whichList.contains(x)) {
            whichList.add(x);

            // Rehash when load factor is greater than 1
            if (++currentSize > theLists.length)
                rehash();
        }
    }

    /**
     * Remove from the hash table.
     *
     * @param x the item to remove.
     */
    public void remove(T x) {
        List<T> whichList = theLists[myhash(x)];
        if (whichList.contains(x)) {
            whichList.remove(x);
            currentSize--;
        }
    }

    /**
     * Find an item in the hash table.
     *
     * @param x the item to search for.
     * @return true if x is not found.
     */
    public boolean contains(T x) {
        List<T> whichList = theLists[myhash(x)];
        return whichList.contains(x);
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        for (int i = 0; i < theLists.length; i++)
            theLists[i].clear();
        currentSize = 0;
    }

    /**
     * Rehashing for separate chaining hash table.
     */
    private void rehash() {
        List<T>[] oldLists = theLists;

        System.out.print("Debug: rehash, theLists.length resize from " + theLists.length);

        // Create new double-sized, empty table
        theLists = new List[nextPrime(2 * theLists.length)];
        for (int j = 0; j < theLists.length; j++)
            theLists[j] = new LinkedList<>();
        System.out.println(" to " + theLists.length + ".");

        // Copy table over
        currentSize = 0;
        for (int i = 0; i < oldLists.length; i++)
            for (T item : oldLists[i])
                insert(item);
    }

    /**
     * Scale the hash code into a suitable array index
     * @param x
     * @return
     */
    private int myhash(T x) {
        int hashVal = x.hashCode();

        hashVal %= theLists.length;
        if (hashVal < 0)
            hashVal += theLists.length;

        return hashVal;
    }

    private static int nextPrime(int n) {
        BigInteger bi = BigInteger.valueOf((long) n);
        return bi.nextProbablePrime().intValue();
    }

    public void printDataStructure() {
        for (int i = 0; i < theLists.length; i++) {
            System.out.print("theLists[" + i + "]");
            for (T element : theLists[i]) {
                System.out.print(" --> " + element);
            }
            System.out.println();
        }
    }
}