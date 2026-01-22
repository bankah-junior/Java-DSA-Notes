# DSA Hints

---

## Recursion
### Factorial
- Base Case: if n == 0 or n == 1, return 1
- Recursive Case: return n * factorial(n - 1)
- Time Complexity: O(n)
- Space Complexity: O(n) due to call stack

---

## Searching Algorithms
### Linear Search
- Unsorted and Sorted Arrays
- Normal For Loop
- Enhanced For Loop
- Time Complexity: O(n)
- Space Complexity: O(1)

### Binary Search
- Sorted Arrays Only
- Iterative Approach
- Steps:
  1. Get Low, High
  2. while Low <= High:
     1. Calculate Mid-Element
     2. Check if Mid-Element is Target return Mid-Index
     3. If Target < Mid-Element, Move High to Mid - 1
     4. If Target > Mid-Element, Move Low to Mid + 1
  3. Return -1 if Target Not Found
- Time Complexity: O(log n)
- Space Complexity: O(1) for iterative, O(log n) for recursive due to call stack

## Sorting Algorithms
### Bubble Sort
- Simple Comparison-Based Sort
- Repeatedly Steps Through the List
- Swaps Adjacent Elements if They are in the Wrong Order
- Steps:
  1. For i from 0 to n-1
     1. For j from 0 to n-i-2
        1. If arr[j] > arr[j+1], Swap arr[j] and arr[j+1], Set Swapped Flag to True
     2. If No Swaps Occurred, Break Early
- Optimized with a Flag to Stop if No Swaps Occur
- Time Complexity: O(n^2)
- Space Complexity: O(1)

### Quick Sort
- Divide-and-Conquer Algorithm
- Steps:
  1. Check Base Case (Array of Size null or < 2)
  2. quickSort(arr, low, high):
     1. If low < high:
        1. pi = partition(arr, low, high)
        2. quickSort(arr, low, pi - 1)
        3. quickSort(arr, pi + 1, high)
  3. partition(arr, low, high):
    1. Choose Pivot (e.g., arr[high])
    2. Initialize i = low
    3. For j from low to high:
       1. If arr[j] <= pivot:
          1. i++
          2. Swap arr[i] and arr[j]
    4. Swap arr[i] and arr[high]
    5. Return i
- Time Complexity: O(n log n) on average, O(n^2) in the worst case
- Space Complexity: O(log n) due to recursion stack

### Merge Sort
- Divide-and-Conquer Algorithm
- Steps:
  1. mergeSort(arr):
     1. Create Temp Array
     2. mergeSort(arr, left, right, temp):
        1. If left >= right, return
        2. mid = left + (right - left) / 2
        3. mergeSort(arr, left, mid, temp)
        4. mergeSort(arr, mid + 1, right, temp)
        5. If arr[mid] <= arr[mid + 1], return (already sorted)
        6. merge(arr, left, mid, right, temp)
  3. merge(arr, left, mid, right, temp):
     1. Copy arr[left..right] to temp[left..right]
     2. Initialize i = left, j = mid + 1, k = left
     3. While i <= mid and j <= right:
        1. If temp[i] <= temp[j]:
           1. arr[k++] = temp[i++]
        2. Else:
           1. arr[k++] = temp[j++]
     4. Copy Remaining Elements from Left Half if Any
- Time Complexity: O(n log n)
- Space Complexity: O(n) due to auxiliary array

## Linked Lists
- Lists consisting of nodes where each node contains data and a pointer to the next node
- Types:
  - Singly Linked List
  - Doubly Linked List
  - Circular Linked List

---

### Singly Linked List Implementation
- Steps:
  1. Define Node Class with 
     1. data, 
     2. next pointer and 
     3. constructor
     ```java
     class SNode {
        int data;
        SNode next;
        SNode(int data) {
            this.data = data;
            this.next = null;
        }
     }
     ```
  2. Implement insert at head
     1. Create an instance variable head
     2. Create new node with given data
     3. Point new node's next to current head which may be null
     4. Update head to new node
     ```java
     Node head;
     void insertAtHead(int data) {
         SNode newNode = new SNode(data);
         newNode.next = head;
         head = newNode;
     }
     ```
  3. Implement insert at tail
     1. Create new node with given data
     2. If head is null, set head to new node
     3. Else, traverse to the last node
     4. Set last node's next to new node
     ```java
     void insertAtTail(int data) {
         SNode newNode = new SNode(data);
         if (head == null) {
             head = newNode;
             return;
         }
         SNode curr = head;
         while (curr.next != null) {
             curr = curr.next;
         }
         curr.next = newNode;
     }
     ```
  4. Insert at specific position (optional)
     1. Handle edge cases (position 0 or greater than length)
     2. Traverse to the node before the desired position
     3. Insert new node by adjusting pointers
     ```java
        void insertAtPosition(int data, int position) {
            if (position == 0) {
                insertAtHead(data);
                return;
            }
            SNode newNode = new SNode(data);
            SNode curr = head;
            for (int i = 0; i < position - 1 && curr != null; i++) {
                curr = curr.next;
            }
            if (curr == null) {
                insertAtTail(data);
                return;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }
        ```
  5. Delete from head
     1. If head is not null, update head to head.next
     ```java
     void deleteFromHead() {
         if (head != null) {
             head = head.next;
         }
     }
     ```
  6. Delete from tail
     1. If head is null, return
     2. If head.next is null, set head to null
     3. Else, traverse to the second last node and set its next to null
     ```java
     void deleteFromTail() {
         if (head == null) return;
         if (head.next == null) {
             head = null;
             return;
         }
         SNode curr = head;
         while (curr.next.next != null) {
             curr = curr.next;
         }
         curr.next = null;
     }
     ```
     
