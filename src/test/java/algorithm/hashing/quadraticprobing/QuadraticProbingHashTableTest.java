package algorithm.hashing.quadraticprobing;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuadraticProbingHashTableTest {
    @Test
    public void testHashTable() throws Exception {
        QuadraticProbingHashTable<Integer> qpht = new QuadraticProbingHashTable<>(10);
        for (int i=0; i<5; i++) {
            qpht.insert((int)(Math.random()*100));
        }
        System.out.println("=====The QuadraticProbingHashTable data structure after some insertion=====");
        qpht.printDataStructure();

        System.out.println("=====Insert more elements to trigger rehash=====");
        for (int i=0; i<5; i++) {
            qpht.insert((int)(Math.random()*100));
        }
        qpht.printDataStructure();
    }

}