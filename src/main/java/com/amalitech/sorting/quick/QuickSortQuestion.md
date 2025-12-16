# **Quick Sort Question: Pivot Selection and Subarray Sum**

## **Question Title**

**Minimum Subarray Sum Difference after Partition**

---

## **Description**

Given an array of positive integers `nums` and an integer `k`, you must partition the array into two **non-empty subarrays**, `A` and `B`, such that:

* All elements in **A** are **less than or equal to** a chosen pivot `P`.
* All elements in **B** are **greater than** the chosen pivot `P`.
* The pivot `P` must be one of the elements in the original `nums` array.
* The pivot `P` must be the **k-th smallest element** in the original `nums` array (1-indexed).

Your task is to find the **minimum absolute difference** between the sum of elements in subarray `A` and the sum of elements in subarray `B`:

[
| \text{Sum}(A) - \text{Sum}(B) |
]

The pivot `P` belongs to the subarray with the **larger sum**, or arbitrarily to `A` if the sums are equal **before including `P`**.

---

## **Example**

### **Input**

```text
nums = [8, 3, 1, 5, 2]
k = 3
```

### **Step 1: Find the k-th Smallest Element (Pivot `P`)**

The sorted array is:

```text
[1, 2, 3, 5, 8]
```

The 3rd smallest element is:

```text
P = 3
```

---

### **Step 2: Partition**

* **A (elements ≤ 3):** `[3, 1, 2]`
* **B (elements > 3):** `[8, 5]`

---

### **Step 3: Calculate Sums**

* `Sum(A) = 3 + 1 + 2 = 6`
* `Sum(B) = 8 + 5 = 13`

---

### **Step 4: Determine Final Subarrays**

Since `Sum(B)` is larger, the pivot `P = 3` goes to **B**:

* `A_final = [1, 2]`, `Sum(A_final) = 3`
* `B_final = [8, 5, 3]`, `Sum(B_final) = 16`

---

### **Step 5: Calculate Difference**

[
| 3 - 16 | = 13
]

---

## **Output**

```text
13
```

---

## **Constraints**

* ( 1 \le \text{nums.length} \le 10^4 )
* ( 1 \le k \le \text{nums.length} )
* ( 1 \le \text{nums}[i] \le 10^3 )

---

## **Hint**

You do **not** need to fully sort the array.
The requirement to find the **k-th smallest element** and partition the array suggests using **QuickSelect** (a variation of Quick Sort) and its partitioning scheme.
