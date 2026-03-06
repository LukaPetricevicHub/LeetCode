package arrays_and_hashing.valid_anagram;

import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {
        System.out.println(Solution.isAnagramStream("anagram", "nagaram"));
        System.out.println(Solution.isAnagramStream("car", "rat"));

        System.out.println(Solution.isAnagramArray("anagram", "nagaram"));
        System.out.println(Solution.isAnagramArray("car", "rat"));
    }

    /**
     * Build a frequency map of each string checking for a character and
     * how often it appears and then compare
     *
     * @param s string of chars
     * @param t string of chars
     * @return true if t is anagram of s and vice versa
     */
    public static boolean isAnagramStream(String s, String t) {
        return s.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()))
                .equals(t.chars().mapToObj(c -> (char) c)
                                .collect(Collectors.groupingBy(c -> c, Collectors.counting())));
    }

    /**
     * Since the problem guarantees lowercase letters only, we can use
     * an array where each index represents a letter
     *
     * Iterate once over the strings:
     *  - increment the count for chars in s
     *  - decrement the count for chars in t
     *
     * If they are anagrams, all counts must end up as 0
     *
     * Worst case time complexity: O(n)
     *
     * @param s string of chars
     * @param t string of chars
     * @return true if t is anagram of s and vice versa
     */
    public static boolean isAnagramArray(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] char_count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_count[s.charAt(i) - 'a']++; // subtract 'a' to convert the Unicode value into an alphabet index
            char_count[t.charAt(i) - 'a']--;
        }

        for (int count : char_count) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
