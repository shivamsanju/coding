package test;

import binarysearchtree.BinarySearchTree;
import binarysearchtree.TreeNode;

public class BinarySearchTreeTest {
    public static void main(String[] args) {
        // Test Case 1: Basic insertion and searching
        System.out.println("Test Case 1: Basic insertion and searching");
        BinarySearchTree bst = new BinarySearchTree(10);
        bst.add(5);
        bst.add(15);
        bst.add(3);
        bst.add(7);
        bst.add(12);
        bst.add(18);

        assert bst.search(10).value == 10 : "Expected to find 10";
        assert bst.search(5).value == 5 : "Expected to find 5";
        assert bst.search(15).value == 15 : "Expected to find 15";
        assert bst.search(3).value == 3 : "Expected to find 3";
        assert bst.search(7).value == 7 : "Expected to find 7";
        assert bst.search(12).value == 12 : "Expected to find 12";
        assert bst.search(18).value == 18 : "Expected to find 18";
        assert bst.search(1) == null : "Expected not to find 1";

        // Test Case 2: Removing a leaf node
        System.out.println("\nTest Case 2: Removing a leaf node");
        bst.remove(3);
        assert bst.search(3) == null : "Expected not to find 3 after removal";
        assert bst.search(5).left == null : "Expected left child of 5 to be null after removing 3";

        // Test Case 3: Removing a node with one child
        System.out.println("\nTest Case 3: Removing a node with one child");
        bst.remove(7);
        assert bst.search(7) == null : "Expected not to find 7 after removal";
        assert bst.search(5).right == null : "Expected right child of 5 to be null after removing 7";

        // Test Case 4: Removing a node with two children
        System.out.println("\nTest Case 4: Removing a node with two children");
        bst.remove(15);
        assert bst.search(15) == null : "Expected not to find 15 after removal";
        assert bst.search(12) != null : "Expected 12 to still be in the tree";
        assert bst.search(18) != null : "Expected 18 to still be in the tree";

        // Test Case 5: Removing the root node
        System.out.println("\nTest Case 5: Removing the root node");
        bst.remove(10);
        assert bst.search(10) == null : "Expected not to find 10 after removing the root";

        // Test Case 6: Edge case - Removing non-existing element
        System.out.println("\nTest Case 6: Removing non-existing element");
        int initialSize = countNodes(bst);
        bst.remove(100); // Non-existing element
        int newSize = countNodes(bst);
        assert initialSize == newSize : "Expected size to remain the same after removing non-existing element";

        System.out.println("All test cases passed.");
    }

    // Helper function to count nodes in the tree (used in Test Case 6)
    public static int countNodes(BinarySearchTree bst) {
        return countNodesFromNode(bst.search(0)); // Assuming 0 as root or first added value
    }

    public static int countNodesFromNode(TreeNode node) {
        if (node == null) return 0;
        return 1 + countNodesFromNode(node.left) + countNodesFromNode(node.right);
    }
}
