/*
Problem sourced from: leetcode.com
Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two
numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] 
and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2]
of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Example 1:
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].

Example 2:
Input: numbers = [2,3,4], target = 6
Output: [1,3]
Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].

Example 3:
Input: numbers = [-1,0], target = -1
Output: [1,2]
Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].

Constraints:

  2 <= numbers.length <= 3 * 104
  -1000 <= numbers[i] <= 1000
  numbers is sorted in non-decreasing order.
  -1000 <= target <= 1000
  The tests are generated such that there is exactly one solution.
*/

import java.util.Arrays;

public class TwoSumPartTwo {
  public static void main(String[] args) {
    int[][] testCases = { {2,7,11,15},
                          {2,3,4},
                          {-1,0} };
    int[] targets = {9, 6, -1};
    int[][] results = { {1,2},
                        {1,3},
                        {1,2} };

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + Arrays.toString(testCases[i]));
      System.out.println("Targets: " + targets[i]);
      System.out.println("Expected result: " + Arrays.toString(results[i]));
      System.out.print("Output produced: ");
      System.out.println(Arrays.toString(twoSum(testCases[i], targets[i])));
      System.out.println();
    }
  }
  
  // Two pointer solution
  // This solution uses two pointers to iterate from both ends of the array towards the middle.
  // On each iteration, the sum of the left and right numbers will be calculated and compared to the
  // target. If the sum is smaller than the target, the left pointer will be incremented. If the sum
  // is larger than the target, the right pointer will be decremented.
  public static int[] twoSum(int[] numbers, int target) {
    // Create two pointers for left and right of array
    int start = 0;
    int end = numbers.length - 1;
    // Create array to store results
    int[] results = {-1, -1};

    // Iterate until the start and end meet, indicating all numbers have been considered
    while (start <= end) {
      // Find the sum of the left and right numbers
      int sum = numbers[start] + numbers[end];

      // If the sum is the same as the target, the result has been found
      if (sum == target) {
        // Add 1 to the indices of the left and right pointers to accound for the array being
        // 1-indexed
        results[0] = start + 1;
        results[1] = end + 1;
        return results;
      } 
      // If the sum is less than the target, increment the left pointer to find a larger number
      else if (sum < target) {
        start++;
      } 
      // If the sum is larger than the target, decrement the end to find a smaller number
      else {
        end--;
      }
    }

    return results;
  }
}
