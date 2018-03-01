package algorithm.recursive.hanoi;

import org.junit.Test;

import static org.junit.Assert.*;

public class HanoiVisualTest {
    @Test
    public void solveHanoi() throws Exception {
        int n = 6;
        System.out.println("=====Solve Hanoi Towers with " + n + " disks=====");
        HanoiVisual hanoi = new HanoiVisual(n, 100);
        hanoi.printRods();
        System.out.println("Initial status\n");
        Thread.sleep(1000);
        hanoi.solveHanoi();

    }

}