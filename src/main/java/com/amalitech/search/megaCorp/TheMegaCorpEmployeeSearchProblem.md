# **The Problem: "The MegaCorp Employee Search"**

## **The Story**

You are building a **search bar** for a huge company called **MegaCorp**.

The company is organized into **Departments** (like Sales, Engineering, HR).
Some Departments contain **Sub-Departments** (e.g., inside "Engineering," there is "Mobile," "Web," and "AI").

Every Department has **two lists of employees**:

* **Interns (Messy List):** A small list of new interns. These IDs are **not sorted** and are added randomly.
* **Managers (Neat List):** A large list of permanent managers. These IDs are **sorted** (101, 102, 103...) to make them easy to search.

**Your Job:** Write a function that searches the entire company (every department and sub-department) to determine if **Employee ID #88** exists.

---

## **The Data Structure (Conceptual)**

Imagine the company structure as a **tree**:

```java
class Department {
    String name;
    int[] interns;           // Messy list, use Linear Search
    int[] managers;          // Sorted list, use Binary Search
    List<Department> subDepartments; // Nested departments
}
```

Example layout:

* **Head Office**

    * interns: [902, 14, 7]
    * managers: [100, 200, 300, 400, 500]
    * subDepartments:

        * **Marketing**

            * interns: [55, 12]
            * managers: [601, 602, 603]
            * subDepartments: []
        * **Tech**

            * interns: [99]
            * managers: [700, 750, 800]
            * subDepartments:

                * **Tech Support** (could have more nested departments)

---

## **The Rules**

To solve this problem, your code must follow these rules:

1. **Interns are disorganized:**

    * Cannot use shortcuts.
    * Check the interns list **one by one** using **Linear Search**.

2. **Managers are organized:**

    * The managers list is **huge and sorted**.
    * Use **Binary Search** to find the ID efficiently.
    * Do **not** check one by one.

3. **Check everywhere:**

    * If the employee is not found in the current department, you must check **every sub-department recursively**.

---