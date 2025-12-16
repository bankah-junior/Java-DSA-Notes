# **Binary Search in Java**

Binary Search is an efficient searching algorithm used on **sorted arrays or lists**. It repeatedly divides the search interval in half, eliminating large portions of the data with each comparison. This makes it significantly faster than Linear Search.

---

## **Key Concepts**

* **Requires Sorted Data:** Binary search only works on data sorted in ascending or descending order.
* **Divide and Conquer:** The algorithm splits the search space in half each step.
* **Time Complexity:**

    * **Best Case:** O(1) (middle element is the target)
    * **Average/Worst Case:** O(log n)
* **Space Complexity:**

    * **Iterative Version:** O(1)
    * **Recursive Version:** O(log n) (due to call stack)

---

## **Algorithm Steps**

1. Set two pointers: **low** at the start and **high** at the end of the array.
2. Calculate the **mid** index: `mid = (low + high) / 2`.
3. Compare `arr[mid]` with the target:

    * If equal → target found.
    * If target is smaller → search the left half (high = mid - 1).
    * If target is larger → search the right half (low = mid + 1).
4. Repeat until low > high.
5. If no match is found, return -1.

---

## **Java Implementation (Iterative Approach)**

```java
public class BinarySearch {

    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // prevents overflow

            if (arr[mid] == target) {
                return mid; // found the target
            }
            if (arr[mid] < target) {
                low = mid + 1; // search right half
            } else {
                high = mid - 1; // search left half
            }
        }

        return -1; // target not found
    }

    public static void main(String[] args) {
        int[] sortedNumbers = {2, 4, 7, 10, 14, 21};
        int target = 10;

        int result = binarySearch(sortedNumbers, target);

        if (result != -1)
            System.out.println("Element found at index: " + result);
        else
            System.out.println("Element not found.");
    }
}
```

---

## **Java Implementation (Recursive Approach)**

```java
public class BinarySearchRecursive {

    public static int binarySearch(int[] arr, int low, int high, int target) {
        if (low > high) {
            return -1; // not found
        }

        int mid = low + (high - low) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearch(arr, mid + 1, high, target);
        } else {
            return binarySearch(arr, low, mid - 1, target);
        }
    }

    public static void main(String[] args) {
        int[] sortedNumbers = {2, 4, 7, 10, 14, 21};
        int target = 21;

        int result = binarySearch(sortedNumbers, 0, sortedNumbers.length - 1, target);

        System.out.println(result != -1 ? "Found at index: " + result : "Not found.");
    }
}
```

---

## **Advantages**

* Very fast for large datasets due to O(log n) time.
* Efficient for repeated searches on static/sorted data.
* Easy to implement both iteratively and recursively.

---

## **Disadvantages**

* Works **only** on sorted data.
* Not suitable for frequently changing datasets (re-sorting required).
* More complex than Linear Search.

---

## **Common Applications**

* Searching in sorted arrays/lists.
* Database indexing.
* Looking up words in dictionaries.
* Used internally in Java's `Collections.binarySearch()` and in many algorithms relying on ordered data.
