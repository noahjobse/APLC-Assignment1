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
## B5: Is the grammar ambiguous 
```text
The grammar of the parse tree is unambiguous because each input is clearly defined.
Commas separate the elements, and multi-digit numbers like 12 are clearly shown.
Ambiguity could happen if the grammar weas written differently for example,
by allowing the  <elements> ::= <elements> "," <elements>.
In that case, an input like 1,2,3 could be interpreted as either (1, (2, 3)) or ((1, 2), 3).
Similarly, different interpretations might occur
if commas were grouped in different ways or if digits were split differently 
```
## B6: EBNF Form
```text
list = "["elements"]";
elements = number {";" number} ;
number = digit {digit};
digit = "0"|"1"|"2"|"3"|"4"|"5"|"6"|"7"|"8"|"9";

```
## B7: EBNF Form Parse Tree
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
	
Compared to the BNF parse tree in B4, the EBNF tree above does not contain ambiguity.
Such as in the BNF tree the <elements> list and "," <number> pair is ambiguous.
This impacts the EBNF tree structure by discarding extra uses of <elements> and <number> that may
lead to misinterpretation and more parse trees. To solve this in the EBNF tree, extra uses of
<elements> are discarded which better shows the child components and length of <elements>.
It also includes the repetitons of the pair "," and <number> into braces: {","<number>} and removes
the extra uses of <number> for the double digit numbers in the array,
which better clarifies the amount of digits in a number. 
```
