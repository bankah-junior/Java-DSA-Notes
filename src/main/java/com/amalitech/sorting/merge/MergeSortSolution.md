## Big Idea (What We’re Trying to Achieve)

For every element `nums[i]`, we want:

> **How many elements to the right of it are smaller than it?**

A brute-force approach would check all pairs → **O(n²)** ❌
But with **Merge Sort**, we can do this in **O(n log n)** ✅

---

## Key Insight (Very Important)

Merge Sort works by:

1. Dividing the array into halves
2. Sorting each half
3. **Merging** two sorted halves

👉 The **magic happens during the merge step**.

### Why?

When merging two sorted halves:

* Left half = elements originally on the **left**
* Right half = elements originally on the **right**

If:

```
left[i] > right[j]
```

then:

* `right[j]` is **smaller**
* AND it appears **to the right** of `left[i]` in the original array
* AND because the right half is sorted, **all remaining elements from j onward are also smaller**

So:

```
count[left[i]] += (number of remaining elements in right half)
```

---

## Strategy Overview

### Step 1: Track original positions

We must remember **where each number came from**, because Merge Sort rearranges elements.

So instead of sorting numbers directly, we sort **(value, originalIndex)** pairs.

---

### Step 2: Use Merge Sort

* Recursively split the array
* During merge:

    * Compare values
    * When left value > right value → update count

---

### Step 3: Store results

Maintain a `counts[]` array where:

```
counts[i] = number of smaller elements to the right of nums[i]
```

---

## Step-by-Step Example

### Input

```
nums = [5, 2, 6, 1]
```

We convert it into:

```
[(5,0), (2,1), (6,2), (1,3)]
```

### During merge:

* `5 > 2` → count[0] += 1
* `6 > 1` → count[2] += 1
* `5 > 1` → count[0] += 1

Final result:

```
counts = [2, 1, 1, 0]
```

---

## Java Implementation (Clean & Interview-Ready)

```java
MergeSort.java
```

---

## Time & Space Complexity

| Metric          | Complexity     |
| --------------- | -------------- |
| Time            | **O(n log n)** |
| Space           | **O(n)**       |
| Stable          | Yes            |
| Uses Merge Sort | ✅              |

---

## Why This Solution Is “Unique”

* No Binary Indexed Tree
* No Segment Tree
* Pure **Merge Sort logic**
* Counts collected **naturally during merge**
* Very interview-friendly explanation
