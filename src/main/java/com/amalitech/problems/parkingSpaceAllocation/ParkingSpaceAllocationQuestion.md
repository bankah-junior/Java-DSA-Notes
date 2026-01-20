# 🚗 Parking Space Allocation

**Topics:** Arrays, Sorting, Greedy Algorithms  

---

## 🧩 Problem Statement

A parking garage needs to assign vehicles to parking spaces.  
The garage has **N parking spaces**, each with a specific size (length in feet), and **M vehicles**, each with a known length.

Your task is to assign vehicles to parking spaces such that:

- Each vehicle is assigned to a space that can **accommodate it**  
  (`space length ≥ vehicle length`)
- Each parking space can be assigned to **only one vehicle**
- The goal is to **maximize the number of vehicles parked**
- Among all optimal solutions, **minimize the total wasted space**  
  (sum of unused length across all assigned spaces)

---

## 📥 Input Format

- The first line contains two integers:
```

N M

````
where  
`1 ≤ N ≤ 1000` → number of parking spaces  
`1 ≤ M ≤ 1000` → number of vehicles

- The second line contains **N pairs**:
- Space identifier (1–10 alphanumeric characters, e.g., `A1`, `SPOT5`)
- Length of the space in feet (`5 ≤ length ≤ 50`)

- The third line contains **M pairs**:
- Vehicle identifier (1–10 alphanumeric characters, e.g., `CAR1`, `TRUCK`)
- Length of the vehicle in feet (`5 ≤ length ≤ 50`)

- Input ends when both `N` and `M` are zero.

---

## 📤 Output Format

For each test case, print **three lines**:

1. ```
 Case X: Y vehicles parked


2. ```
   Total wasted space: Z feet
   
3. ```
   Assignments: [list of assignments]
   ```

   or

   ```
   Assignments: none
   ```

### Where:

* `X` → test case number (starting from 1)
* `Y` → number of vehicles successfully parked
* `Z` → total unused space in feet
* Assignments are in the format:

  ```
  VEHICLE->SPACE
  ```

  sorted **alphabetically by vehicle identifier**

---

## 🧪 Sample Input

```text
5 5
A1 20 A2 25 A3 18 B1 30 B2 22
CAR1 18 CAR2 24 SUV1 16 TRUCK 28 VAN 21
3 4
P1 15 P2 20 P3 25
V1 22 V2 18 V3 14 V4 12
2 2
SPOT1 30 SPOT2 40
BIG 45 SMALL 25
0 0
```

---

## 🧾 Sample Output

```text
Case 1: 5 vehicles parked
Total wasted space: 13 feet
Assignments: CAR1->A1 CAR2->A2 SUV1->A3 TRUCK->B1 VAN->B2

Case 2: 3 vehicles parked
Total wasted space: 8 feet
Assignments: V2->P2 V3->P1 V4->P3

Case 3: 1 vehicles parked
Total wasted space: 15 feet
Assignments: SMALL->SPOT1
```

---

## 📝 Explanation

### Case 1

* All 5 vehicles can be parked
* Example assignments:

    * `SUV1(16) → A3(18)` → waste = 2
    * `CAR1(18) → A1(20)` → waste = 2
    * `VAN(21) → B2(22)` → waste = 1
    * `CAR2(24) → A2(25)` → waste = 1
    * `TRUCK(28) → B1(30)` → waste = 2
* Total wasted space is minimized while parking all vehicles

### Case 2

* Only 3 spaces for 4 vehicles
* Best assignment parks the **maximum number of vehicles** with minimal waste

### Case 3

* `BIG(45)` cannot fit in any space
* `SMALL(25)` fits in `SPOT1(30)` → waste = 5

---

💡 *This problem is a classic application of greedy algorithms using sorting to achieve optimal assignments efficiently.*

