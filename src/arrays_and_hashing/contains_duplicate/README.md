# Contains Duplicate

- Problem link: https://leetcode.com/problems/contains-duplicate/
- Difficulty: Easy
- Patterns used: Brute-force + Sorting + Hash Set


## Complexity

Brute-force:
- Initial idea: Compare every number with the ones that follow it using nested loops. If two equal values are found, a duplicate exists.
- Time: O(n^2)
- Space: O(1)

Sorting:
- Key idea: Sort nums first so duplicate values appear next to each other. Iterating once is enough to detect adjacent duplicates.
- Time: O(n log n)
- Space: O(n)

Hash Set:
- Key idea: Iterate once while storing seen values in a HashSet. If a number already exists in the set, a duplicate was found.
- Time: O(n)
- Space: O(n)