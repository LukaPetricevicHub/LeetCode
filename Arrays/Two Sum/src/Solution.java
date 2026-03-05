import java.util.Arrays;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2,7, 11, 15};
        int target = 9;

        int [] result = bruteTwoSum(nums, target);


        // Per problem statement, there will always exist one solution. Yet checking doesn't hurt no one
        if (result != null) {
            System.out.println(Arrays.toString(result));
        } else {
            System.out.println("No valid solution");
        }

    }

    /**
     * Brute-force approach that first comes to mind
     *
     * Using a nested loop we iterate over nums and only return the indices
     * of the two numbers that add up to the target
     *
     * @param nums input array
     * @param target value
     * @return index array of the target sum
     */
    public static int[] bruteTwoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target ) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    /**
     * Problem with previous: Nested Loop -> Worst case: O(n^2) time complexity
     *
     * How can we achieve only one full array iteration worst case?
     * Answer: track our values using a HashMap
     *
     * Worst case time complexity now: O(n)
     * @param nums input array
     * @param target value
     * @return index array of the target sum
     */
    public static int[] efficientTwoSum(int[] nums, int target) {
        HashMap<Integer, Integer> complements = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complementIndex = complements.get(nums[i]); // retrieves number if it exists
            if (complementIndex != null) {
                return new int[]{i, complementIndex}; // match found
            }
            complements.put(target - nums[i], i); // calculate new complement and add to map
        }
        return null;
    }
}