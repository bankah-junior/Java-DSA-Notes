# 🌡️ Stack Question: The Monotonic Challenge

## Daily Temperatures

---

## 📘 Problem Description

You are given an array `temperatures` where `temperatures[i]` represents the temperature on the **i-th day**.

For each day `i`, determine how many days you have to wait until a **warmer temperature** occurs.
If there is no future day with a warmer temperature, return `0` for that day.

---

## 🎯 Objective

* Solve the problem in **O(n)** time complexity
* Use a **Monotonic Stack**

---

## 🧠 Key Idea: Monotonic Stack

A **monotonic decreasing stack** is used to keep track of indices of days whose temperatures have **not yet found a warmer day**.

### Stack Rule

* The stack stores **indices**, not temperatures
* Temperatures at those indices are in **decreasing order**
* When a warmer temperature is found:

    * Pop from the stack
    * Calculate the number of days waited

---

## 🧩 Algorithm

1. Initialize an array `answer` with all zeros
2. Create an empty stack to store indices
3. Traverse the temperature array from left to right
4. While:

    * Stack is not empty **and**
    * Current temperature > temperature at stack’s top index
      → Pop index and compute waiting days
5. Push the current index onto the stack
6. Remaining indices in the stack have no warmer future day → answer stays `0`

---

## ✏️ Dry Run (Example 1)

**Input**

```
[73, 74, 75, 71, 69, 72, 76, 73]
```

* Day 0 (73) → warmer at day 1 → wait 1
* Day 2 (75) → warmer at day 6 → wait 4
* Day 6 (76) → no warmer day → 0

---

## ✅ Output

```
[1, 1, 4, 2, 1, 1, 0, 0]
```

---

## ⏱ Complexity Analysis

| Metric           | Value                |
| ---------------- | -------------------- |
| Time Complexity  | **O(n)**             |
| Space Complexity | **O(n)**             |
| Stack Type       | Monotonic Decreasing |

---

## 🏆 Why This Works Efficiently

* Each index is **pushed once** and **popped once**
* No nested loops
* Perfect use case for **Monotonic Stack**
* Scales to `10⁵` elements easily

---

## 🧠 Summary

* This problem is a **classic Monotonic Stack application**
* Stack helps track unresolved days efficiently
* Ideal for interviews and competitive programming
