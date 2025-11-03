# Algorithm Design (Simple Version)

We want to match lines between two files (old and new).

## Steps:
1. Compare the files line by line.
2. Mark identical lines as "unchanged".
3. For changed lines, look for similar text in the new file.
4. Use similarity score (how close the lines are).
5. If one old line matches several new lines → call it a "split".
6. If several old lines match one new line → call it a "merge".
7. Write down each mapping like this:
   - old line number → new line number(s)
