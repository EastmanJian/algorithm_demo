package algorithm.shuffle.knuthdurstenfeld;

import org.junit.Test;

public class KnuthShuffleTest {
    @Test
    public void knuth() throws Exception {
        Integer[] numList = new Integer[20];
        for (int i=0; i < numList.length; i++) {
            numList[i] = i + 1;
        }

        System.out.print("array before shuffle: ");
        for (int n: numList) System.out.print(n + " ");
        System.out.println();
        KnuthShuffle.shuffle(numList);
        System.out.print("array after shuffle: ");
        for (int n: numList) System.out.print(n + " ");
        System.out.println();
    }

}