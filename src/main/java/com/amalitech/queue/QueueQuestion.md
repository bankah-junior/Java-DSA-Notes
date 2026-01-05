# 🦠 Queue Question: The Spreading Infection

## Rotting Oranges

---

## 📘 Problem Description

You are given an `m × n` grid where each cell can be:

* `0` → Empty cell
* `1` → Fresh orange
* `2` → Rotten orange

Every **minute**, a fresh orange that is **4-directionally adjacent** (up, down, left, right) to a rotten orange becomes rotten.

---

## 🎯 Objective

Return the **minimum number of minutes** required so that **no fresh orange remains**.

* If it is **impossible** to rot all fresh oranges, return `-1`.

---

## 🧠 Key Insight: Multi-Source BFS (Queue)

This is a **classic Breadth-First Search (BFS)** problem:

* All initially rotten oranges act as **multiple sources**
* Each BFS level represents **1 minute**
* Fresh oranges rot layer by layer

👉 A **Queue** is perfect for this.

---

## 🧩 Algorithm (Step-by-Step)

1. Traverse the grid:

    * Add all **rotten oranges (2)** to a queue
    * Count the number of **fresh oranges**
2. Perform BFS:

    * Process the queue **level by level**
    * Each level = **1 minute**
    * Rot all adjacent fresh oranges
3. Decrease fresh count when an orange rots
4. Stop when:

    * No fresh oranges remain → return minutes
    * BFS ends but fresh oranges remain → return `-1`

---

## ✏️ Directions Array (4-Directional)

```text
Up    → (-1, 0)
Down  → ( 1, 0)
Left  → ( 0,-1)
Right → ( 0, 1)
```

---

## ▶️ Example Walkthrough

### Example 1

**Input**

```
[[2,1,1],
 [1,1,0],
 [0,1,1]]
```

**Output**

```
4
```

All fresh oranges are reached layer by layer.

---

### Example 2

**Input**

```
[[2,1,1],
 [0,1,1],
 [1,0,1]]
```

**Output**

```
-1
```

One fresh orange is isolated → impossible to rot.

---

## ⏱ Complexity Analysis

| Metric           | Value            |
| ---------------- | ---------------- |
| Time Complexity  | **O(m × n)**     |
| Space Complexity | **O(m × n)**     |
| Technique        | Multi-Source BFS |

---

## 🏆 Why This Works

✔ Queue ensures correct BFS order
✔ Each cell processed once
✔ Naturally models time using BFS levels
✔ Scales well within constraints

---

## 🧠 Summary

* This problem is a **perfect Queue + BFS application**
* Multiple starting points → **Multi-Source BFS**
* Each BFS level = **1 minute**
* Return `-1` if any fresh orange remains


