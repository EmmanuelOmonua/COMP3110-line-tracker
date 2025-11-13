# GUI Design Description  
**Course:** COMP-3110  
**Student:** Emmanuel Omonua (110106145)  
**Language Focus:** Java  

---

## 1. Goal
Design a GUI to **visualize line mappings** between old and new files in a clear, user-friendly way.

---

## 2. Views

### a) Side-by-Side View
- Two panels: **Old File** (left) and **New File** (right).
- Lines connected with **colored curves**:
  - Green → unchanged
  - Blue → modified
  - Red → deleted
  - Orange → added
- Hovering over a line highlights its match.

### b) Sankey Flow Diagram
- Left blocks = old lines, right blocks = new lines.
- Flow lines show how lines moved or split.
- Thickness of the band = number of lines changed.

### c) Heatmap View
- Grid where X = old line, Y = new line.
- Darker squares = stronger mapping confidence.
- Helps identify clusters of change.

### d) Mapping Inspector
- Table listing every old → new mapping.
- Columns: Old Line, New Line(s), Type, Confidence.

---

## 3. Interaction Ideas
- Click a line → highlights corresponding lines on both sides.
- Toggle filters (show only modified/deleted lines).
- Tooltip with code snippet preview.

---

## 4. Bonus: Bug Visualization
Buggy mappings (from the “bug-introducing” extension) are highlighted **in red** or marked with ⚠️.

---

## 5. Summary
These designs make it easy to visualize and analyze code evolution between versions, both line-by-line and globally.

