package algorithm.sort.quickselect;

import algorithm.sort.quicksort.QuickSort;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickSelectTest {
    @Test
    public void quickSelect() throws Exception {
        //generate a random array to be selected
        Integer[] a = new Integer[100];
        for (int i=0; i<a.length; i++) {
            a[i] = (int)(Math.random() * 90);
        }

        System.out.print("Array before selected:");
        for (int i=0; i<a.length; i++) System.out.print(a[i] + " ");
        System.out.println();

        int k = 10;
        int selected = QuickSelect.quickSelect(a, k);
        System.out.println("The " + k + "th smallest element is " + selected);

        System.out.print("Array after selected:");
        for (int i=0; i<a.length; i++) System.out.print(a[i] + " ");
        System.out.println();

        QuickSort.quicksort(a);
        System.out.print("Array after sorted:");
        for (int i=0; i<a.length; i++) System.out.print(a[i] + " ");
        System.out.println();

    }

}