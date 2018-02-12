package algorithm.sort.insertion;

public class InsertionSort {
    /**
     * Simple insertion sort.
     *
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
        int j;

        for (int p = 1; p < a.length; p++) {
            T tmp = a[p];
            for (j = p; j > 0 && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }
}