---

## Stack Data Structure
### Linked List–Based Stack Implementation
- It is a LIFO (Last In, First Out) data structure
- Every new element is added to the top of the stack
- Every removal of an element is from the top of the stack
- The steps will be similar to Singly Linked List with focus on top element

## Queue Data Structure
### Linked List–Based Queue Implementation
- It is a FIFO (First In, First Out) data structure
- Every new element is added to the rear of the queue
- Every removal of an element is from the front of the queue
- The steps will be similar to Singly Linked List with focus on front and rear elements

## Trees
### Basic Tree Node Structure
- A tree is a hierarchical data structure consisting of nodes
- Each node contains:
  - Data
  - References (links) to child nodes
- The topmost node is called the root
- Nodes with no children are leaves
- A tree is acyclic (no loops) and connected

---

### Binary Tree
- A binary tree is a hierarchical structure where each node has at most two children: left child and right child
- Steps to create a binary tree node:
    1. Define TreeNode class with 
       1. integer value
       2. left child pointer
       3. right child pointer
       4. constructor
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
    2. Inorder traversal (Left, Root, Right)
       ```java
       void inorderTraversal(TreeNode root) {
           if (root == null) return;
           inorderTraversal(root.left);
           System.out.print(root.val + " ");
           inorderTraversal(root.right);
       }
       ```
    3. Preorder traversal (Root, Left, Right)
       ```java
       void preorderTraversal(TreeNode root) {
           if (root == null) return;
           System.out.print(root.val + " ");
           preorderTraversal(root.left);
           preorderTraversal(root.right);
       }
       ```
    4. Postorder traversal (Left, Right, Root)
       ```java
       void postorderTraversal(TreeNode root) {
           if (root == null) return;
           postorderTraversal(root.left);
           postorderTraversal(root.right);
           System.out.print(root.val + " ");
       }
         ```
    5. Height of the tree
       ```java
       int height(TreeNode root) {
           if (root == null) return 0;
           int leftHeight = height(root.left);
           int rightHeight = height(root.right);
           return Math.max(leftHeight, rightHeight) + 1;
       }
       ```
    6. Count number of nodes
       ```java
       int countNodes(TreeNode root) {
           if (root == null) return 0;
           return 1 + countNodes(root.left) + countNodes(root.right);
       }
       ```
    7. Build a simple binary tree
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
 ---

### Binary Search Tree (BST)
- A binary search tree is a binary tree with the following properties:
  - The left subtree of a node contains only nodes with values less than the node's value
  - The right subtree of a node contains only nodes with values greater than the node's value
  - Both the left and right subtrees must also be binary search trees
- Steps to implement BST operations:
    1. Create TreeNode class (same as binary tree)
    2. Insert a value
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
    3. Search for a value
       ```java
       public boolean search(TreeNode root, int val) {
           if (root == null) return false;
           if (val == root.val) return true;
           if (val < root.val) {
               return search(root.left, val);
           } else {
               return search(root.right, val);
           }
       }
       ```
    4. Delete a value
       ```java
       public TreeNode delete(TreeNode root, int val) {
           if (root == null) return null;
           if (val < root.val) {
               root.left = delete(root.left, val);
           } else if (val > root.val) {
               root.right = delete(root.right, val);
           } else {
               // Node with only one child or no child
               if (root.left == null) return root.right;
               else if (root.right == null) return root.left;
    
               // Node with two children: Get the inorder successor (smallest in the right subtree)
               root.val = minValue(root.right);
    
               // Delete the inorder successor
               root.right = delete(root.right, root.val);
           }
           return root;
         }
         ```