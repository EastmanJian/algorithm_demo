package algorithm.shuffle.knuthdurstenfeld;


public class KnuthShuffle {
    public static <T> void shuffle(T[] a) {
        int j;
        T temp;
        for (int i=a.length-1 ; i>=0; i--) {
            j = (int)(Math.random()*i);
            temp = a[j];
            a[j] = a[i];
            a[i] = temp;
        }
    }
}
