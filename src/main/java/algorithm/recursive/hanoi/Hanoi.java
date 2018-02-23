package algorithm.recursive.hanoi;

public class Hanoi {

    /**
     * Solve Hanoi Towers problem using a recursive algorithm.
     * The total number of steps is 2^n - 1.
     *
     * @param n           the number of disks
     * @param origin      the label of the original rod
     * @param assist      the label of the assistant rod
     * @param destination the label of the destination rod
     */
    public void hanoi(int n, char origin, char assist, char destination) {
        if (n == 1) {
            move(origin, destination);
        } else {
            hanoi(n - 1, origin, destination, assist);
            move(origin, destination);
            hanoi(n - 1, assist, origin, destination);
        }
    }

    public void move(char origin, char destination) {
        System.out.println("Move a disk from rod " + origin + " to rod " + destination + ".");
    }


}