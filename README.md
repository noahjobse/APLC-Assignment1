# APLC-Assignment1

# Positive Integer Validator (Java)

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

├── test.java # Main Java program file

└── README.md # Project documentation

## How to Run

1. **Compile the program**:

   javac test.java

2. **Run the program**:
   
   java test
   
3. **Enter a value when prompted**:

   input a positive integer:
   
---

## Logic Explanation

The program uses the following logic flow:

**Input Handling**

   Reads user input as a `String`

**Validation Checks**

   ✅ Not empty

   ✅ Does not start with "0" if length > 1

   ✅ Not equal to "0"

   ✅ Every character is a digit (0-9)

**Result Output**

   If all checks pass → "Input is a positive integer"

   Otherwise → "Please input a validate positive integer"
   
---
   
## Example Usage

**Input 1:**

    input a positive integer:
    123

**Output**

    Input is a positive integer

---

**Input 2:**

    input a positive integer:
    0123

**Output**

    Please input a validate positive integer

---

**Input 3:**

    input a positive integer:
    01*^${}where '1=1'

**Output**

    Please input a validate positive integer

