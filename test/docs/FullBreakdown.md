# Team Roles & Work Plan

---

### Part A: History of Programming Languages

**Lead & Completed by: Qi**

* Presentation on chosen history of programming languages topic.
* Researched using journals, industry publications, and credible online resources.
* Created 10–15 slide PowerPoint/PDF with references and citations.
* Deliverable: Presentation uploaded to `/presentation` and submitted to Brightspace.

**Quick Reference:**

* **Qi** → Research + Slides (10–15) → `/presentation`

---

### Part B: Syntax Description

**Step B1–B4 (Noah)**

* Wrote pseudocode to solve the average problem.
* Defined BNF grammar.
* Constructed initial parse tree.
* Ensured basic correctness of syntax.

**Step B5–B6 (Troy)**

* Rewrote grammar in EBNF for clarity.
* Removed ambiguities and reconstructed the parse tree.

**Step B7 (Emmanuel)**

* Compared the BNF and EBNF parse trees.
* Analyzed and explained impact of modifications.

Deliverable: Markdown/PDF document in repo (`/docs/PartB_Syntax.md`).

**Quick Reference:**

* **Noah (B1–B4)** → Pseudocode, BNF, parse tree
* **Troy (B5–B6)** → EBNF rewrite + parse tree
* **Emmanuel (B7)** → Compare BNF vs EBNF trees → `/docs/PartB_Syntax.md`

---

### Part C: Lexical Analyzer

**Lead & Completed by: Yisong**

* Implemented the lexical analyzer in Java.
* Handled multiple inputs and validation.
* Added error handling and comments for clarity.
* Tested with valid, invalid, and edge cases.
* Deliverable: Source code in `/src/` with documentation and example I/O.

**Quick Reference:**

* **Yisong** → Java Lexical Analyzer with regex + error handling → `/src/`

---

# Java Lexical Analyzer (Detailed)

### Overview

This project implements a simple **Lexical Analyzer** in Java.
It reads user input (tokens) from the console and classifies them into categories such as:

* ✅ Keywords
* ✅ Positive Integers
* ✅ Identifiers
* ❌ Invalid tokens

This demonstrates the **lexical analysis phase** of a compiler — the first step in translating source code into executable programs.

---

### Features

* 🔎 Classifies user input into token types
* ✍️ Uses regular expressions
* 🧪 Includes error handling
* 🔄 Accepts unlimited tokens until `exit`
* 💬 Clear feedback messages

---

### Project Structure

```
LexicalAnalyzer/
│
├── src/
│   └── LexicalAnalyzer.java
├── run-lexer.bat
└── README.md
```

---

### How to Run

**Option 1: Using the `.bat` file (recommended)**

1. Double-click `run-lexer.bat`

   * Compiles and runs automatically
   * Console opens for input
2. Enter tokens, press Enter
3. Type `exit` to quit

**Option 2: Manual commands**

```bash
cd src
javac LexicalAnalyzer.java
java LexicalAnalyzer
```

---

### Batch File Contents

```bat
@echo off
cd /d "%~dp0src"
javac -source 8 -target 8 LexicalAnalyzer.java
java LexicalAnalyzer
pause
```

---

### Example Usage

```
Input: if
Token: if → Keyword

Input: 123
Token: 123 → Positive Integer

Input: 0123
[Error] "0123" is not a valid token.

Input: exit
Lexical analysis finished.
```

---

### Token Rules

| Token Type           | Regex / Rule                  | Example  |
| -------------------- | ----------------------------- | -------- |
| **Keyword**          | Must match reserved Java word | `if`     |
| **Positive Integer** | `^[1-9][0-9]*$`               | `123`    |
| **Identifier**       | `^[a-zA-Z_][a-zA-Z0-9_]*$`    | `_var1`  |
| **Invalid**          | Not matching above            | `123abc` |

---

### Deliverables Summary

| Team Member  | Work Completed                              | Deliverable Location    |
| ------------ | ------------------------------------------- | ----------------------- |
| **Qi**       | History of PLs (slides)                     | `/presentation`         |
| **Noah**     | Part B (B1–B4: pseudocode, BNF, parse tree) | `/docs/PartB_Syntax.md` |
| **Troy**     | Part B (B5–B6: EBNF + tree)                 | `/docs/PartB_Syntax.md` |
| **Emmanuel** | Part B (B7: BNF vs EBNF comparison)         | `/docs/PartB_Syntax.md` |
| **Yisong**   | Lexical Analyzer (Java code)                | `/src/` + `README.md`   |

**Quick How-to-Run Reminder:**

1. Double-click `run-lexer.bat`.
2. Console opens.
3. Type tokens, press Enter.
4. Type `exit` to quit.
