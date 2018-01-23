package algorithm.tree.traversal.preorder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tree {
    private TreeNode root;

    public Tree(TreeNode root) {
        this.root = root;
        this.root.setDepth(0);
    }

    public static void addChild(TreeNode parent, TreeNode child) {
        if (parent.getFirstChild() == null) {
            parent.setFirstChild(child);
        } else {
            TreeNode sibling = parent.getFirstChild();
            while (sibling.getNextSibling() != null) {
                sibling = sibling.getNextSibling();
            }
            sibling.setNextSibling(child);
        }
    }

    /**
     * print tree with prefix lines with preorder traversal algorithm
     */
    public void printTree() {
        printTree(root);
    }

    public void printTree(TreeNode node) {
        printTree(node, "");
    }

    public void printTree(TreeNode node, String prefix) {
        System.out.println(prefix + node);
        TreeNode child = node.getFirstChild();
        String newPrefix;
        while (child != null) {
            prefix = prefix.replace("├", "│").replace("─", " ").replace("└", " ");
            newPrefix = (child.getNextSibling() != null) ? " ├─ " : " └─ ";
            printTree(child, prefix + newPrefix);
            child = child.getNextSibling();
        }
    }

    public TreeNode getRoot() {
        return root;
    }


    /**
     * Create the tree by reading a file. Each line with indent in the file represents a tree node.
     * Every 4 spaces indent represent a level of depth of the tree.
     *
     * @param fileName - the file represent the tree
     * @return - the tree
     */
    private static int lineIndex;
    private static ArrayList<TreeNode> nodes = new ArrayList<>();
    public static Tree createTreeFromFile(String fileName) {
        //read each line of the file into a TreeNode and add it to an ArrayList
        try {
            FileReader fin = new FileReader(fileName);
            BufferedReader treeFile = new BufferedReader(fin);

            String line;
            while ((line = treeFile.readLine()) != null) {
                Matcher matcher = Pattern.compile("^\\s+").matcher(line);
                int depth = 0;
                if (matcher.find()) {
                    depth = matcher.group().length() / 4;
                }
                StringTokenizer st = new StringTokenizer(line);
                try {
                    String nodeName = st.nextToken();
                    nodes.add(new TreeNode(nodeName, depth));
                    //System.out.println(nodeName + ":" + depth);
                } catch (Exception e) {
                    System.err.println(e + " " + line);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println(e);
            e.printStackTrace();
        }

        //recursively read the nodes into a tree
        TreeNode r = nodes.get(0);
        Tree tree = new Tree(r);
        lineIndex = 1;
        addSubTrees(r);

        return tree;
    }

    private static void addSubTrees (TreeNode currentRoot) {
        while (lineIndex < nodes.size()) {
            TreeNode node = nodes.get(lineIndex++);
            if (node.getDepth() == currentRoot.getDepth() + 1) {
                addChild(currentRoot, node);
                addSubTrees(node);
            } else {
                lineIndex--;
                break;
            }
        }
    }


}
