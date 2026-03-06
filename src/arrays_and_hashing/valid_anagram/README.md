# Valid Anagram

- Problem link: https://leetcode.com/problems/valid-anagram/
- Difficulty: Easy
- Patterns used: Frequency Counting + Character Mapping


## Complexity

Stream (frequency map):
- Initial idea: Build a frequency map for both strings by grouping characters and counting their occurrences. Two strings are anagrams if both maps are equal.
- Time: O(n)
- Space: O(n)

Counting Array:
- Key idea: Since the problem only contains lowercase letters, use a fixed array of size 26 where each index represents a letter. Iterate once over both, incrementing counts for `s` and decrementing for `t`. If all counts end up as zero, the strings are anagrams.
- Time: O(n)
- Space: O(1)