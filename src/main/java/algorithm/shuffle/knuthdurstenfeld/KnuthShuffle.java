package algorithm.shuffle.knuthdurstenfeld;


public class KnuthShuffle {
    public static void knuth(int[] a) {
        int j, temp;
        for (int i=a.length-1 ; i>=0; i--) {
            j = (int)(Math.random()*i);
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
            System.out.println("Debug: Switched item " + i + " and " + j);
        }
    }
}
