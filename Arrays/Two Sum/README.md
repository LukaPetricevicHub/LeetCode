# Two Sum

- Problem link: https://leetcode.com/problems/two-sum/
- Difficulty: Easy
- Patterns used: Brute-force + Hash Map


## Complexity

Brute-force:
- Initial idea: Compare every possible pair using two nested loops and return the indices once the target sum is found.
- Time: O(n^2)
- Space: O(1)

Hash Map:
- Key idea: Iterate only once while storing complements (target - current value) in a hash map. For each check if it already exists as a stored complement. If yes, return both indices immediately.
- Time: O(n)
- Space: O(n)