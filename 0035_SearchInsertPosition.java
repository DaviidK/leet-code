/*
Problem sourced from: leetcode.com

Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4

Constraints:
  1 <= nums.length <= 104
  -104 <= nums[i] <= 104
  nums contains distinct values sorted in ascending order.
  -104 <= target <= 104
*/
import java.util.Arrays;

public class SearchInsertPosition {
  public static void main(String[] args) {
    int[][] testCases = { {1,3,5,6},
                          {1,3,5,6},
                          {1,3,5,6} };
    int[] targets = {5, 2, 7};
    int[] results = {2, 1, 4};

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + Arrays.toString(testCases[i]));
      System.out.println("Target: " + targets[i]);
      System.out.println("Expected result: " + results[i]);
      System.out.println("Output produced: " + searchInsert(testCases[i], targets[i]));
      System.out.println();
    }
  }

  // Iterative, binary search solution
  // This solution uses two pointers to divide the number set in half and search repeatedly until 
  // the correct position is found.
  public static int searchInsert(int[] nums, int target) {
    // Create two pointers to track the beginning and end of the number set
    int start = 0;
    int end = nums.length - 1;

    // Iterate until the number set cannot be divided any further
    while (start <= end) {
      // Find the middle index of the current number set
      int middleIndex = start + (end - start) / 2;

      // If the number at the middle index matches the target, return that index
      if (nums[middleIndex] == target) {
        return middleIndex;
      }
      // If the number at the middle index is higher than the target, search the left half of the set
      else if (nums[middleIndex] > target) {
        end--;
      }
      // If the number at the middle index is lower than the target, search the right half of the set
      else {
        start++;
      }
    }

    // Return the starting index, which will either contain the target or represent the location where
    // the target could be added.
    return start;
  }
}