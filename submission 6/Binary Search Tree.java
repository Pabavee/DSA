public class BinarySearchTree {

    static class Node {
        int key;
        Node left, right;

        Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // Insert
    Node insert(Node node, int key) {
        if (node == null) return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);

        return node;
    }

    // Search
    boolean search(Node root, int key) {
        if (root == null || root.key == key)
            return root != null;

        if (key < root.key)
            return search(root.left, key);

        return search(root.right, key);
    }

    // Delete
    Node delete(Node root, int key) {
        if (root == null) return root;

        if (key < root.key)
            root.left = delete(root.left, key);
        else if (key > root.key)
            root.right = delete(root.right, key);
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get inorder successor
            root.key = minValue(root.right);
            root.right = delete(root.right, root.key);
        }
        return root;
    }

    int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Inorder traversal (sorted order)
    void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.key + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        System.out.println("=== Binary Search Tree - Scenarios ===\n");

        // Insert
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        System.out.print("Inorder (sorted): ");
        tree.inorder(tree.root);
        System.out.println();

        // Search
        System.out.println("\nSearch 40: " + tree.search(tree.root, 40));
        System.out.println("Search 25: " + tree.search(tree.root, 25));

        // Delete
        System.out.print("\nDelete 20 → ");
        tree.root = tree.delete(tree.root, 20);
        tree.inorder(tree.root);
        System.out.println();

        System.out.print("Delete 30 → ");
        tree.root = tree.delete(tree.root, 30);
        tree.inorder(tree.root);
        System.out.println();
    }
}