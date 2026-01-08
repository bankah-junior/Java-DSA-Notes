## ✅ **What is a Tree?**

*   A **tree** is a hierarchical data structure consisting of **nodes**.
*   Each node contains:
    *   **Data**
    *   **References (links)** to child nodes
*   The **topmost node** is called the **root**.
*   Nodes with no children are **leaves**.
*   A tree is **acyclic** (no loops) and connected.

***

### **Key Terms**

*   **Root**: The first node.
*   **Parent / Child**: Relationship between nodes.
*   **Leaf**: Node with no children.
*   **Height**: Longest path from root to a leaf.
*   **Depth**: Distance from root to a node.
*   **Binary Tree**: Each node has at most **two children**.
*   **Binary Search Tree (BST)**: Left child < parent < right child.

***

## ✅ **Why Trees?**

*   Efficient searching and insertion (BST: average O(log n)).
*   Represent hierarchical data (file systems, XML/HTML).
*   Used in algorithms (DFS, BFS, shortest path).
*   Basis for advanced structures (Heaps, Tries, Segment Trees).

***

## ✅ **Types of Trees**

*   **Binary Tree**
*   **Binary Search Tree (BST)**
*   **Balanced Trees** (AVL, Red-Black)
*   **Heap** (Min-Heap, Max-Heap)
*   **Trie** (Prefix tree)
*   **N-ary Tree** (More than two children)

***

## ✅ **Basic Tree in Java**

Let’s start with a **Binary Tree Node**:

```java
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
```

***

### **Building a Simple Tree**

```java
public class BinaryTreeExample {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        System.out.println("Root: " + root.val);
        System.out.println("Left Child: " + root.left.val);
        System.out.println("Right Child: " + root.right.val);
    }
}
```

***

## ✅ **Tree Traversals**

Traversal means visiting all nodes in a specific order.

### **1. Inorder (Left → Root → Right)**

```java
public static void inorder(TreeNode root) {
    if (root == null) return;
    inorder(root.left);
    System.out.print(root.val + " ");
    inorder(root.right);
}
```

### **2. Preorder (Root → Left → Right)**

```java
public static void preorder(TreeNode root) {
    if (root == null) return;
    System.out.print(root.val + " ");
    preorder(root.left);
    preorder(root.right);
}
```

### **3. Postorder (Left → Right → Root)**

```java
public static void postorder(TreeNode root) {
    if (root == null) return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.val + " ");
}
```

***
