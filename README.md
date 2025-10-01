# Team Roles & Work Plan

### Part A: History of Programming Languages
**Lead & Completed by: Qi**  
- Presentation on chosen history of programming languages topic.  
- Researched using journals, industry publications, and credible online resources.  
- Created 10–15 slide PowerPoint/PDF with references and citations.  
- Deliverable: Presentation uploaded to `/presentation` and submitted to Brightspace.  

---

### Part B: Syntax Description
**Step B1–B4 (Noah)**  
- Wrote pseudocode to solve the average problem.  
- Defined BNF grammar.  
- Constructed initial parse tree.  
- Ensured basic correctness of syntax.  

**Step B5–B6 (Troy)**  
- Rewrote grammar in EBNF for clarity.  
- Removed ambiguities and reconstructed the parse tree.  

**Step B7 (Emmanuel)**  
- Compared the BNF and EBNF parse trees.  
- Analyzed and explained impact of modifications.  

Deliverable: Markdown/PDF document in repo (`/docs/PartB_Syntax.md`).  

---

### Part C: Lexical Analyzer
**Lead & Completed by: Yisong**  
- Implemented the lexical analyzer in Java.  
- Handled multiple inputs and validation.  
- Added error handling and comments for clarity.  
- Tested with valid, invalid, and edge cases.  
- Deliverable: Source code in `/src/` with documentation and example I/O.  

---

# APLC-Assignment1

## Positive Integer Validator (Java)

This simple Java program checks whether a user’s input is a **valid positive integer**.  
It demonstrates fundamental Java concepts such as arrays, loops, conditional checks, and `Scanner` input handling.

---

## Features

- Prompts the user to input a value.
- Checks if the input is **non-empty**.
- Ensures the input does **not start with `0`** (unless it is exactly `"0"`, which is invalid here).
- Ensures the input consists **only of digits** (`0-9`).
- Rejects `"0"` as it is **not considered a positive integer**.
- Provides clear output messages indicating whether the input is valid.

---

## File Structure

```

├── src/
│   └── test.java   # Main Java program file
└── README.md       # Project documentation

````

---

## How to Run

1. **Compile the program**:

   ```bash
   javac test.java
```

2. **Run the program**:

   ```bash
   java test
   ```

3. **Enter a value when prompted**:

   ```
   input a positive integer:
   ```

---

## Logic Explanation

The program uses the following logic flow:

**Input Handling**

* Reads user input as a `String`.

**Validation Checks**

* ✅ Not empty
* ✅ Does not start with "0" if length > 1
* ✅ Not equal to "0"
* ✅ Every character is a digit (0–9)

**Result Output**

* If all checks pass → `"Input is a positive integer"`.
* Otherwise → `"Please input a valid positive integer"`.

---

## Example Usage

**Input 1:**

```
input a positive integer:
123
```

**Output:**

```
Input is a positive integer
```

---

**Input 2:**

```
input a positive integer:
0123
```

**Output:**

```
Please input a valid positive integer
```

---

**Input 3:**

```
input a positive integer:
01*^${}where '1=1'
```

**Output:**

```
Please input a valid positive integer
```

---

### Collaboration Guidelines

* **Repository:** All code and docs stored in shared GitHub repo.
* **Branching:** Each member used their own branch and merged via PRs.
* **Reviews:** At least one teammate reviewed work before merging.
* **Meetings:** Check-ins scheduled to keep progress aligned.

---

### Deliverables Summary

* **Qi** → Presentation (Part A).
* **Noah** → Syntax Part B (steps B1–B4).
* **Troy** → Syntax Part B (steps B5–B6).
* **Emmanuel** → Syntax Part B (step B7).
* **Yisong** → Lexical analyzer code (Part C).

```