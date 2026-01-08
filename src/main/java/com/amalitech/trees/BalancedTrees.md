
***

## ✅ Why Balanced Trees?

*   A normal BST can become **skewed** (like a linked list) if elements are inserted in sorted order.
*   Skewed BST → **search, insert, delete = O(n)**.
*   Balanced Trees maintain **height ≈ log₂(n)** → operations stay **O(log n)**.

***

## ✅ Two Popular Balanced Trees

1.  **AVL Tree**
    *   Strictly balanced: For every node, the height difference between left and right subtrees ≤ 1.
    *   Guarantees **O(log n)** for search, insert, delete.
    *   Uses **rotations** to maintain balance after insert/delete.

2.  **Red-Black Tree**
    *   Loosely balanced: Ensures no path is more than twice as long as any other.
    *   Used in Java’s `TreeMap` and `TreeSet`.
    *   Easier to implement than AVL for large-scale systems.

***

## ✅ AVL Tree Basics

*   Each node stores:
    *   `val`
    *   `left`, `right`
    *   `height`
*   After insertion/deletion:
    *   Compute **balance factor** = `height(left) - height(right)`
    *   If balance factor is outside \[-1, 1], perform **rotation**:
        *   **LL Rotation** (Right Rotate)
        *   **RR Rotation** (Left Rotate)
        *   **LR Rotation** (Left-Right)
        *   **RL Rotation** (Right-Left)

***

### ✅ AVL Tree Java Implementation (Insert + Rotations)

```java
class AVLNode {
    int val, height;
    AVLNode left, right;

    AVLNode(int val) {
        this.val = val;
        this.height = 1;
    }
}

public class AVLTree {
    private AVLNode root;

    public void insert(int val) {
        root = insert(root, val);
    }

    private AVLNode insert(AVLNode node, int val) {
        if (node == null) return new AVLNode(val);

        if (val < node.val) node.left = insert(node.left, val);
        else if (val > node.val) node.right = insert(node.right, val);
        else return node; // no duplicates

        // Update height
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Check balance
        int balance = getBalance(node);

        // Rotations
        if (balance > 1 && val < node.left.val) return rotateRight(node); // LL
        if (balance < -1 && val > node.right.val) return rotateLeft(node); // RR
        if (balance > 1 && val > node.left.val) { // LR
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && val < node.right.val) { // RL
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }

        return node;
    }

    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int getBalance(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }

    private AVLNode rotateRight(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = 1 + Math.max(height(y.left), height(y.right));
        x.height = 1 + Math.max(height(x.left), height(x.right));

        return x;
    }

    private AVLNode rotateLeft(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = 1 + Math.max(height(x.left), height(x.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.val + " ");
        inorder(node.right);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        System.out.print("Inorder Traversal: ");
        tree.inorder(); // Balanced order
    }
}
```

***

## ✅ Red-Black Tree (Concept)

A **Red‑Black Tree** is a self‑balancing binary search tree that guarantees **O(log n)** time for `search`, `insert`, and `delete`. Instead of tracking exact heights (like AVL), it enforces **coloring rules** that keep the tree “balanced enough” by limiting how tall it can grow.

***

## 🧠 Core Invariants (Rules)

Every valid red‑black tree satisfies these properties:

1.  **Each node is either red or black.**
2.  **The root is black.**
3.  **All leaves (NIL/sentinel nodes) are black.**  
    (In implementations, null children are treated as black NIL nodes.)
4.  **Red nodes cannot have red children.**  
    (No two consecutive reds on a path → “red parent must have black children.”)
5.  **Every path from a node to any of its descendant NIL leaves has the same number of black nodes.**  
    (This is the **black-height** property.)

Because of (5), no path can be more than **twice** as long as any other—this bounds height to **≤ 2·log₂(n+1)**, which is what preserves performance.

***

## 🔧 Building Blocks: Rotations & Recoloring

Two local transformations keep the invariants during updates:

*   **Left rotation (rotateLeft)** and **right rotation (rotateRight)**  
    These restructure a small part of the tree without breaking the BST order. Think of them as shifting a node down and its child up to redistribute height.

*   **Recoloring**  
    Flip red/black colors on a node and/or its relatives to restore the rules without changing structure.

You’ll see **combinations of rotations and recoloring** used to fix local violations after inserts and deletes.

***

## ➕ Insert (High-Level)

