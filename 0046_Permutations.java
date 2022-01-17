/*
Problem sourced from: leetcode.com
Given an array nums of distinct integers, return all the possible permutations. You can return the 
answer in any order.

Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]

Constraints:

  1 <= nums.length <= 6
  -10 <= nums[i] <= 10
  All the integers of nums are unique.
*/
import java.util.*;

public class Permutations {
  public static void main(String[] args) {
    // No test cases created for this problem
  }

  // Recursive backtracking solution
  // This solution will use backtracking to iterate through every possible permutation, adding each
  // to a final resulting list when the size of the permutation matches the size of the input.
  // The permute() method will create the resulting list, a boolean array, and a temporary list to 
  // store permutations before calling the helper method.
  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>(); 
    boolean[] usedNumbers = new boolean[nums.length];
    permuteHelper(nums, permutations, new ArrayList<Integer>(), usedNumbers);
    return permutations;
  }

  // permuteHelper() will perform the recursive backtracking by iterating through each number and 
  // creating a new call for each possible permutation.
  public static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> curList, boolean[] usedNumbers) {
    // Base case: Stop recursion when the size of the current permutation is the same as the size of
    // the input array, meaning all numbers have been used
    if(curList.size() == nums.length) {
      // Add the current permutation to the resulting list
      result.add(new ArrayList(curList)); 
      return;
    }

    // Iterate through each number in the input array
    for (int i = 0; i < nums.length; i++) {
      // Check if the number has been used in the current permutation. If so, move to the next number
      if (!usedNumbers[i]) { 
        // Add the number to the current permutation
        curList.add(nums[i]); 
        // Mark the current number as used in this permutation
        usedNumbers[i] = true;
        // Make a recursive call to fill the rest of the current permutation
        permuteHelper(nums, result, curList, usedNumbers);
        // Remove the number from the current permutation
        curList.remove(curList.size() - 1); 
        // Mark the current number as not used in this permutation
        usedNumbers[i] = false; 
      }
    }
  }
}
