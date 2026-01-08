***

## ✅ **What is a Binary Search Tree (BST)?**

A **BST** is a binary tree with an ordering property:

*   For any node:
    *   All values in its **left subtree** are **less than** the node’s value.
    *   All values in its **right subtree** are **greater than** the node’s value.

This property makes **search, insert, and delete** efficient (average O(log n)) when the tree is balanced.

***

## ✅ **BST Operations**

We’ll cover:

1.  **Insert** a value
2.  **Search** for a value
3.  **Delete** a value
4.  **Traversals** (Inorder, Preorder, Postorder)

***

### **Step 1: Define the Node**

```java
class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
    }
}
```

***

### **Step 2: Insert into BST**

```java
public TreeNode insert(TreeNode root, int val) {
    if (root == null) return new TreeNode(val);

    if (val < root.val) {
        root.left = insert(root.left, val);
    } else if (val > root.val) {
        root.right = insert(root.right, val);
    }
    return root; // unchanged root
}
```

***

### **Step 3: Search in BST**

```java
public boolean search(TreeNode root, int val) {
    if (root == null) return false;
    if (root.val == val) return true;
    return val < root.val ? search(root.left, val) : search(root.right, val);
}
```

***

### **Step 4: Delete from BST**

Deleting is trickier:

*   **Case 1:** Node is a leaf → remove it.
*   **Case 2:** Node has one child → replace with child.
*   **Case 3:** Node has two children → replace with inorder successor (smallest in right subtree).

```java
public TreeNode delete(TreeNode root, int val) {
    if (root == null) return null;

    if (val < root.val) {
        root.left = delete(root.left, val);
    } else if (val > root.val) {
        root.right = delete(root.right, val);
    } else {
        // Node found
        if (root.left == null) return root.right;
        if (root.right == null) return root.left;

        // Two children: find inorder successor
        TreeNode successor = findMin(root.right);
        root.val = successor.val;
        root.right = delete(root.right, successor.val);
    }
    return root;
}

private TreeNode findMin(TreeNode node) {
    while (node.left != null) node = node.left;
    return node;
}
```

***

### **Step 5: Traversals**

**Inorder (sorted order for BST):**

```java
public void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

***

## ✅ **Full Demo**

```java
public class BSTDemo {
    TreeNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    public boolean search(int val) {
        return search(root, val);
    }

    public void delete(int val) {
        root = delete(root, val);
    }

    public void printInorder() {
        inorder(root);
        System.out.println();
    }

    // Include insert, search, delete, inorder methods here

    public static void main(String[] args) {
        BSTDemo bst = new BSTDemo();
        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        System.out.print("Inorder: ");
        bst.printInorder(); // 20 30 40 50 60 70 80

        System.out.println("Search 40: " + bst.search(40)); // true
        bst.delete(50);
        System.out.print("After deleting 50: ");
        bst.printInorder(); // 20 30 40 60 70 80
    }
}
```

***