1.  **BST insert** the new key as you would in a regular BST, color the new node **red** (conservative default).
2.  **Fix‑up loop** while the parent is red (violates rule #4):
    *   Identify the **uncle** (parent’s sibling).
    *   **Case A: Uncle is red** → recolor parent and uncle to black, grandparent to red, and **move up** to grandparent (because grandparent may now violate rule #4).
    *   **Case B: Uncle is black** → perform **rotation(s)** and recoloring to fix the “red‑red” chain:
        *   If the new node and parent are in a “zig‑zag” configuration (e.g., left‑right or right‑left), do a **first rotation** to make them “straight”.
        *   Then **rotate** around the grandparent and recolor (the middle node becomes the local root and black).
3.  **Ensure root is black** at the end.

**Intuition:** Insertion can only create a **red‑red** violation; fixing uses either recolor (if uncle red) or rotation+recolor (if uncle black).

***

## ➖ Delete (High-Level)

Deletion is trickier because removing a node can **reduce black height** along one path. Steps:

1.  **BST delete** the node:
    *   If it has two children, swap with its **inorder successor** and delete that successor (which has at most one child).
2.  If the removed node (or the moved replacement) was **black**, you may introduce a **“double‑black” deficiency** at the replacement position.
3.  **Fix‑up loop** to resolve double‑black:
    *   Look at the **sibling** and its children’s colors.
    *   Use **recoloring** and **rotations** to move blackness or convert patterns until the deficiency is absorbed or reaches the root.
4.  **Ensure root is black** at the end.

**Intuition:** Deletion fix‑ups are a set of structured cases (sibling red → rotate; sibling black with black children → recolor and move up; sibling black with a red child → rotate and recolor to finish).

***

## ⏱️ Complexity

*   **Search / Insert / Delete:** `O(log n)` worst case.
*   **Space:** `O(n)` nodes; typical implementations use **sentinel NIL** nodes to simplify logic.
*   **Stability:** Not a sorting algorithm; it’s a data structure. Ordering is by the BST property.

***

## 🔄 AVL vs Red‑Black (When to Choose Which?)

*   **AVL**: Stricter balance → usually **faster lookups** (shallower height), but **more rotations** on inserts/deletes (especially deletes).
*   **Red‑Black**: Looser balance → **fewer rotations** on updates; commonly chosen in libraries and language runtimes (e.g., **Java’s `TreeMap` / `TreeSet`** use RBTs) for mixed workloads.

If your workload is **read‑heavy** with infrequent updates and you want the lowest height, **AVL** can shine. For **general mixed workloads**, **Red‑Black** is a great default.

***

## 🧩 Minimal Java Skeleton (Node + Rotations)

Below is a compact starting point for an RBT. It includes:

*   Node definition with color
*   Left/Right rotation primitives
*   Insert outline with a fix‑up (you can expand the case handling)
*   (Delete fix‑up is longer; you can add it similarly)

```java
enum Color { RED, BLACK }

class RBNode {
    int key;
    Color color;
    RBNode left, right, parent;

    RBNode(int key, Color color) {
        this.key = key;
        this.color = color;
    }
}

public class RedBlackTree {
    private RBNode root;
    private final RBNode NIL = new RBNode(0, Color.BLACK); // sentinel

    public RedBlackTree() {
        NIL.left = NIL.right = NIL.parent = NIL;
        root = NIL;
    }

    // Left rotate around x:
    private void rotateLeft(RBNode x) {
        RBNode y = x.right;
        x.right = y.left;
        if (y.left != NIL) y.left.parent = x;

        y.parent = x.parent;
        if (x.parent == NIL) root = y;
        else if (x == x.parent.left) x.parent.left = y;
        else x.parent.right = y;

        y.left = x;
        x.parent = y;
    }

    // Right rotate around y:
    private void rotateRight(RBNode y) {
        RBNode x = y.left;
        y.left = x.right;
        if (x.right != NIL) x.right.parent = y;

        x.parent = y.parent;
        if (y.parent == NIL) root = x;
        else if (y == y.parent.left) y.parent.left = x;
        else y.parent.right = x;

        x.right = y;
        y.parent = x;
    }

    // Public insert
    public void insert(int key) {
        RBNode z = new RBNode(key, Color.RED);
        z.left = z.right = z.parent = NIL;

        // BST insert
        RBNode y = NIL, x = root;
        while (x != NIL) {
            y = x;
            if (key < x.key) x = x.left; else x = x.right;
        }
        z.parent = y;
        if (y == NIL) root = z;
        else if (key < y.key) y.left = z; else y.right = z;

        // Fix-up to restore invariants
        insertFixUp(z);
    }

    private void insertFixUp(RBNode z) {
        while (z.parent.color == Color.RED) {
            RBNode gp = z.parent.parent;
            boolean parentIsLeft = (z.parent == gp.left);
            RBNode uncle = parentIsLeft ? gp.right : gp.left;

            if (uncle.color == Color.RED) {
                // Case A: recolor and move up
                z.parent.color = Color.BLACK;
                uncle.color = Color.BLACK;
                gp.color = Color.RED;
                z = gp;
            } else {
                // Case B: rotations + recolor
                if (parentIsLeft) {
                    if (z == z.parent.right) { // Left-Right
                        z = z.parent;
                        rotateLeft(z);
                    }
                    z.parent.color = Color.BLACK;
                    gp.color = Color.RED;
                    rotateRight(gp);
                } else {
                    if (z == z.parent.left) { // Right-Left
                        z = z.parent;
                        rotateRight(z);
                    }
                    z.parent.color = Color.BLACK;
                    gp.color = Color.RED;
                    rotateLeft(gp);
                }
            }
        }
        root.color = Color.BLACK;
    }

    // Simple inorder to check BST order
    public void inorder() { inorder(root); System.out.println(); }
    private void inorder(RBNode n) {
        if (n == NIL) return;
        inorder(n.left);
        System.out.print(n.key + "(" + (n.color == Color.RED ? "R" : "B") + ") ");
        inorder(n.right);
    }

    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();
        int[] vals = {10, 20, 30, 15, 25, 5, 1, 6};
        for (int v : vals) rbt.insert(v);
        rbt.inorder(); // check ordering and colors
    }
}
```

**Notes:**

*   The sentinel `NIL` simplifies boundary conditions (nulls treated as black leaves).
*   The `insertFixUp` shows the classic **uncle‑red** (recolor) and **uncle‑black** (rotation + recolor) paths.
*   For production, add **delete** with its fix‑up cases and thorough testing.

***

