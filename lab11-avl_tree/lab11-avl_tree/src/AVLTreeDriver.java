public class AVLTreeDriver {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        // TODO: Insert test values
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        // TODO: Add more insertions to test all 4 rotation cases
        tree.insert(5);
        tree.insert(4);
        tree.insert(8);
        tree.insert(25);

        // TODO: Print traversals
        System.out.print("Inorder: ");
        tree.inorder();

        System.out.print("Preorder: ");
        tree.preorder();

        System.out.print("Postorder: ");
        tree.postorder();

        // TODO: Add expected results as comments for verification
    }
}

