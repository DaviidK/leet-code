/*
Problem sourced from: leetcode.com

Given an array, rotate the array to the right by k steps, where k is non-negative.

Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
  1 <= nums.length <= 105
  -231 <= nums[i] <= 231 - 1
  0 <= k <= 105

Follow up:
  Try to come up with as many solutions as you can. There are at least three different ways to solve 
  this problem.
  Could you do it in-place with O(1) extra space?
*/

import java.util.Arrays;

public class RotateArray {
  public static void main(String[] args) {
    int[][] testCases = { {1,2,3,4,5,6,7},
                          {-1,-100,3,99} };
    int[] kValues = {3, 2};
    int[][] results = { {5,6,7,1,2,3,4},
                        {3,99,-1,-100} };

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + Arrays.toString(testCases[i]));
      System.out.println("K value: " + kValues[i]);
      System.out.println("Expected result: " + Arrays.toString(results[i]));
      System.out.print("Output produced: ");
      rotateTwoPointerByReversal(testCases[i], kValues[i]);
      System.out.println(Arrays.toString(testCases[i]));
      System.out.println();
    }
  }

  // First solution - Fill in a temp array with rotated elements
  // This solution will create a temp array, then go through two loops to fill it with the correct
  // elements. Once filled, the temp array will be copied into the original parameter array
  public static void rotate(int[] nums, int k) {
    // No work is required if K is a multiple of nums.length, as it will rotate "fully", leaving the 
    // original ordering for numbers
    if (k == nums.length || k % nums.length == 0) {
      return;
    }

    // Create a temp array to store the rotated numbers
    int[] result = new int[nums.length];
    // Update k to represent strictly the number of necessary rotations
    k %= nums.length;
    
    // Find the new starting point - the spot in the array where the current 0th index number will
    // be stored
    int newStart = nums.length - k;
    // Create a temp variable to store the location where the next number will be added to the temp
    // array
    int addIndex = 0;
    
    // Iterate through the second "half" of the original array, storing values in the new starting 
    // position of the temp array
    for (int i = newStart; i < nums.length; i++) {
      result[addIndex++] = nums[i];
    }

    // Iterate through the first "half" of the original array, storing values in the remaining  
    // positions of the temp array
    for (int i = 0; i < newStart; i++) {
      result[addIndex++] = nums[i];
    }
    
    // Copy the temp array into the original parameter array
    System.arraycopy(result, 0, nums, 0, nums.length);
  }

  // Two pointer solution - Reverse the array three times
  // This solution uses the logic that instead of "rotating" the array, it can instead be reversed
  // in three separate operations.
  // The first reversal will flip the entire array.
  // The second reversal will find the point at which the numbers stored at the 0th index will appear 
  // after k rotations, and flip everything before that.
  // the third reversal will flip everything after the new 0th index
  public static void rotateTwoPointerByReversal(int[] nums, int k) {
    // Nothing needs to be done if k is a multiple of nums.length, as the number set will be in the 
    // same order
    if (k == nums.length || k % nums.length == 0) {
      return;
    }
    // Update k to represent strictly the number of necessary rotations
    k %= nums.length;

    // Reverse the entire array
    rotateTwoPointerByReversalHelper(nums, 0, nums.length - 1);
    // Reverse everything until the "midpoint" of the resulting array
    rotateTwoPointerByReversalHelper(nums, 0, k - 1);
    // Reverse everything after the "midpoint" of the resulting array
    rotateTwoPointerByReversalHelper(nums, k, nums.length - 1);
  }

  // Helper method which will reverse an array from a given starting point to a given end point
  public static void rotateTwoPointerByReversalHelper(int[] nums, int start, int end) {
    // Iterate from the starting to end parameters
    while (start < end) {
      // Store the left number
      int startNum = nums[start];
      // Set the left number equal to the right
      nums[start] = nums[end];
      // Set the right number equal to the stored left number
      nums[end] = startNum;
      // Iterate both the left and right pointers
      start++;
      end--;
    }
  }

  // Brute force solution
  // This solution iterates through the entire array k number of times. 
  // In each iteration, it will move a single digit from the back to the front of the array
  public static void rotateBruteForce(int[] nums, int k) {
    // Nothing needs to be done if k is a multiple of nums.length, as the number set will be in the 
    // same order
    if (k == nums.length || k % nums.length == 0) {
      return;
    }
    // Update k to represent strictly the number of necessary rotations
    k %= nums.length;
    
    // Iterate k number of times
    for (int i = 0; i < k; i++) {
      // Store the right most number of the current array
      int temp = nums[nums.length - 1];
      // Iterate backwards through the entire array
      for (int j = nums.length - 1; j > 0; j--) {
        // Move each number one spot to the right
        nums[j] = nums[j - 1];
      }
      // Set the left number equal to the stored temp variable
      nums[0] = temp;
    }
  }
}
