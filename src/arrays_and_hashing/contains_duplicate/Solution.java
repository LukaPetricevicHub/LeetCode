package arrays_and_hashing.contains_duplicate;

import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {1, 2, 3, 1};

        System.out.println(solution.containsDuplicateBrute(nums));
        System.out.println(solution.containsDuplicateSorted(nums));
        System.out.println(solution.containsDuplicateHashSet(nums));
    }

    /**
     * Brute-force approach
     *
     * Using nested loop we compare every num with the ones that follow it.
     * If two equal ones are found, a duplicate exists and we return true
     *
     * @param nums input array
     * @return true if a duplicate exists
     */
    public boolean containsDuplicateBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Problem before: Nested Loop -> Worst case: O(n^2) time complexity
     *
     * New approach: Sort first, so duplicate values will appear next to each other
     * A single pass over the sorted array is enough
     *
     * Worst case time complexity now: O(n log n)
     *
     * @param nums input array
     * @return true if a duplicate exists
     */
    public boolean containsDuplicateSorted(int[] nums) {
        int[] copy = Arrays.copyOf(nums, nums.length); // create copy to not modify the original array
        Arrays.sort(copy);

        for (int i = 1; i < copy.length; i++) {
            if (copy[i] == copy[i - 1]) { // [i - 1] takes care of index out of bounds error
                return true;
            }
        }

        return false;
    }

    /**
     * Problem with sorting: Introduces O(n log n) time complexity
     *
     * Instead, we can remember values we've already seen using a HashSet
     *
     * We can now check if the current value already exists in the set
     * and if it does, a duplicate was found immediately
     *
     * Worst case time complexity now: O(n)
     *
     * @param nums input array
     * @return true if a duplicate exists
     */
    public boolean containsDuplicateHashSet(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            }
            set.add(num);
        }

        return false;
    }
}