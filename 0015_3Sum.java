/*
Problem sourced from: leetcode.com

Given an array nums of n integers, are there elements a, b, c in nums such that
a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
The solution set must not contain duplicate triplets.

Example:
Given array nums = [-1, 0, 1, 2, -1, -4],
A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
*/

import java.util.*;

public class ThreeSum {
    // Hashtable solution: Loop through all numbers, for each find a set of two
    // numbers that add up to the negative i-loop value
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> results = new ArrayList();

        for (int i = 0; i < nums.length - 2; i++) {
            // Define the target value which you will use to find two other numbers
            int target = nums[i] * -1;
            // Create a HashMap to store all numbers that have been evaluated
            Map<Integer, Integer> numbersEvaluated = new HashMap<>();
            // Iterate through each number in the array
            for (int j = i + 1; i < nums.length; i++) {
                // Calculate the complementary number that would add up to the target
                int complement = target - nums[j];
                // If the complementary number exists in the map, find its index value
                // and add the two of them into a triplet along with the original 
                // value at i 
                if (numbersEvaluated.containsKey(complement)) {
                    List<Integer> triplet = new List();
                    // Value at index i
                    triplet.add(nums[i]);
                    // Completmentary number that has already been seen
                    triplet.add(complement);
                    // Value at index j
                    triplet.add(nums[j]);
                    // Add the triplet into solution
                    results.add(triplet);
                }
                // Save the index of the current number at a key value of the number itself
                numbersEvaluated.put(nums[j], i);
            }
        }

        return results;
    }


    public static List<List<Integer>> threeSum2(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("No possible solution");
        }
        
        // Create resulting list
        List<List<Integer>> results = new ArrayList();
        // Sort input array
        nums = Arrays.sort(nums);

        // Create index representing point between negative/positive nums
        int zeroPointIndex = 0;
        // Moves zeroPointIndex to the divide between negative & positive numbers
        while (nums[zeroPointIndex] < 0) {
            zeroPointIndex++;
        }
        // No negative numbers in input array
        if (nums[zeroPointIndex] <= 0) {
            throw new IllegalArgumentException("No possible solution");
        }

        int left = zeroPointIndex - 1;
        int right = zeroPointIndex + 1;
        while
        
        return results;
    }
    
    // Multi-pointer solution: First sort array, then iterate through each value.
    // For each value, check if there are two other values in the remaining array
    // that can be added to zero
    public static List<List<Integer>> threeSum3(int[] nums) {
        if (nums.length < 3) {
            throw new IllegalArgumentException("No possible solution");
        }

        // Create resulting list
        List<List<Integer>> results = new ArrayList();
        // Sort input array
        Arrays.sort(nums);

        // Loop through all numbers in the array, trying to find a triplet 
        // that contains that number
        for (int i = 0; i < nums.length - 2; i++) {
            // Create left & right indices that encompass the remaining array
            int left = i + 1;
            int right = nums.length - 1;

            // Only check other numbers when nums[i] is not a duplicate value
            // This prevents returning duplicative triplets
            if (i == 0 || nums[i] != nums[i - 1]) {
                // Continue checking numbers so long as the left value is smaller
                // than the right value
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    // If a solution is found, add it into the results list
                    if (sum == 0) {
                        List<Integer> triplet = new ArrayList();
                        triplet.add(nums[i]);
                        triplet.add(nums[left]);
                        triplet.add(nums[right]);
                        results.add(triplet);

                        // Move left pointer forwards until a new value is found
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        // Move right pointer backwards until a new value is found
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        // Increment left & right to the new value
                        left++;
                        right--;
                    }
                    // If sum is negative, move left pointer forwards
                    else if (sum < 0) {
                        left++;
                    }
                    // If sum is positive, move right pointer backwards
                    else {
                        right--;
                    }
                }
            }
        }

        return results;
    }

}