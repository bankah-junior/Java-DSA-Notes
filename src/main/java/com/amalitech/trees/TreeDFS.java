package com.amalitech.trees;

public class TreeDFS {

    private Node root;
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        Node(int value) {
            this.value = value;
        }
    }

    /**
     * Iterative insert
     * @param value
     */
    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
            return;
        }
        var node = new Node(value);
        var current = root;

        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            }else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
    }

    /**
     * Public method to call recursive insert
     * @param value
     */
    public void insertRec(int value) {
        root = insert(root, value);
    }

    /**
     * PreOrder(Root -> Left -> Right)
     * @param root
     */
    public void preOrder(Node root){
        if (root == null) return;
        System.out.println(root.value);

        preOrder(root.leftChild);
        preOrder(root.rightChild);
    }

    /**
     * InOrder(Left -> Root -> Right)
     * @param root
     */
    public void inOrder(Node root ){
        if (root == null) return;

        inOrder(root.leftChild);
        System.out.println(root.value);
        inOrder(root.rightChild);
    }

    /**
     * PostOrder(Left -> Right -> Root)
     * @param root
     */
    public void postOrder(Node root){
        if (root == null) return;

        postOrder(root.leftChild);
        postOrder(root.rightChild);
        System.out.println(root.value);
    }

    /**
     * Recursive insert
     * @param node
     * @param value
     * @return Node
     */
    private Node insert(Node node, int value) {
        if (node == null)
            return new Node(value);

        if (value < node.value)
            node.leftChild = insert(node.leftChild, value);
        else if (value > node.value)
            node.rightChild = insert(node.rightChild, value);

        return node;
    }

    /**
     * Height of tree
     * @return int
     */
    private int height(Node node) {
        if (root == null) return 0;

        int left = height(root.leftChild);
        int right = height(root.rightChild);

        return Math.max(left + 1, right + 1);
    }

    private int optimizedHeight(Node node) {
        if (node == null) return -1;

        if (node.leftChild == null && node.rightChild == null) return 0;

        int left = optimizedHeight(node.leftChild);
        int right = optimizedHeight(node.rightChild);

        return Math.max(left, right) + 1;
    }

    public static void main(String[] args){
        TreeDFS tree = new TreeDFS();
        tree.insert(10);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);

        System.out.println("InOrder");
        tree.inOrder(tree.root);

        System.out.println("PreOrder");
        tree.preOrder(tree.root);

        System.out.println("PostOrder");
        tree.postOrder(tree.root);

        //System.out.println("Height of tree: " + tree.height(tree.root));
        System.out.println("Optimized Height of tree: " + tree.optimizedHeight(tree.root));

    }

}
