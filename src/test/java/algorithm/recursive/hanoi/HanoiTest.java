package algorithm.recursive.hanoi;

import org.junit.Test;

import static org.junit.Assert.*;

public class HanoiTest {
    @Test
    public void hanoi() throws Exception {
        Hanoi hanoi = new Hanoi();

        System.out.println("=====Solve Hanoi Towers with 3 disks=====");
        hanoi.hanoi(3, 'A', 'B', 'C');

        System.out.println("=====Solve Hanoi Towers with 7 disks=====");
        hanoi.hanoi(7, 'A', 'B', 'C');
    }

}