package binarysearchtree;

public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree(int value) {
        this.root = new TreeNode(value, null, null);
    }

    public TreeNode searchFromNode(TreeNode node, int value) {
        if (node == null || node.value == value) return node;
        if (value < node.value) {
            return searchFromNode(node.left, value);
        } else {
            return searchFromNode(node.right, value);
        }
    }

    // Search take O(log n)
    public TreeNode search(int value) {
        return searchFromNode(root, value);
    }

    // Add similar to search, Node is always added to leaf node
    public void add(int value) {
        TreeNode rootNode = root;
        while (rootNode != null) {
            if (value < rootNode.value) {
                if (rootNode.left == null) {
                    rootNode.left = new TreeNode(value, null, null);
                }
                rootNode = rootNode.left;
            } else if (value > rootNode.value) {
                if (rootNode.right == null) {
                    rootNode.right = new TreeNode(value, null, null);
                }
                rootNode = rootNode.right;
            } else {
                return;
            }
        }
    }

    public TreeNode minNode(TreeNode node){
        if(node.left == null){
            return node;
        }
        return minNode(node.left);
    }
    public void removeFromNode(TreeNode node, int value) {
        if(node == null) return;
        if (value < node.value) {
            removeFromNode(node.left, value);
        } else if (value > node.value) {
            removeFromNode(node.right, value);
        } else {
            // found the value
            if (node.left == null && node.right == null) {
                node = null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {
                TreeNode minRightNode = minNode(node.right);
                removeFromNode(node.right, minRightNode.value);
                node = minRightNode;
            }
        }
    }

    public void remove(int value) {
        removeFromNode(root, value);
    }

}
