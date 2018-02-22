package algorithm.heap.binary;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryHeapTest {
    @Test
    public void testHeap() throws Exception {
        Integer[] intArr = {13,21,16,24,31,19,68,65,26,32};
        BinaryHeap bh = new BinaryHeap(intArr);
        System.out.println("=====initiate a heap from an array to test insert=====");
        bh.printHeapTree();

        bh.insert(14);
        System.out.println("=====after insert 14 into the heap=====");
        bh.printHeapTree();


        Integer[] intArr1 = {13,14,16,19,21,19,68,65,26,32,31};
        bh = new BinaryHeap(intArr1);
        System.out.println("=====initiate a heap from an array to test deleteMin=====");
        bh.printHeapTree();

        int min = (int)bh.deleteMin();
        System.out.println("=====after deleteMin of the heap=====");
        bh.printHeapTree();
        System.out.println("min=" + min);
    }

}