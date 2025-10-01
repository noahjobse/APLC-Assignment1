# B1: Problem Statement — Find the Average

You can calculate the average of a set of numbers using the formula:

**Formula:**

Average = (sum of all numbers) / (count of numbers)

**Example:**

sum = 5 + 8 + 12 + 4 + 10 = 39  
Average = 39 / 5 = 7.8

---

## B2: Pseudocode

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

## B3: BNF for [list] of Numbers (Positive Only)

```bnf
<list> ::= "[" <elements> "]"
<elements> ::= <number> | <number> "," <elements>
<number> ::= <digit> | <digit> <number>
<digit> ::= "0" | ... | "9"
```

---

## B4: Parse Tree for Example Input

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
        <number>
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
        <number>
            <digit>
                "0"
    "]"
```
