# LexicalAnalyzer

A simple **Java Lexical Analyzer** that identifies tokens and analyzes variable declaration statements.

---

## Features

- **Single Token Analysis**
  - Keywords (e.g., `int`, `if`, `class`)
  - Identifiers (valid variable names)
  - Positive Integers
  - Invalid tokens return an error

- **Multiple Statement Analysis**
  - Supports variable declarations with optional assignment:
    ```
    type var;
    type var = value;
    ```
  - Generates a syntax tree showing `type`, `var`, `operator`, and `value`

- **Error Handling**
  - Invalid statements or tokens produce clear error messages

---

## Examples

### Single Token Analysis

| Input    | Output                     |
|----------|----------------------------|
| `int`    | Token: int -> Keyword      |
| `myVar`  | Token: myVar -> Identifier |
| `123`    | Token: 123 -> Positive Integer |
| `!abc`   | [Error] "!abc" is not a valid token. |

### Multiple Statement Analysis

**Input:**

    `int a; double b = 5;`
    
**Output**

    ---- Syntax Tree ----
    type: int
    var: a
    operator: null
    value: null

    ---- Syntax Tree ----
    type: double
    var: b
    operator: =
    value: 5

---

**Flowchart of Lexical Analysis**

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
    (keyword/identifier/   regex validation & syntax tree
     positive integer)          |
            |                  v
            +-----------------> Output
