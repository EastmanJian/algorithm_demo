package algorithm.sort.quicksort;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSortTest {
    @Test
    public void quicksort() throws Exception {
        //generate a random array to be sorted
        Integer[] a = new Integer[100];
        for (int i=0; i<a.length; i++) {
            a[i] = (int)(Math.random() * 90);
        }

        System.out.print("Before sort:");
        for (int i=0; i<a.length; i++) System.out.print(a[i] + " ");
        System.out.println();

        QuickSort.quicksort(a);
        System.out.print("After sort:");
        for (int i=0; i<a.length; i++) System.out.print(a[i] + " ");
    }

}