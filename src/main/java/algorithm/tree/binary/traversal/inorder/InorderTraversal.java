package algorithm.tree.binary.traversal.inorder;

public class InorderTraversal {
    /**
     * use inorder traversal algorithm to print an expression from an expression tree.
     * @param node - the starting node
     */
    public static void printExpression(BinaryNode node) {
        if (node.getLeftChild() != null) {
            System.out.print("(");
            printExpression(node.getLeftChild());
        }
        System.out.print(node);
        if (node.getRightChild() != null) {
            printExpression(node.getRightChild());
            System.out.print(")");
        }
    }
}
