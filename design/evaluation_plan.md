# Evaluation Plan  
**Course:** COMP-3110  
**Student:** Emmanuel Omonua (110106145)  
**Language Focus:** Java  

---

## 1. Purpose
The goal of this evaluation is to measure how accurately the line-mapping tool (described in the algorithm design) can match lines between old and new versions of Java files.  
The evaluation is based on comparing **ground truth mappings** with the mappings the tool *would* produce.

No implementation is required; we evaluate using the designed behavior of the algorithm.

---

## 2. Datasets
Two datasets are used:

### **2.1 Instructor-Provided Dataset**
Small, controlled examples used as a baseline.

### **2.2 Student-Created Dataset (25 Pairs)**
A larger dataset containing realistic Java edits such as:
- renamed variables  
- modified print statements  
- added or removed lines  
- comment insertions  
- formatting changes  
- small logic changes  

Each pair is stored as:

```
pair_XXX_old.java
pair_XXX_new.java
```


A `ground_truth.csv` file lists the correct line mappings for all 25 pairs.

---

## 3. Metrics
The following metrics are used to evaluate the accuracy of the tool’s mappings:

### **3.1 Precision**
How many predicted mappings were correct.  
`Precision = TP / (TP + FP)`

### **3.2 Recall**
How many correct mappings were successfully found.  
`Recall = TP / (TP + FN)`

### **3.3 F1-Score**
Harmonic mean of precision and recall.  
`F1 = 2 * (Precision * Recall) / (Precision + Recall)`

### **3.4 Mapping Coverage**
How many old lines were mapped to *some* new line.  
`Coverage = MappedOldLines / TotalOldLines`

---

## 4. Evaluation Procedure
1. Use `ground_truth.csv` to establish the correct mapping for each file pair.  
2. Compare the ground truth with the mappings the algorithm would produce.  
3. Count true positives, false positives, and false negatives for each pair.  
4. Compute precision, recall, F1-score, and coverage for each pair.  
5. Calculate the average results across all 25 pairs.  
6. Summarize strengths and weaknesses of the algorithm.

---

## 5. Expected Outcomes
The following outcomes are expected based on the algorithm design:

- High accuracy for unchanged, lightly modified, or comment-modified lines  
- Strong performance on variable renaming  
- Lower accuracy on split/merge cases  
- Good generalization across the 25-pair dataset  

Typical expected metric ranges:

| Metric | Expected Range |
|--------|----------------|
| Precision | 0.85–0.95 |
| Recall | 0.80–0.95 |
| F1-score | 0.82–0.95 |
| Coverage | 0.95–1.00 |

---

## 6. Deliverables
- `ground_truth.csv`  
- Evaluation results table (optional)  
- Summary section included in the final report  

---
