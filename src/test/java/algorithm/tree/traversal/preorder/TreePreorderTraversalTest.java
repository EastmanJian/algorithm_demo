package algorithm.tree.traversal.preorder;

import org.junit.Test;

import java.io.File;

public class TreePreorderTraversalTest {

    @Test
    public void testPrintTree() throws Exception {
        TreeNode root = new TreeNode("usr", 0);
        Tree tree = new Tree(root);

        TreeNode mark = new TreeNode("mark");
        TreeNode alex = new TreeNode("alex");
        TreeNode bill = new TreeNode("bill");
        tree.addChild(root, mark);
        tree.addChild(root, alex);
        tree.addChild(root, bill);

        TreeNode book = new TreeNode("book");
        TreeNode markCourse = new TreeNode("course");
        TreeNode markJunk = new TreeNode("junk");
        tree.addChild(mark, book);
        tree.addChild(mark, markCourse);
        tree.addChild(mark, markJunk);

        TreeNode ch1r = new TreeNode("ch1.r");
        TreeNode ch2r = new TreeNode("ch2.r");
        TreeNode ch3r = new TreeNode("ch3.r");
        tree.addChild(book, ch1r);
        tree.addChild(book, ch2r);
        tree.addChild(book, ch3r);

        TreeNode cop3530 = new TreeNode("cop3530");
        tree.addChild(markCourse, cop3530);

        TreeNode fall = new TreeNode("fall");
        TreeNode spr = new TreeNode("spr");
        TreeNode sum = new TreeNode("sum");
        tree.addChild(cop3530, fall);
        tree.addChild(cop3530, spr);
        tree.addChild(cop3530, sum);

        TreeNode fall_sylr = new TreeNode("syl.r");
        tree.addChild(fall, fall_sylr);

        TreeNode spr_sylr = new TreeNode("syl.r");
        tree.addChild(spr, spr_sylr);

        TreeNode sum_sylr = new TreeNode("syl.r");
        tree.addChild(sum, sum_sylr);

        TreeNode alexJunk = new TreeNode("junk");
        tree.addChild(alex, alexJunk);

        TreeNode work = new TreeNode("work");
        TreeNode billCourse = new TreeNode("course");
        tree.addChild(bill, work);
        tree.addChild(bill, billCourse);

        TreeNode cop3212 = new TreeNode("cop3212");
        tree.addChild(billCourse, cop3212);

        TreeNode cop3212Fall = new TreeNode("fall");
        TreeNode win = new TreeNode("win");
        tree.addChild(cop3212, cop3212Fall);
        tree.addChild(cop3212, win);

        TreeNode fallGrades = new TreeNode("grades");
        TreeNode fallProg1r = new TreeNode("prog1.r");
        TreeNode fallProg2r = new TreeNode("prog2.r");
        tree.addChild(cop3212Fall, fallGrades);
        tree.addChild(cop3212Fall, fallProg1r);
        tree.addChild(cop3212Fall, fallProg2r);

        TreeNode winGrades = new TreeNode("grades");
        TreeNode winProg1r = new TreeNode("prog1.r");
        TreeNode winProg2r = new TreeNode("prog2.r");
        tree.addChild(win, winGrades);
        tree.addChild(win, winProg1r);
        tree.addChild(win, winProg2r);

        tree.printTree();
    }

    @Test
    public void testReadTreeFromFile() throws Exception {
        String treeFileName = "algorithm/tree/traversal/preorder/demoTree.txt";
        Tree tree = Tree.createTreeFromFile(Tree.class.getResource("/").getPath() + File.separator +  treeFileName);
        tree.printTree();
    }

    @Test
    public void preorderTraversal() throws Exception {

    }

}