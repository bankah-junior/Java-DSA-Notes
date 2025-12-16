# 🧠 Problem Breakdown

You are given:

* An array `nums` of **positive integers**
* An integer `k`

You must:

1. Find the **k-th smallest element** → this is the **pivot `P`**
2. Partition the array into:

    * **A**: elements `≤ P`
    * **B**: elements `> P`
3. Compute the **sum difference** after deciding where `P` finally belongs:

    * `P` goes to the **larger-sum side**
    * If sums are equal → `P` goes to **A**

Goal:

```
minimize | Sum(A) − Sum(B) |
```

---

# 🔑 Key Observations

### 1️⃣ You do NOT need to fully sort

* Sorting costs **O(n log n)**
* We only need the **k-th smallest**
* This is a perfect use case for **QuickSelect** → **average O(n)**

---

### 2️⃣ Partitioning is value-based, not index-based

Unlike classic Quick Sort (which rearranges positions), we only care about:

* Values `≤ P`
* Values `> P`

The **original order does not matter**

---

### 3️⃣ Pivot placement is decided AFTER summing

We first:

* Partition **including the pivot**
* Compute sums
  Then:
* Remove `P` from its group
* Add it to the group with the **larger sum**

This ensures the **absolute difference is minimized**

---

# 🪜 Step-by-Step Solution Strategy

---

## Step 1: Find the k-th smallest element (Pivot `P`)

Use **QuickSelect**:

* Pick a pivot
* Partition array
* Recurse only into the side that contains the k-th element

This avoids full sorting.

---

## Step 2: Partition values using `P`

Traverse the array:

* If `num ≤ P` → add to `A`
* Else → add to `B`

Also compute:

```
sumA, sumB
```

---

## Step 3: Decide where the pivot belongs

Initially, `P` is included in `A`.

Compare:

* If `sumA > sumB` → move `P` to `B`
* Else → keep `P` in `A`

Recalculate sums accordingly.

---

## Step 4: Return absolute difference

```
| sumA − sumB |
```

---

# ✅ Worked Example

### Input

```
nums = [8, 3, 1, 5, 2]
k = 3
```

### Step 1: QuickSelect

Sorted order (conceptually):

```
[1, 2, 3, 5, 8]
```

So:

```
P = 3
```

---

### Step 2: Partition

```
A = [3, 1, 2] → sumA = 6
B = [8, 5]    → sumB = 13
```

---

### Step 3: Pivot placement

Since `sumB > sumA`, move `P` to `B`:

```
A_final = [1, 2]       → sumA = 3
B_final = [8, 5, 3]    → sumB = 16
```

---

### Step 4: Difference

```
|3 − 16| = 13
```

✔️ Final Answer: **13**

---

# 🧪 Java Implementation (QuickSelect-Based)

```java
QuickSort.java
```

---

# ⏱️ Complexity Analysis

| Aspect            | Complexity          |
| ----------------- | ------------------- |
| QuickSelect (avg) | **O(n)**            |
| Partition + Sum   | **O(n)**            |
| Total Time        | **O(n)**            |
| Space             | **O(1)** (in-place) |

---

# 🌟 Why This Solution Is “Unique”

* Uses **QuickSelect**, not sorting
* Separates **pivot discovery** from **pivot placement**
* Handles **duplicates safely**
* Keeps logic simple and interview-friendly
