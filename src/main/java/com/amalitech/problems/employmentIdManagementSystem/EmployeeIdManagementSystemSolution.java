package com.amalitech.problems.employmentIdManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;

public class EmployeeIdManagementSystemSolution {

    static class Node {
        int id;
        int salary;
        Node left, right;

        Node(int id, int salary) {
            this.id = id;
            this.salary = salary;
            this.left = this.right = null;
        }
    }

    static class BST {
        private Node root;

        public BST() {
            this.root = null;
        }

        public int register(int id, int salary) {
            root = registerRec(root, id, salary);
            return salary;
        }

        private Node registerRec(Node current, int id, int salary) {
            if (current == null) {
                return new Node(id, salary);
            }

            if (id < current.id) {
                current.left = registerRec(current.left, id, salary);
            } else if (id > current.id) {
                current.right = registerRec(current.right, id, salary);
            } else {
                current.salary = salary;
            }
            return current;
        }

        public Node lookup(int id) {
            return lookupRec(root, id);
        }

        private Node lookupRec(Node current, int id) {
            if (current == null || current.id == id) {
                return current;
            }
            if (id < current.id) {
                return lookupRec(current.left, id);
            }
            return lookupRec(current.right, id);
        }

        public int height() {
            return heightRec(root);
        }

        private int heightRec(Node node) {
            if (node == null) {
                return -1;
            }
            return 1 + Math.max(heightRec(node.left), heightRec(node.right));
        }

        public List<Integer> getPath(int id) {
            List<Integer> path = new ArrayList<>();
            Node current = root;
            while (current != null) {
                path.add(current.id);
                if (id < current.id) {
                    current = current.left;
                } else if (id > current.id) {
                    current = current.right;
                } else {
                    return path;
                }
            }
            return null; // Not found
        }

        public List<Integer> findInRange(int low, int high) {
            List<Integer> result = new ArrayList<>();
            findInRangeRec(root, low, high, result);
            return result;
        }

        private void findInRangeRec(Node node, int low, int high, List<Integer> result) {
            if (node == null) {
                return;
            }
            if (node.id > low) {
                findInRangeRec(node.left, low, high, result);
            }
            if (node.id >= low && node.id <= high) {
                result.add(node.id);
            }
            if (node.id < high) {
                findInRangeRec(node.right, low, high, result);
            }
        }

        public List<Integer> display() {
            List<Integer> result = new ArrayList<>();
            inOrderTraversal(root, result);
            return result;
        }

        private void inOrderTraversal(Node node, List<Integer> result) {
            if (node != null) {
                inOrderTraversal(node.left, result);
                result.add(node.id);
                inOrderTraversal(node.right, result);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseNumber = 1;
        while (true) {
            int n = scanner.nextInt();
            if (n == 0) {
                break;
            }

            System.out.printf("Case %d:%n", caseNumber++);
            BST tree = new BST();

            for (int i = 0; i < n; i++) {
                String command = scanner.next();
                switch (command) {
                    case "REGISTER": {
                        int id = scanner.nextInt();
                        int salary = scanner.nextInt();
                        tree.register(id, salary);
                        System.out.printf("Registered: ID=%d, Salary=%d%n", id, salary);
                        break;
                    }
                    case "LOOKUP": {
                        int id = scanner.nextInt();
                        Node found = tree.lookup(id);
                        if (found != null) {
                            System.out.printf("Found: ID=%d, Salary=%d%n", id, found.salary);
                        } else {
                            System.out.printf("Not found: ID=%d%n", id);
                        }
                        break;
                    }
                    case "RANGE": {
                        int low = scanner.nextInt();
                        int high = scanner.nextInt();
                        List<Integer> inRange = tree.findInRange(low, high);
                        StringJoiner sj = new StringJoiner(", ");
                        inRange.forEach(id -> sj.add(String.valueOf(id)));
                        System.out.printf("Range [%d-%d]: %s%n", low, high, inRange.isEmpty() ? "none" : "[" + sj + "]");
                        break;
                    }
                    case "HEIGHT": {
                        System.out.printf("Tree height: %d%n", tree.height());
                        break;
                    }
                    case "PATH": {
                        int id = scanner.nextInt();
                        List<Integer> path = tree.getPath(id);
                        if (path != null) {
                            StringJoiner sj = new StringJoiner(", ");
                            path.forEach(p -> sj.add(String.valueOf(p)));
                            System.out.printf("Path to %d: [%s]%n", id, sj);
                        } else {
                            System.out.printf("Path to %d: not found%n", id);
                        }
                        break;
                    }
                    case "DISPLAY": {
                        List<Integer> all = tree.display();
                        StringJoiner sj = new StringJoiner(", ");
                        all.forEach(id -> sj.add(String.valueOf(id)));
                        System.out.printf("All employees: [%s]%n", sj);
                        break;
                    }
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}
