# Lexical Analyzer & Syntax Description Project

Group 8 — CMPP-3020-BSA, Fall 2025
**Assignment: Concepts, Syntax and Lexical Analysis**

---

## Team Roles & Work Plan

### Part A: History of Programming Languages

* **Qi** → Research + Slides

  * Topic in history of programming languages
  * 10–15 slides with citations & references
  * Deliverable → `/presentation`

### Part B: Syntax Description

* **Noah (B1–B4)** → Pseudocode, BNF, parse tree
* **Troy (B5–B6)** → EBNF rewrite + parse tree
* **Emmanuel (B7)** → Compare BNF vs EBNF trees

  * Deliverable → `/docs/PartB_Syntax.md`

### Part C: Lexical Analyzer

* **Yisong** → Java Lexical Analyzer implementation

  * Regex-based token classification
  * Error handling & testing with edge cases
  * Deliverables:

    * Source code → `/src/`
    * Documentation → `/docs/LexicalAnalyzer.md`
    * Test outputs → `/tests/docs/LexicalAnalyzer_Tests.md`
    * Extended writeup → `/tests/docs/FullBreakdown.md`

---

## Project Overview

This project demonstrates concepts from **programming languages, syntax analysis, and lexical analysis**.

* **Part A:** History of programming languages (slides).
* **Part B:** Syntax description for “finding the average” problem.
* **Part C:** A working **Lexical Analyzer in Java** that classifies tokens and validates simple statements.

---

## Features

* **Single Token Analysis**

  * Detects: Keywords, Identifiers, Positive Integers, Decimal Numbers
  * Invalid tokens flagged with clear error messages

* **Multiple Statement Analysis**

  * Supports declarations with optional initialization:

    ```java
    int a;
    double b = 5;
    ```
  * Builds and prints a simple parse tree:

    ```
    ---- Parse Tree ----
    Statement
     ├── Type: double
     ├── Identifier: b
     ├── Operator: =
     └── Value: 5
    ```

* **Error Handling**

  * Invalid statements/tokens produce `[Error] ...` messages
  * Handles edge cases (empty input, malformed syntax, bad characters)

---

## Examples

### Single Token Analysis

| Input   | Output                               |
| ------- | ------------------------------------ |
| `int`   | Token: int -> Keyword                |
| `myVar` | Token: myVar -> Identifier           |
| `123`   | Token: 123 -> Integer Literal        |
| `12.5`  | Token: 12.5 -> Decimal Literal       |
| `!abc`  | [Error] "!abc" is not a valid token. |

---

### Multiple Statement Analysis

**Input:**

```java
int a; double b = 5;
```

**Output:**

```
---- Parse Tree ----
Statement
 ├── Type: int
 ├── Identifier: a

---- Parse Tree ----
Statement
 ├── Type: double
 ├── Identifier: b
 ├── Operator: =
 └── Value: 5
```

---

## Flow of Lexical Analysis

```
          +---------------------+
          |   User Input Line   |
          +---------+-----------+
                    |
         +----------v----------+
         | Contains whitespace?|
         +----+---------+-----+
              |         |
           No |         | Yes
              |         |
       +------v--+   +--v------------------+
       | Single  |   | Multiple Statements |
       |  Token  |   +--------------------+
       +----+----+             |
            |                  v
            |          Split by ';' and analyze each
            |                  |
            v                  v
     Analyze token        Analyze statement with
    (keyword/identifier/   regex validation & parse tree
     integer/decimal)             |
            |                  v
            +-----------------> Output
```

---

## Project Structure

```
LexicalAnalyzer/
│
├── src/
│   └── LexicalAnalyzer.java
├── docs/
│   ├── PartB_Syntax.md
│   └── LexicalAnalyzer.md
├── tests/
│   └── docs/
│       ├── LexicalAnalyzer_Tests.md
│       └── FullBreakdown.md
├── presentation/
│   └── History_of_PLs.pdf
├── run-lexer.bat
└── README.md   (this file)
```

---

## ▶How to Run

**Option 1: Batch File (Windows, recommended)**

1. Double-click `run-lexer.bat`
2. Console opens for input
3. Type tokens/statements, press Enter
4. Type `exit` to quit

**Option 2: Manual (any OS with Java)**

```bash
cd src
javac LexicalAnalyzer.java
java LexicalAnalyzer
```

---

## Deliverables Summary

| Part  | Team Member(s)                            | Deliverables                                        |
| ----- | ----------------------------------------- | --------------------------------------------------- |
| **A** | Qi                                        | `/presentation`                                     |
| **B** | Noah (B1–B4), Troy (B5–B6), Emmanuel (B7) | `/docs/PartB_Syntax.md`                             |
| **C** | Yisong                                    | `/src/`, `/docs/LexicalAnalyzer.md`, `/tests/docs/` |
