# Team Roles & Work Plan

### Part A: History of Programming Languages

**Lead & Completed by: Qi**

* Presentation on chosen history of programming languages topic.
* Researched using journals, industry publications, and credible online resources.
* Created 10–15 slide PowerPoint/PDF with references and citations.
* Deliverable: Presentation uploaded to `/presentation` and submitted to Brightspace.

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

---

### Part C: Lexical Analyzer

**Lead & Completed by: Yisong**

* Implemented the lexical analyzer in Java.
* Handled multiple inputs and validation.
* Added error handling and comments for clarity.
* Tested with valid, invalid, and edge cases.
* Deliverable: Source code in `/src/` with documentation and example I/O.

---

# Java Lexical Analyzer

### Overview

This project implements a simple **Lexical Analyzer** in Java.
It reads user input (tokens) from the console and classifies them into categories such as:

* ✅ **Keywords** (e.g., `if`, `class`, `public`)
* ✅ **Positive Integers** (e.g., `123`, `42`)
* ✅ **Identifiers** (e.g., `myVar`, `_name`)
* ❌ Invalid tokens (e.g., `123abc`, `@hello`)

This project demonstrates the **lexical analysis phase** of a compiler — the first step in translating source code into executable programs.

---

### Features

* 🔎 Classifies user input into token types:

  * Keywords
  * Positive Integers
  * Identifiers
  * Invalid Tokens
* ✍️ Uses regular expressions for lexical pattern matching.
* 🧪 Includes error handling for empty or invalid input.
* 🔄 Accepts unlimited tokens until user types `exit`.
* 💬 Provides clear feedback messages to users.

---

### Technologies Used

* Language: **Java 8+**
* Tools: Any Java IDE (IntelliJ IDEA / Eclipse / VS Code) or terminal compiler (`javac`)
* Windows batch file (`.bat`) for simplified running

---

### Project Structure

```
LexicalAnalyzer/
│
├── src/
│   └── LexicalAnalyzer.java   # Main lexical analyzer program
├── run-lexer.bat              # Batch file to compile & run
└── README.md                  # Documentation
```

---

### How to Run

#### Option 1: Using the `.bat` file (recommended)

A batch file (`run-lexer.bat`) is included for easy execution.

1. **Double-click** `run-lexer.bat`

   * This will automatically compile and run the lexical analyzer.
   * A console window will open where you can type tokens.
   * The window will stay open after execution so you can read the output.

Example:

```
Enter tokens to analyze (type 'exit' to quit):

Input: int
Token: int → Keyword

Input: hello123
Token: hello123 → Identifier

Input: exit
Lexical analysis finished.
```

#### Option 2: Manual commands (if needed)

If you want to run without the batch file:

```bash
javac LexicalAnalyzer.java
java LexicalAnalyzer
```

---

### Batch File Contents

The `run-lexer.bat` file contains:

```bat
@echo off
cd /d "%~dp0src"
javac -source 8 -target 8 LexicalAnalyzer.java
java LexicalAnalyzer
pause
```

* `cd /d "%~dp0src"` → navigates into the `src` folder relative to the batch file location
* `javac …` → compiles for Java 8
* `java LexicalAnalyzer` → runs the program
* `pause` → keeps the window open after execution

---

### Example Usage

```
Enter tokens to analyze (type 'exit' to quit):

Input: if
Token: if → Keyword

Input: 123
Token: 123 → Positive Integer

Input: myVariable
Token: myVariable → Identifier

Input: 0123
[Error] "0123" is not a valid token.

Input: exit
Lexical analysis finished.
```

---

### Token Classification Rules

| Token Type           | Rule / Regex                       | Example        |
| -------------------- | ---------------------------------- | -------------- |
| **Keyword**          | Must match a reserved word in Java | `if`, `while`  |
| **Positive Integer** | `^[1-9][0-9]*$`                    | `5`, `12345`   |
| **Identifier**       | `^[a-zA-Z_][a-zA-Z0-9_]*$`         | `x`, `_name1`  |
| **Invalid**          | Any token not matching the above   | `123abc`, `@a` |

---

### Sample Test Cases

| Input     | Expected Output                            |
| --------- | ------------------------------------------ |
| `if`      | Token: if → Keyword                        |
| `class`   | Token: class → Keyword                     |
| `123`     | Token: 123 → Positive Integer              |
| `0`       | ❌ `[Error] "0" is not a valid token.`      |
| `_abc`    | Token: _abc → Identifier                   |
| `123abc`  | ❌ `[Error] "123abc" is not a valid token.` |
| *(empty)* | ❌ `[Error] Empty input is not valid.`      |

---

### Program Flow

1. User inputs a token
2. Analyzer checks:

   * Is it empty?
   * Is it a keyword?
   * Is it a positive integer?
   * Is it a valid identifier?
3. Program outputs the classification or an error message
4. Repeat until user enters `exit`

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
