package algorithm.recursive.hanoi;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class HanoiVisual extends Hanoi {
    private int step = 0;
    private int n; //number of disks at the origin rod
    private char origin, assist, destination; //the name of the rods.
    private int DISPLAY_PAUSE_MS = 500;
    private Map<Character, Stack<Integer>> rods; //a collection consist of three rods, which are represented by stacks.

    public HanoiVisual(int n) {
        this(n,'A','B','C',500);
    }

    public HanoiVisual(int n, int displayPauseMs) {
        this(n,'A','B','C', displayPauseMs);
    }

    public HanoiVisual(int n, char origin, char assist, char destination, int displayPauseMs) {
        this.n = n;
        this.origin = origin;
        this.assist = assist;
        this.destination = destination;
        this.DISPLAY_PAUSE_MS = displayPauseMs;
        Stack<Integer> originRod = new Stack<>();
        Stack<Integer> assistRod = new Stack<>();
        Stack<Integer> destinationRod = new Stack<>();
        rods = new HashMap<>();
        rods.put(origin, originRod);
        rods.put(assist, assistRod);
        rods.put(destination, destinationRod);
        for (int i = n; i > 0; i--) {
            originRod.push(i);
        }

    }

    public void solveHanoi() {
        hanoi(n, origin, assist, destination);
    }

    public void move(char origin, char destination) {
        int disk = rods.get(origin).pop();
        rods.get(destination).push(disk);
        printRods();
        step++;
        System.out.println("Step " + step + ": move a disk from " + origin + " to " + destination + ".\n");
        try {
            Thread.sleep(DISPLAY_PAUSE_MS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printRods() {
        for (int level = n; level > 0; level--) {
            System.out.println(visualLevel(origin, level) + " | "
                    + visualLevel(assist, level) + " | "
                    + visualLevel(destination, level));
        }
    }

    private String visualLevel(char rodName, int lev) {
        String result;

        int height = rods.get(rodName).size();
        if (lev > height) {
            StringBuilder sb = new StringBuilder();
            sb.setLength(n * 2);
            result = sb.toString().replace("\u0000", " ");
        } else {
            int diskSize = rods.get(rodName).get(lev - 1);
            StringBuilder spaces = new StringBuilder();
            spaces.setLength(n - diskSize);
            String span = spaces.toString().replace("\u0000", " ");
            StringBuilder disk = new StringBuilder();
            disk.setLength(diskSize * 2);
            String diskView = disk.toString().replace("\u0000", "*");
            result = span + diskView + span;
        }
        return result;
    }


}