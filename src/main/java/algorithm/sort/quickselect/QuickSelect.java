package algorithm.sort.quickselect;

public class QuickSelect {
    private static int CUTOFF = 10;


    public static <T extends Comparable<? super T>> T quickSelect(T[] a, int k) {
        quickSelect(a, 0, a.length - 1, k);
        return a[k-1];
    }

    /**
     * Return median of left, center, and right.
     * Order these and put center (as the pivot) at right - 1.
     */
    private static <T extends Comparable<? super T>> T median3(T[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[center].compareTo(a[left]) < 0)
            swapReferences(a, left, center);
        if (a[right].compareTo(a[left]) < 0)
            swapReferences(a, left, right);
        if (a[right].compareTo(a[center]) < 0)
            swapReferences(a, center, right);

        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[right - 1];
    }



    /**
     * Internal selection method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * Places the kth smallest item in a[k-1].
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     * @param k     the desired index (1 is minimum) in the entire array.
     */
    private static <T extends Comparable<? super T>> void quickSelect(T[] a, int left, int right, int k) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {}
                while (a[--j].compareTo(pivot) > 0) {}
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            swapReferences(a, i, right - 1); // Restore pivot

            if (k <= i)
                quickSelect(a, left, i - 1, k);
            else if (k > i + 1)
                quickSelect(a, i + 1, right, k);
        } else // Do an insertion sort on the subarray
            insertionSort(a, left, right);
    }

    private static <T extends Comparable<? super T>> void swapReferences(T[] a, int x, int y) {
        T tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int left, int right) {
        int j;

        for (int p = left + 1; p < right + 1; p++) {
            T tmp = a[p];
            for (j = p; j > left && tmp.compareTo(a[j - 1]) < 0; j--)
                a[j] = a[j - 1];
            a[j] = tmp;
        }
    }

}
