package algorithm.sort.quicksort;

public class QuickSort {
    private static int CUTOFF = 10;

    /**
     * Quicksort algorithm.
     *
     * @param a an array of Comparable items.
     */
    public static <T extends Comparable<? super T>> void quicksort(T[] a) {
        quicksort(a, 0, a.length - 1);
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
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * Use insertion sort of the number of elements are less than cutoff.
     *
     * @param a     an array of Comparable items.
     * @param left  the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    private static <T extends Comparable<? super T>> void quicksort(T[] a, int left, int right) {
        if (left + CUTOFF <= right) {
            T pivot = median3(a, left, right);

            // Begin partitioning
            int i = left, j = right - 1;
            for (; ; ) {
                while (a[++i].compareTo(pivot) < 0) {
                }
                while (a[--j].compareTo(pivot) > 0) {
                }
                if (i < j)
                    swapReferences(a, i, j);
                else
                    break;
            }

            swapReferences(a, i, right - 1); // Restore pivot

            quicksort(a, left, i - 1); // Sort small elements
            quicksort(a, i + 1, right); // Sort large elements
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
