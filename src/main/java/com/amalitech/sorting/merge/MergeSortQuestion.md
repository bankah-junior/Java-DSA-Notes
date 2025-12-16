# **Merge Sort Question: Counting Inversions**

## **Question Title**

**Count of Smaller Numbers After Self (Modified)**

---

## **Description**

Given an array of integers `nums`, create a new array `counts` such that:

* `counts[i]` is the number of elements **to the right** of `nums[i]` that are **strictly smaller** than `nums[i]`.

---

## **Constraint**

* The solution **must use the Merge Sort algorithm** to achieve efficient performance.

---

## **Example**

### **Input**

```text
nums = [5, 2, 6, 1]
```

### **Output**

```text
counts = [2, 1, 1, 0]
```

### **Explanation**

* For `5`: There are **2** elements to the right (`2` and `1`) that are smaller.
* For `2`: There is **1** element to the right (`1`) that is smaller.
* For `6`: There is **1** element to the right (`1`) that is smaller.
* For `1`: There are **0** elements to the right that are smaller.

---

## **Constraints**

* ( 1 \le \text{nums.length} \le 10^5 )
* ( -10^9 \le \text{nums}[i] \le 10^9 )

---

## **Hint**

Think about what happens when you merge two sorted subarrays **A** and **B**:

* If an element from **A** is placed before an element from **B**,
  how does this relate to the number of elements in **B** that are smaller than the element from **A**?

---

## **Task**

Solve the problem **step by step**, explaining your thought process.
Try to come up with a **unique solution** using **Merge Sort**.
