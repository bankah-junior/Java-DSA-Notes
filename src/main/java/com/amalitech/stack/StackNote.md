# Stack Data Structure

---

## Overview

A **Stack** is a linear data structure that follows the principle:

> **LIFO — Last In, First Out**

This means the last element added to the stack is the **first one to be removed**.

A stack can be visualized like a **stack of plates**:

* You place a plate on top
* You remove the topmost plate first

---

## Basic Operations on Stack

| Operation    | Description                                    |
| ------------ | ---------------------------------------------- |
| `push`       | Add an element to the top of the stack         |
| `pop`        | Remove the top element from the stack          |
| `peek / top` | View the top element without removing it       |
| `isEmpty`    | Check if the stack is empty                    |
| `isFull`     | Check if the stack is full (array-based stack) |

---

## Stack Representation

### Logical View

```
Top
 ↑
|  30 |
|  20 |
|  10 |
 -----
```

---

## Stack Implementation Methods

### 1️⃣ Array-Based Stack

* Uses a fixed-size array
* Maintains an index called `top`

**Pros:**

* Fast access
* Simple implementation

**Cons:**

* Fixed size
* Possible overflow

---

### 2️⃣ Linked List–Based Stack

* Uses linked list nodes
* Top of stack is the head node

**Pros:**

* Dynamic size
* No overflow (until memory runs out)

**Cons:**

* Extra memory for pointers

---

## Time Complexity of Stack Operations

| Operation | Time Complexity |
| --------- | --------------- |
| Push      | O(1)            |
| Pop       | O(1)            |
| Peek      | O(1)            |

---

## Applications of Stack

* Function calls (Call Stack)
* Expression evaluation (postfix, prefix)
* Undo / Redo operations
* Syntax parsing
* Backtracking algorithms
* Reversal of data (strings, lists)

---

## Advantages of Stack

* Simple and efficient
* Fast insertion and deletion
* Useful in recursive algorithms

---

## Disadvantages of Stack

* Limited access (only top element)
* Fixed size in array implementation

---

## Stack vs Queue

| Feature   | Stack | Queue   |
| --------- | ----- | ------- |
| Principle | LIFO  | FIFO    |
| Insertion | Push  | Enqueue |
| Deletion  | Pop   | Dequeue |

---

## Summary

A stack is a fundamental data structure used extensively in computer science. Its LIFO behavior makes it ideal for managing temporary data, recursive processes, and backtracking problems.
