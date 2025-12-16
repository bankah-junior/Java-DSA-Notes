## 🚀 What is Merge Sort?

**Merge Sort** sorts an array by:

1.  **Divide:** Split the array into two halves.
2.  **Conquer:** Recursively sort each half.
3.  **Combine:** Merge the two sorted halves into one sorted array.

It’s **stable** (preserves equal elements’ order) and guarantees **O(n log n)** time in all cases (best, average, worst).

***

## 🧠 Key Ideas

*   **Merging** is the heart of the algorithm:
    *   Given two sorted subarrays, we merge them into a single sorted array in **linear time**.
*   **Recursion depth** is **log₂ n** (we keep halving).
*   **Extra space**: Needs a temporary array of size **n** during merging (typical implementation is not in-place).

***

## ⏱️ Complexity

*   **Time:** `O(n log n)`
    *   We do `log n` levels of splitting, and merging at each level costs `O(n)` total.
*   **Space:** `O(n)` auxiliary (temporary buffer for merging).
*   **Stable:** Yes (equal elements keep their original order).
*   **Not in-place:** Standard implementations use extra memory.

***

## ✅ Recursive (Top-Down) Merge Sort — Java

This version is straightforward: recursively sort halves and merge them.

```java
import java.util.Arrays;

public class MergeSortRecursive {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int[] temp = new int[arr.length]; // auxiliary buffer
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(int[] arr, int left, int right, int[] temp) {
        if (left >= right) return; // base case: 1 element

        int mid = left + (right - left) / 2;

        // Sort left half and right half
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);

        // Optimization: if already ordered, skip merge
        if (arr[mid] <= arr[mid + 1]) return;

        // Merge sorted halves
        merge(arr, left, mid, right, temp);
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        // Copy the range we will merge into temp
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;      // pointer for left half
        int j = mid + 1;   // pointer for right half
        int k = left;      // write pointer in original array

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }

        // Copy remaining left half (right half already in place if any)
        while (i <= mid) {
            arr[k++] = temp[i++];
        }
        // No need to copy the right half; it's already placed due to temp copy
    }

    // Demo
    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 5, 6};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr)); // [1, 2, 5, 5, 6, 9]
    }
}
```

### Notes

*   The **skip-merge optimization** (`if (arr[mid] <= arr[mid + 1])`) avoids merging when halves are already in order—helpful on nearly sorted inputs.
*   Using a single `temp` array avoids repeated allocations.

***

## 🔄 Iterative (Bottom-Up) Merge Sort — Java

No recursion; we merge subarrays of size 1, then 2, then 4, etc.

```java
import java.util.Arrays;

public class MergeSortIterative {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        int n = arr.length;
        int[] temp = new int[n];

        // width = current size of subarrays to merge: 1, 2, 4, 8, ...
        for (int width = 1; width < n; width <<= 1) {
            for (int left = 0; left < n - width; left += (width << 1)) {
                int mid = left + width - 1;
                int right = Math.min(left + (width << 1) - 1, n - 1);

                // Optimization: if already ordered, skip merge
                if (arr[mid] <= arr[mid + 1]) continue;

                merge(arr, left, mid, right, temp);
            }
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = arr[i];
        }

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) {
                arr[k++] = temp[i++];
            } else {
                arr[k++] = temp[j++];
            }
        }
        while (i <= mid) arr[k++] = temp[i++];
        // Right side residual already in arr via temp copy
    }

    // Demo
    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr)); // [3, 9, 10, 27, 38, 43, 82]
    }
}
```

### Notes

*   **Bottom-up** can be more cache-friendly and avoids recursion overhead.
*   Still **O(n)** extra space due to `temp`.

***

## 🧪 Stability Demonstration

```java
import java.util.Arrays;

class Pair {
    int key;
    int id; // original order marker
    Pair(int key, int id) { this.key = key; this.id = id; }
    public String toString() { return "(" + key + "," + id + ")"; }
}

public class MergeSortStableDemo {
    public static void mergeSort(Pair[] arr) {
        Pair[] temp = new Pair[arr.length];
        mergeSort(arr, 0, arr.length - 1, temp);
    }

    private static void mergeSort(Pair[] arr, int left, int right, Pair[] temp) {
        if (left >= right) return;
        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, temp);
        mergeSort(arr, mid + 1, right, temp);
        if (arr[mid].key <= arr[mid + 1].key) return;
        merge(arr, left, mid, right, temp);
    }

    private static void merge(Pair[] arr, int left, int mid, int right, Pair[] temp) {
        for (int i = left; i <= right; i++) temp[i] = arr[i];
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            // stability: <= picks from left when equal
            if (temp[i].key <= temp[j].key) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }
        while (i <= mid) arr[k++] = temp[i++];
    }

    public static void main(String[] args) {
        Pair[] arr = { new Pair(5,0), new Pair(3,1), new Pair(5,2), new Pair(3,3) };
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        // Expected stable order by key: (3,1), (3,3), (5,0), (5,2)
    }
}
```

***

## 📌 When to Use Merge Sort

*   **Large datasets** where guaranteed `O(n log n)` matters.
*   When **stability** is required (e.g., multi-key sorts).
*   On **linked lists**, merge sort is **in-place (O(1) extra space)** and very efficient (no random access needed).
*   In **external sorting** (files/streams): merge phases are natural.

**When not ideal:**

*   If **in-place** sorting with minimal extra memory is required on arrays (consider **Quick Sort** / **Heap Sort**).
*   If average-case speed and cache behavior favor **Quick Sort** for arrays.

***

## 🎯 Practice Tips

*   Implement both **recursive** and **iterative** versions.
*   Add the **skip-merge optimization** to reduce work on partially sorted data.
*   For linked lists, implement a **merge sort** with split-by-fast/slow pointers and merge two lists.
