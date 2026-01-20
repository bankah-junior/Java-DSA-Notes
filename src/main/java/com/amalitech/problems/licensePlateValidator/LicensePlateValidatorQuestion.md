# 🚗 License Plate Validator

**Difficulty:** Beginner-Friendly  
**Topics:** String Operations, Character Analysis, Validation Rules  

---

## 🧩 Problem Statement

A vehicle registration system needs to **validate and format license plates** from different regions.  
Create a **license plate validator** that checks if plates follow proper formatting rules and converts them into a **standard format**.

---

## 📥 Input Format Rules

A license plate may appear in different forms but must follow these rules:

- May optionally start with a **region code** (2 uppercase letters)
- Must contain **exactly 6 alphanumeric characters** after the region code
- Can contain **spaces**, **hyphens (-)**, or **underscores (_)** as separators
- Must have **at least 2 letters** and **at least 2 digits**
- **No other special characters** are allowed

---

## ✅ Validation Rules

Check the following (in order):

1. **Character Count**  
   - Exactly 6 alphanumeric characters (after region code)

2. **Region Code**  
   - If present, must be **exactly 2 uppercase letters**

3. **Separators**  
   - Only spaces (` `), hyphens (`-`), and underscores (`_`) allowed

4. **Letter Count**  
   - At least **2 letters** in the main part

5. **Digit Count**  
   - At least **2 digits** in the main part

6. **Case Handling**  
   - Letters may be any case in input  
   - All letters must be **uppercase** in output

---

## 📤 Output Format

### ✔ Valid Plates

Format valid plates as:

```

[REGION-]XXX-XXX

```

- `X` = letter or digit  
- Use **hyphens** to separate into two groups of 3 characters  
- Omit region code if not provided  
- Convert all letters to **uppercase**

---

### ❌ Invalid Plates

- Print `Invalid`
- List specific violation reasons

**Violation Reasons (check in this order):**
1. `Invalid region code`
2. `Wrong character count`
3. `Invalid characters`
4. `Insufficient letters`
5. `Insufficient digits`

---

## 📘 Input Format

- First line: integer `N` (1 ≤ N ≤ 100), number of license plates
- Next `N` lines: one license plate string per line (length 1–30)
- Input ends when `N = 0`

---

## 📗 Output Format

For each test case:

- Line 1:  
```

Case X:

````
where `X` starts from 1

- For each plate:
- Valid:
  ```
  Plate Y: [formatted plate]
  ```
- Invalid:
  ```
  Plate Y: Invalid
  Reasons: [list of violations]
  ```

- Print a **blank line** after each test case

---

## 🧪 Sample Input

```text
6
CA-ABC123
XYZ789
12-AB34CD
GH_1A2B3C
AB-12.34.56
TX ABC1
````

---

## 🧾 Sample Output

```text
Case 1:
Plate 1: CA-ABC-123
Plate 2: XYZ-789
Plate 3: Invalid
Reasons: Insufficient letters
Plate 4: Invalid
Reasons: Wrong character count
Plate 5: Invalid
Reasons: Invalid characters
Plate 6: TX-ABC-1
```

---

✨ *This problem tests string parsing, validation logic, and formatting skills commonly required in real-world input validation systems.*


