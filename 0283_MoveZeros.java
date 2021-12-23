/*
Problem sourced from: leetcode.com

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of 
the non-zero elements.
Note that you must do this in-place without making a copy of the array.

Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]

Constraints:

  1 <= nums.length <= 104
  -231 <= nums[i] <= 231 - 1

Follow up: Could you minimize the total number of operations done?
*/

import java.util.Arrays;

public class MoveZeros {
  public static void main(String[] args) {
    int[][] testCases = { {0,1,0,3,12},
                          {0} };
    int[][] results = { {1,3,12,0,0},
                        {0} };

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + Arrays.toString(testCases[i]));
      System.out.println("Expected result: " + Arrays.toString(results[i]));
      System.out.print("Output produced: ");
      moveZeroes(testCases[i]);
      System.out.println(Arrays.toString(testCases[i]));
      System.out.println();
    }
  }

  // Two-pointer solution
  // This solution iterates through the array and checks for non-zero numbers. If a non-zero number
  // is found, it will add that number to the front of the array and increment a count of zeros.
  // After finding all non-zero numbers, this solution will go backwards through the array and add
  // zeros according to how many were found during the first iteration.
  public static void moveZeroes(int[] nums) {
    // No work necessary if the array size is 1
    if (nums.length == 1) {
      return;
    }
    // Create a temp variable to track the number of zeros found
    int zeroCount = 0;

    // Iterate through the entire array, keeping track of a second index where non-zero numbers will
    // be added
    for (int i = 0, addIndex = 0; i < nums.length; i++) {
      // If a non-zero number is found, add it to the next available position 
      if (nums[i] != 0) {
        nums[addIndex++] = nums[i];
      }
      // If a zero is found, increment the zeroCount variable
      else {
        zeroCount++;
      }
    }

    // Iterate as many times as zeros found in the first loop
    for (int i = 1; i <= zeroCount; i++) {
      // For each zero found, add a zero to the back of the array
      nums[nums.length - i] = 0;
    }
  }
}
