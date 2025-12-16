## 🚀 What is Quick Sort?

**High-level idea**:

1.  **Pick a pivot** from the array.
2.  **Partition** the array into elements **less than** the pivot and **greater than** the pivot (equal elements grouped appropriately).
3.  Recursively sort the left and right partitions.

It’s usually very fast in practice due to good cache locality and average-case `O(n log n)` time.

***

## 🧠 Partition Schemes (Two Popular Choices)

### 1) **Lomuto partition** (simple, easy to read)

*   Pivot: commonly the **last** element.
*   One pass moves smaller elements to the left of a pointer.
*   **Pros:** Simple to implement.
*   **Cons:** Can perform poorly with many equal elements; more swaps than Hoare.

### 2) **Hoare partition** (classic, fewer swaps)

*   Pivot: commonly the **first** element (or any fixed choice).
*   Uses **two indices** moving inward; swaps out-of-place elements.
*   **Pros:** Often fewer swaps; performs better on some distributions.
*   **Cons:** Returns a partition index `p` where the pivot’s final position isn’t guaranteed to be exactly `p`; recursive ranges differ slightly.

***

## ⏱️ Complexity & Properties

*   **Average time:** `O(n log n)`
*   **Worst time:** `O(n²)` (e.g., already sorted with poor pivot strategy such as always taking first/last)
*   **Space (stack):** `O(log n)` average; `O(n)` worst (recursion depth)
*   **In-place:** Yes (array sorted without extra significant memory)
*   **Stable:** No (equal elements may be reordered)
*   **Improvements:**
    *   Use **randomized pivot** to reduce worst-case probability.
    *   Use **median-of-three** pivot for better practical performance.
    *   **Tail recursion elimination** or **iterative version** to avoid deep recursion.
    *   Switch to **Insertion Sort** for very small partitions (e.g., size ≤ 10) to speed up.

***

## ✅ Quick Sort with **Lomuto** Partition (Java)

```java
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortLomuto {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int p = partition(arr, lo, hi);   // lomuto
        quickSort(arr, lo, p - 1);
        quickSort(arr, p + 1, hi);
    }

    // Lomuto partition: pivot is arr[hi]
    private static int partition(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo; // position to place next smaller element
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) { // <= keeps duplicates near pivot
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i; // pivot final index
    }

    // Optional: randomized pivot to avoid worst-case on adversarial inputs
    public static void quickSortRandomized(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSortRandomized(arr, 0, arr.length - 1);
    }

    private static void quickSortRandomized(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        // pick random pivot index and move it to hi
        int pivotIndex = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        swap(arr, pivotIndex, hi);
        int p = partition(arr, lo, hi);
        quickSortRandomized(arr, lo, p - 1);
        quickSortRandomized(arr, p + 1, hi);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 4, 8, 2, 6, 5};
        quickSort(arr);
        System.out.println("Lomuto: " + Arrays.toString(arr));

        int[] arr2 = {9, 3, 7, 1, 4, 8, 2, 6, 5};
        quickSortRandomized(arr2);
        System.out.println("Randomized Lomuto: " + Arrays.toString(arr2));
    }
}
```

**Notes:**

*   The `<=` comparison keeps duplicates on the left side; this helps avoid worst-case behavior in some distributions but still not truly “3-way”.
*   Randomization greatly reduces the chance of consistently hitting worst-case partitions.

***

## ✅ Quick Sort with **Hoare** Partition (Java)

```java
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortHoare {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        if (lo >= hi) return;
        int p = partitionHoare(arr, lo, hi);
        // Hoare partition returns a split index; recurse on [lo, p] and [p+1, hi]
        quickSort(arr, lo, p);
        quickSort(arr, p + 1, hi);
    }

    // Hoare partition: pivot is arr[lo]
    private static int partitionHoare(int[] arr, int lo, int hi) {
        int pivot = arr[lo];
        int i = lo - 1;
        int j = hi + 1;
        while (true) {
            // move i right to find element >= pivot
            do { i++; } while (arr[i] < pivot);
            // move j left to find element <= pivot
            do { j--; } while (arr[j] > pivot);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    // Optional: randomized pivot—swap random element into lo as pivot
    private static int partitionHoareRandomPivot(int[] arr, int lo, int hi) {
        int pivotIndex = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        swap(arr, lo, pivotIndex);
        int pivot = arr[lo];
        int i = lo - 1, j = hi + 1;
        while (true) {
            do { i++; } while (arr[i] < pivot);
            do { j--; } while (arr[j] > pivot);
            if (i >= j) return j;
            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 4, 8, 2, 6, 5};
        quickSort(arr);
        System.out.println("Hoare: " + Arrays.toString(arr));
    }
}
```

