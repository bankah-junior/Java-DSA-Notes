
# **Queue in Java**

A queue is a linear data structure that follows the **First-In, First-Out (FIFO)** principle—similar to a line of people waiting for service. In Java, `Queue` is an interface in the Java Collections Framework, and several classes implement it to provide queue functionality.

---

## **Key Concepts**

* **FIFO (First-In, First-Out):** The element added first is removed first.
* **Front (Head):** The end of the queue where elements are removed.
* **Rear (Tail/Back):** The end where elements are inserted.
* **Enqueue:** Adding an element to the rear of the queue.
* **Dequeue:** Removing an element from the front of the queue.
* **IsEmpty:** Checks if the queue has no elements.
* **IsFull:** Checks if the queue is full (applicable for fixed-size queues).
* **Display:** Prints all the items in the queue.

---

## **Core Methods**

The `Queue` interface provides methods in two forms—one that throws exceptions and one that returns special values when operations fail.

| Operation | Throws Exception | Returns Special Value | Description                           |
| --------- | ---------------- | --------------------- | ------------------------------------- |
| Insert    | `add(E e)`       | `offer(E e)`          | Inserts an element into the queue     |
| Remove    | `remove()`       | `poll()`              | Retrieves and removes the head        |
| Inspect   | `element()`      | `peek()`              | Retrieves (without removing) the head |

---

## Types of Queues

### 1️⃣ Simple Queue

* Insertion at rear
* Deletion from front

---

### 2️⃣ Circular Queue

* Last position connects back to the first
* Efficient memory utilization

```
Front → | 10 | 20 | 30 | ← Rear
          ↑             ↓
          └─────────────┘
```

---

### 3️⃣ Priority Queue

* Each element has a priority
* Higher priority elements are dequeued first

---

### 4️⃣ Deque (Double-Ended Queue)

* Insertion and deletion at both ends

---

### Logical View

```
Front → | 10 | 20 | 30 | ← Rear
```

---

## Queue Implementation Methods

### 1️⃣ Array-Based Queue

* Uses a fixed-size array
* Maintains `front` and `rear` indices

**Pros:**

* Simple implementation

**Cons:**

* Fixed size
* Possible wasted space (simple queue)

---

### 2️⃣ Linked List–Based Queue

* Uses linked list nodes
* Front = head, Rear = tail

**Pros:**

* Dynamic size
* Efficient memory usage

**Cons:**

* Extra memory for pointers

---

## **Implementations in Java**

Since `Queue` is an interface, it must be implemented by a class:

* **LinkedList**
  Uses a linked list structure. Not capacity-restricted and grows dynamically.

* **PriorityQueue**
  Orders elements based on priority (natural order or custom `Comparator`). Not strictly FIFO.

* **ArrayDeque**
  A resizable array implementing `Deque`. Usually faster than `LinkedList` for queue operations.

* **BlockingQueue**
  Located in `java.util.concurrent`. Thread-safe queues with blocking operations when full or empty.

---

## Time Complexity of Queue Operations

| Operation | Time Complexity |
| --------- | --------------- |
| Enqueue   | O(1)            |
| Dequeue   | O(1)            |
| Peek      | O(1)            |

---

## **Common Applications**

Queues are used widely across computing for ordered processing:

* **CPU & Disk Scheduling** — Manages process/task order.
* **Printer Queues** — Ensures jobs print in order.
* **Data Buffering** — Useful in asynchronous data transfer (e.g., keyboard buffer).
* **Breadth-First Search (BFS)** — Traverses graphs level by level using a queue.

---

## Advantages of Queue

* Simple and efficient
* Fair processing (FIFO order)
* Useful for scheduling tasks

---

## Disadvantages of Queue

* Limited access (only front element)
* Fixed size in array-based implementation

---

## Queue vs Stack

| Feature   | Queue   | Stack |
| --------- | ------- | ----- |
| Principle | FIFO    | LIFO  |
| Insertion | Enqueue | Push  |
| Deletion  | Dequeue | Pop   |

---

## Summary

A queue is a fundamental data structure used when **order matters**. Its FIFO behavior makes it ideal for scheduling, buffering, and breadth-first processing tasks in computer science.


