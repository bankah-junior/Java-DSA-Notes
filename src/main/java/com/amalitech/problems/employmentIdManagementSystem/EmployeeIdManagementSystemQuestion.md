# 🧑‍💼 Employee ID Management System

**Difficulty:** Medium  
**Topics:** Binary Search Tree (BST), Recursion, Tree Traversal, Linked Structure  

---

## 🧩 Problem Statement

A human resources department needs an efficient system to manage employee records.  
Each employee is identified by a **unique employee ID**, and the system must support **fast insertions, lookups, and queries**.

You are required to implement an **Employee ID Management System** that supports the following operations efficiently.

---

## 🔧 Supported Operations

- **REGISTER id salary**  
  Add an employee with the given ID and salary.  
  If the ID already exists, **update** the employee’s salary.

- **LOOKUP id**  
  Find an employee by ID and report their salary.

- **RANGE low high**  
  Find all employees with IDs in the range **[low, high]** (inclusive) and list them in ascending order.

- **HEIGHT**  
  Report the **maximum height** of the data structure.

- **PATH id**  
  Show the **navigation path** taken to reach a specific employee ID.

- **DISPLAY**  
  Display **all employees sorted by ID** in ascending order.

---

## 📥 Input Format

- The first line contains an integer `N` (`1 ≤ N ≤ 1000`) — number of operations.
- The next `N` lines each contain one operation:

```

REGISTER id salary
LOOKUP id
RANGE low high
HEIGHT
PATH id
DISPLAY

```

### Constraints
- `1 ≤ id ≤ 1,000,000`
- `1,000 ≤ salary ≤ 500,000`

- Input ends when `N = 0`.

---

## 📤 Output Format

For each test case:

- Print:
```

Case X:

````
where `X` is the test case number (starting from 1)

- Output for each operation:

| Operation | Output |
|--------|--------|
| REGISTER | `Registered: ID=X, Salary=Y` |
| LOOKUP | `Found: ID=X, Salary=Y` or `Not found: ID=X` |
| RANGE | `Range [X-Y]: [comma-separated list of IDs]` or `Range [X-Y]: none` |
| HEIGHT | `Tree height: H` |
| PATH | `Path to X: [comma-separated path of IDs]` or `Path to X: not found` |
| DISPLAY | `All employees: [comma-separated list of all IDs]` |

- Print a **blank line** after each test case.

---

## 🧪 Sample Input

```text
10
REGISTER 50000 75000
REGISTER 30000 65000
REGISTER 70000 80000
REGISTER 20000 55000
REGISTER 40000 70000
LOOKUP 30000
RANGE 25000 45000
HEIGHT
PATH 20000
DISPLAY
8
REGISTER 10000 50000
REGISTER 5000 45000
REGISTER 15000 60000
REGISTER 2500 40000
LOOKUP 20000
RANGE 5000 15000
HEIGHT
DISPLAY
0
````

---

## 🧾 Sample Output

```text
Case 1:
Registered: ID=50000, Salary=75000
Registered: ID=30000, Salary=65000
Registered: ID=70000, Salary=80000
Registered: ID=20000, Salary=55000
Registered: ID=40000, Salary=70000
Found: ID=30000, Salary=65000
Range [25000-45000]: [30000, 40000]
Tree height: 2
Path to 20000: [50000, 30000, 20000]
All employees: [20000, 30000, 40000, 50000, 70000]

Case 2:
Registered: ID=10000, Salary=50000
Registered: ID=5000, Salary=45000
Registered: ID=15000, Salary=60000
Registered: ID=2500, Salary=40000
Not found: ID=20000
Range [5000-15000]: [5000, 10000, 15000]
```

---

## 🧠 Key Concepts Used

* **Binary Search Tree (BST)** for ordered storage and fast lookup
* **Recursion** for insert, search, and traversal
* **In-order traversal** for sorted output
* **Path tracking** using recursive descent
* **Height calculation** via depth recursion

---

✨ *This problem closely mirrors real-world database indexing and is excellent practice for mastering BST-based systems.*

