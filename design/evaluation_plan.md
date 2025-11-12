# Evaluation Plan (Simple)

## Goal
Check if the tool correctly finds which lines match.

## What we measure
- Precision = correct matches / all matches found
- Recall = correct matches / total true matches
- F1 score = overall accuracy

## How to test
1. Run the tool on each file pair.
2. Compare its results with the ground_truth.csv.
3. Count how many matches are correct or wrong.
4. Show results in a table.