**Notes:**

*   Hoare’s scheme often does fewer swaps than Lomuto.
*   The recursive ranges are **\[lo, p]** and **\[p+1, hi]**, not `p-1`/`p+1` around the exact pivot index since the pivot might not be at `p`.

***

## 🎯 Handling Many Duplicates (3-Way Partition)

Arrays with many duplicates can degrade standard quicksort. A **Dutch National Flag** / **3-way partition** separates into `< pivot`, `== pivot`, and `> pivot` in one pass—this is excellent when duplicates are abundant.

```java
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class QuickSortThreeWay {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        quickSort3(arr, 0, arr.length - 1);
    }

    private static void quickSort3(int[] a, int lo, int hi) {
        if (lo >= hi) return;

        // Randomized pivot
        int pivotIndex = ThreadLocalRandom.current().nextInt(lo, hi + 1);
        int pivot = a[pivotIndex];

        int lt = lo, i = lo, gt = hi;
        while (i <= gt) {
            if (a[i] < pivot) swap(a, lt++, i++);
            else if (a[i] > pivot) swap(a, i, gt--);
            else i++;
        }
        // Now: [lo..lt-1] < pivot, [lt..gt] == pivot, [gt+1..hi] > pivot
        quickSort3(a, lo, lt - 1);
        quickSort3(a, gt + 1, hi);
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 5, 2, 5, 1, 5, 4, 5};
        quickSort(arr);
        System.out.println("3-way: " + Arrays.toString(arr));
    }
}
```

***

## 🔄 Iterative Quick Sort (Avoid Deep Recursion)

This uses an explicit stack to store ranges:

```java
import java.util.Arrays;
import java.util.ArrayDeque;

public class QuickSortIterative {
    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) return;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        stack.push(new int[]{0, arr.length - 1});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            int lo = range[0], hi = range[1];
            if (lo >= hi) continue;

            int p = partitionLomuto(arr, lo, hi); // choose any partition scheme

            // Push larger side first (optional heuristic to keep stack small)
            if (p - 1 - lo > hi - (p + 1)) {
                stack.push(new int[]{lo, p - 1});
                stack.push(new int[]{p + 1, hi});
            } else {
                stack.push(new int[]{p + 1, hi});
                stack.push(new int[]{lo, p - 1});
            }
        }
    }

    private static int partitionLomuto(int[] arr, int lo, int hi) {
        int pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j] <= pivot) { swap(arr, i, j); i++; }
        }
        swap(arr, i, hi);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) { int t = arr[i]; arr[i] = arr[j]; arr[j] = t; }
    }

    public static void main(String[] args) {
        int[] arr = {9, 3, 7, 1, 4, 8, 2, 6, 5};
        quickSort(arr);
        System.out.println("Iterative: " + Arrays.toString(arr));
    }
}
```

***

## 🛠️ Practical Tips

*   **Pivot selection matters**: Random pivot or median-of-three (first, middle, last) helps avoid worst cases.
*   **Small partitions**: Switch to **Insertion Sort** when subarray length is tiny (e.g., ≤ 10).
*   **Stability**: If you need stability, choose **Merge Sort** instead.
*   **Safety**: Always check bounds and avoid unnecessary swaps.

***

## ✅ When to Use Quick Sort

*   When you need **fast average performance** and **in-place** sorting for arrays.
*   Suitable for large arrays where **cache locality** helps.
*   Less ideal when worst-case guarantees are required (then prefer Merge Sort/Heapsort) or when **stability** is essential.
