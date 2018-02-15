package algorithm.hashing.separatechaining;

import org.junit.Test;

import static org.junit.Assert.*;

public class SeparateChainingHashTableTest {
    @Test
    public void testHashTable() throws Exception {
        SeparateChainingHashTable<Integer> scht = new SeparateChainingHashTable<>(10);
        for (int i=0; i<15; i++) {
            scht.insert((int)(Math.random()*100));
        }
        System.out.println("=====The SeparateChainingHashTable data structure after some insertion=====");
        scht.printDataStructure();
    }

}