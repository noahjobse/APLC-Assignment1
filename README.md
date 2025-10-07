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

  * Deliverable → included in this README (B1–B7 section)

### Part C: Lexical Analyzer

* **Yisong** → Java Lexical Analyzer implementation

  * Regex-based token classification
  * Error handling & testing with edge cases
  * Deliverables:

    * Source code → `/src/`
    * Documentation & examples → included below

---

## Part B: Syntax Description

### B1: Problem Statement — Find the Average

You can calculate the average of a set of numbers using the formula:

**Formula:**
[
\text{Average} = \frac{\text{sum of all numbers}}{\text{count of numbers}}
]

**Example:**
[
\text{sum} = 5 + 8 + 12 + 4 + 10 = 39,\ \text{Average} = 39 / 5 = 7.8
]

---

### B2: Pseudocode

```text
sum = 0
count = 0

FOR each value IN numbers DO
    sum = sum + value
    count = count + 1
END FOR

IF count = 0 THEN
    print "This list is empty, unable to take average."
ELSE
    average = sum / count
    print average
END IF
```

---

### B3: BNF for [list] of Numbers (Positive Only)

```bnf
<list>     ::= "[" <elements> "]"
<elements> ::= <number> | <number> "," <elements>
<number>   ::= <digit> | <digit> <number>
<digit>    ::= "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9"
```

---

### B4: Parse Tree for Example Input

```text
<list>
    "["
    <elements>
        <number>
            <digit>
                "5"
        ","
        <elements>
            <number>
                <digit>
                    "8"
            ","
            <elements>
                <number>
                    <digit>
                        "1"
                    <digit>
                        "2"
                ","
                <elements>
                    <number>
                        <digit>
                            "4"
                    ","
                    <elements>
                        <number>
                            <digit>
                                "1"
                            <digit>
                                "0"
    "]"
```

---

### B5: Is the Grammar Ambiguous?

The grammar of the parse tree is **unambiguous** because each input is clearly defined.

* Commas separate elements.
* Multi-digit numbers like `12` are grouped correctly.
* Ambiguity would only arise if `<elements>` were defined recursively, e.g.:

  ```bnf
  <elements> ::= <elements> "," <elements>
  ```

  Then `1,2,3` could be interpreted as `(1, (2, 3))` or `((1, 2), 3)`.

---

### B6: EBNF Form

```ebnf
list     = "[" elements "]" ;
elements = number { "," number } ;
number   = digit { digit } ;
digit    = "0" | "1" | "2" | "3" | "4" | "5" | "6" | "7" | "8" | "9" ;
```

---

### B7: EBNF Form Parse Tree

```text
<list>
    "["
    <elements>
        <number>
            <digit>
                "5"
        {"," number}
            ","
            <number>
                <digit>
                    "8"
            ","
            <number>
                <digit>
                    "1"
                <digit>
                    "2"
            ","
            <number>
                <digit>
                    "4"
            ","
            <number>
                <digit>
                    "1"
                <digit>
                    "0"
    "]"
```

Compared to the BNF parse tree in B4, the EBNF version removes ambiguity by explicitly grouping repetitions using `{ "," number }`. This is more concise and ensures multi-digit numbers are parsed as a single `<number>` node.

---

## Part C: Lexical Analyzer

### Features

* Single Token Analysis

  * Keywords, Identifiers, Integer Literals, Decimal Literals
  * Invalid tokens flagged with `[Error]`

* Multiple Statement Analysis

  * Supports declarations with optional initialization
  * Prints a **Parse Tree** showing type, identifier, operator, value

* Error Handling

  * Detects malformed input and invalid syntax
  * Skips empty statements safely

---

### Examples

**Single Token Input**

| Input   | Output                               |
| ------- | ------------------------------------ |
| `int`   | Token: int -> Keyword                |
| `myVar` | Token: myVar -> Identifier           |
| `123`   | Token: 123 -> Integer Literal        |
| `12.5`  | Token: 12.5 -> Decimal Literal       |
| `!abc`  | [Error] "!abc" is not a valid token. |

**Multiple Statements Input**

```java
int a; double b = 5;
```

**Output**

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

### Flow of Lexical Analysis

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
│   └── README.md (this file)
├── presentation/
│   └── History_of_PLs.pdf
├── tests/
│   └── docs/
│       ├── LexicalAnalyzer_Tests.md
│       └── FullBreakdown.md
├── run-lexer.bat
└── README.md
```

---

## How to Run

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

| Part | Team Member(s)                            | Deliverables                       |
| ---- | ----------------------------------------- | ---------------------------------- |
| A    | Qi                                        | `/presentation`                    |
| B    | Noah (B1–B4), Troy (B5–B6), Emmanuel (B7) | Included in this README            |
| C    | Yisong                                    | `/src/`, examples + docs in README |
