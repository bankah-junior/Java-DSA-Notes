
***

## ✅ **What is a Binary Tree?**

A **binary tree** is a hierarchical structure where:

*   Each node has **at most two children**:
    *   **Left child**
    *   **Right child**
*   The topmost node is called the **root**.
*   Nodes with no children are **leaf nodes**.

***

### **Key Properties**

*   **Height**: Longest path from root to a leaf.
*   **Depth**: Distance from root to a node.
*   **Full Binary Tree**: Every node has 0 or 2 children.
*   **Complete Binary Tree**: All levels filled except possibly the last, which is filled left to right.
*   **Perfect Binary Tree**: All internal nodes have two children and all leaves are at the same level.

***

## ✅ **Binary Tree Node in Java**

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

## ✅ **Building a Simple Binary Tree**

```java
public class BinaryTreeBasics {
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

## ✅ **Level Order Traversal (BFS)**

Uses a **Queue**:

```java
import java.util.*;

public static void levelOrder(TreeNode root) {
    if (root == null) return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
        TreeNode node = queue.poll();
        System.out.print(node.val + " ");
        if (node.left != null) queue.add(node.left);
        if (node.right != null) queue.add(node.right);
    }
}
```

***

