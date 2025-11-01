public class ExpressionTreeDriver {
    public static void main(String[] args) {
        // Build the tree for: ( (3 + 7) * (9 - 4) )
        //
        //         *
        //        / \
        //       +   -
        //      / \ / \
        //     3  7 9  4

        BinaryTreeNode root = new BinaryTreeNode("*");

        BinaryTreeNode nodePlus  = new BinaryTreeNode("+");
        BinaryTreeNode nodeMinus = new BinaryTreeNode("-");

        // Connect root to its children
        root.left = nodePlus;
        root.right = nodeMinus;
        nodePlus.parent = root;
        nodeMinus.parent = root;

        // Create leaves
        BinaryTreeNode node3 = new BinaryTreeNode("3");
        BinaryTreeNode node7 = new BinaryTreeNode("7");
        BinaryTreeNode node9 = new BinaryTreeNode("9");
        BinaryTreeNode node4 = new BinaryTreeNode("4");

        // Attach leaves
        nodePlus.left = node3;   node3.parent = nodePlus;
        nodePlus.right = node7;  node7.parent = nodePlus;

        nodeMinus.left = node9;  node9.parent = nodeMinus;
        nodeMinus.right = node4; node4.parent = nodeMinus;

        // Traversals
        System.out.println("--- Preorder Traversal (Prefix) ---");
        root.traversePreorder();

        System.out.println("\n\n--- Inorder Traversal (Infix) ---");
        root.traverseInorder();

        System.out.println("\n\n--- Postorder Traversal (Postfix) ---");
        root.traversePostorder();

        System.out.println(); // final newline
    }
}

