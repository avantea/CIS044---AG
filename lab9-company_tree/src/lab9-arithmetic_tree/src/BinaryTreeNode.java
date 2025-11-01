public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Preorder: Parent, Left, Right (Prefix)
     */
    public void traversePreorder() {
        System.out.print(this.value + " ");
        if (this.left != null)  this.left.traversePreorder();
        if (this.right != null) this.right.traversePreorder();
    }

    /**
     * Inorder: Left, Parent, Right (Infix)
     * Prints parentheses for clarity when this node has children (i.e., it's an operator).
     */
    public void traverseInorder() {
        boolean hasChildren = (this.left != null || this.right != null);
        if (hasChildren) System.out.print("(");
        if (this.left != null)  this.left.traverseInorder();
        System.out.print(this.value);
        if (this.right != null) this.right.traverseInorder();
        if (hasChildren) System.out.print(")");
    }

    /**
     * Postorder: Left, Right, Parent (Postfix / RPN)
     */
    public void traversePostorder() {
        if (this.left != null)  this.left.traversePostorder();
        if (this.right != null) this.right.traversePostorder();
        System.out.print(this.value + " ");
    }
}
