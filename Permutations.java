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
    
  }

  public static List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> permutations = new ArrayList<>(); 
    boolean[] flags = new boolean[nums.length];
    permuteHelper(nums, permutations, new ArrayList<Integer>(), flags);
    return permutations;
  }

  public static void permuteHelper(int[] nums, List<List<Integer>> result, List<Integer> curList, boolean[] flags) {
    if(curList.size() == nums.length) {
      result.add(new ArrayList(curList)); 
      return;
    }

    for (int i = 0; i < nums.length; i++) {
      if (!flags[i]) { 
        curList.add(nums[i]); 
        flags[i] = true;
        permuteHelper(nums, result, curList, flags);
        curList.remove(curList.size() - 1); 
        flags[i] = false; 
      }
    }
  }
}
