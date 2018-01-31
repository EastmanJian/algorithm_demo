package algorithm.tree.binary.traversal.inorder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BinaryTree {
    private BinaryNode root;
    private static String NODE_TYPE_ROOT = "[root]";
    private static String NODE_TYPE_LEFT = "[left]";
    private static String NODE_TYPE_RIGHT = "[right]";
    private static String NODE_NULL = "(null)";

    public BinaryTree(BinaryNode root) {
        this.root = root;
    }

    /**
     * print binary tree with prefix lines with preorder traversal algorithm
     */
    public void printTree() {
        printTree(root);
    }

    private void printTree(BinaryNode node) {
        printTree(node, "", NODE_TYPE_ROOT);
    }

    private void printTree(BinaryNode node, String prefix, String type) {
        System.out.println(prefix + type + node);
        BinaryNode leftChild = node.getLeftChild();
        BinaryNode rightChild = node.getRightChild();
        prefix = prefix.replace("├", "│").replace("─", " ").replace("└", " ");
        String newPrefix;
        newPrefix = " ├─ ";
        if (leftChild != null) {
            printTree(leftChild, prefix + newPrefix, NODE_TYPE_LEFT);
        } else if (leftChild == null && rightChild != null){
            System.out.println(prefix + newPrefix + NODE_TYPE_LEFT + NODE_NULL);
        }
        newPrefix = " └─ ";
        if (rightChild != null) {
            printTree(rightChild, prefix + newPrefix, NODE_TYPE_RIGHT);
        } else if (leftChild != null && rightChild == null) {
            System.out.println(prefix + newPrefix + NODE_TYPE_RIGHT + NODE_NULL);
        }
    }

    public BinaryNode getRoot() {
        return root;
    }


    /**
     * Create binary tree by reading a file. Each line with indent in the file represents a tree node.
     * Every 4 spaces indent represent a level of depth of the tree.
     * If either left or right child is null, write '(null)' as the node name in the file.
     *
     * @param fileName - the file represent the tree
     * @return - the tree
     */
    private static int lineIndex;
    private static ArrayList<BinaryNode> nodes = new ArrayList<>();
    public static BinaryTree createTreeFromFile(String fileName) {
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
                    nodes.add(new BinaryNode(nodeName, depth));
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
        BinaryNode r = nodes.get(0);
        BinaryTree tree = new BinaryTree(r);
        lineIndex = 1;
        addSubTrees(r);

        return tree;
    }

    private static void addSubTrees (BinaryNode currentRoot) {
        if (lineIndex < nodes.size() - 1) {
            BinaryNode node = nodes.get(lineIndex++);
            if (node.getDepth() == currentRoot.getDepth() + 1) {
                currentRoot.setLeftChild(node);
                if (node.getNodeName().equals("(null)")) currentRoot.setLeftChild(null);
                addSubTrees(node);
                node = nodes.get(lineIndex++);
                currentRoot.setRightChild(node);
                if (node.getNodeName().equals("(null)")) currentRoot.setRightChild(null);
                addSubTrees(node);
            } else {
                lineIndex--;
            }
        }
    }


}
