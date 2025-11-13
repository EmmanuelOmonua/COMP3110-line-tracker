# Algorithm Design  
**Course:** COMP-3110  
**Student:** Emmanuel Omonua (110106145)  
**Language Focus:** Java  

---

## 1. Overview
This project designs a *line-mapping tool* that tracks which lines in an **old file** correspond to which lines in a **new file**.  
It detects unchanged, modified, split, merged, added, and deleted lines between two Java source files.  

No actual code is implemented — only the design and logic are described.

---

## 2. Goal
Given two versions of a file, the tool should:
- Compare every line in the **old version** to lines in the **new version**.  
- Output a mapping that shows which lines are the same, which are modified, and which are added, deleted, split, or merged.  

**Example:**
```Old line 10 → New line 12```
```Old line 15 → New lines 18,19 (split)```
```Old line 21 → deleted```

This helps developers understand how code changes between versions.

---

## 3. Step-by-Step Algorithm (Simple and Clear)

### Step 1 — Read and Pre-process Files
- Read both files line by line.  
- Remove extra spaces, tabs, and blank lines to normalize.  
- (Optional) Convert everything to lowercase for basic comparison.

### Step 2 — Identify Exact Matches
- Compare lines with the same text.  
- If a line in the old file exists **exactly** in the new file, mark it as **unchanged**.

### Step 3 — Find Similar Lines (Modified)
- For old lines that changed, compare them to every new line using **similarity scoring**:
  - Use **Levenshtein distance** (edit distance) to see how different they are.
  - Also check **token similarity** by splitting words or Java keywords.
- Pick the new line with the **highest similarity score**.

### Step 4 — Detect Splits and Merges
- If one old line matches multiple new lines → mark as **split**.  
- If multiple old lines match one new line → mark as **merged**.

### Step 5 — Assign Confidence Score
Each match gets a confidence value (0–1):
- High = 1.0 → perfect or near-perfect match  
- Medium = 0.7 → modified but recognizable  
- Low = 0.4 → uncertain (manual review)

### Step 6 — Save the Mapping
Output a table:
| Old Line | New Line(s) | Type | Confidence |
|-----------|--------------|------|-------------|
| 12 | 14 | unchanged | 1.0 |
| 15 | 18,19 | split | 0.9 |
| 21 | - | deleted | - |

---

## 4. Parameters
| Parameter | Description | Default |
|------------|--------------|----------|
| `k` | Max number of candidate new lines to compare per old line | 15 |
| `context_window` | Number of neighboring lines checked for context | 4 |
| `similarity_threshold` | Minimum similarity to be considered a match | 0.5 |
| `content_weight` | Weight of content vs context similarity | 0.6 / 0.4 |

---

## 5. Example (Java)
**Old.java**
```java
System.out.println("Hello");
int x = 5;
System.out.println("Goodbye");

**New.java**
System.out.println("Hello");
int number = 5;
System.out.println("Good bye");
