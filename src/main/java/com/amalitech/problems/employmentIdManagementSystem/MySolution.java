package com.amalitech.problems.employmentIdManagementSystem;

import java.util.ArrayList;
import java.util.List;

public class MySolution {
    static class Node {
        int id, salary;
        Node left, right;
        Node(int id, int salary) {
            this.id = id;
            this.salary = salary;
            left = right = null;
            System.out.println("Registered: ID=" + id + ", Salary=" + salary);
        }
    }

    static void FindById(Node root, int id){
        if (root == null) {
            System.out.println("Employee with ID " + id + " not found.");
            return;
        }
        if (root.id == id) {
            System.out.println("Found: ID=" + root.id + ", Salary=" + root.salary);
        } else if (id < root.id) {
            FindById(root.left, id);
        } else {
            FindById(root.right, id);
        }
    }

    static void FindByRange(Node root, int low, int high){
        List<Integer> result = new ArrayList<>();
        FindInRangeHelper(root, low, high, result);
        System.out.println("Range [" + low + "-" + high + "]: " + result);
    }

    private static void FindInRangeHelper(Node root, int low, int high, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.id >= low && root.id <= high) {
            result.add(root.id);
        }
        if (root.id > low) {
            FindInRangeHelper(root.left, low, high, result);
        }
        if (root.id < high) {
            FindInRangeHelper(root.right, low, high, result);
        }
    }

    static void Height(Node root) {
        System.out.println("Tree Height: " + HeightHelper(root));
    }

     private static int HeightHelper(Node root) {
        if (root == null) {
            return -1;
        }
        int leftHeight = HeightHelper(root.left);
        int rightHeight = HeightHelper(root.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

     static void PathToId(Node root, int id) {
        List<Integer> path = new ArrayList<>();
        PathToIdHelper(root, id, path);
    }

    private static void PathToIdHelper(Node root, int id, List<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.id);
        if (root.id == id) {
            System.out.println("Path to " + id + ": " + path);
            return;
        } else if (id < root.id) {
            PathToIdHelper(root.left, id, path);
        } else {
            PathToIdHelper(root.right, id, path);
        }
        path.removeLast();
    }

     static void GetAllIds(Node root) {
        List<Integer> ids = new ArrayList<>();
        GetAllIdsHelper(root, ids);
        System.out.println("All employees: " + ids);
    }

    private static void GetAllIdsHelper(Node root, List<Integer> ids) {
        if (root == null) {
            return;
        }
        ids.add(root.id);
        GetAllIdsHelper(root.left, ids);
        GetAllIdsHelper(root.right, ids);
    }

    public static void main(String[] args) {
        Node root = new Node(50000, 75000);
        root.left = new Node(30000, 65000);
        root.right = new Node(70000, 80000);
        root.left.left = new Node(20000, 55000);
        root.right.left = new Node(40000, 70000);
        FindById(root, 30000);
        FindByRange(root, 25000, 45000);
        Height(root);
        PathToId(root, 20000);
        GetAllIds(root);

    }
}
