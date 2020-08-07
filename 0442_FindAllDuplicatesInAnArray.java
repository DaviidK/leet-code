/*
Problem sourced from: leetcode.com

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements
appear twice and others appear once.

Find all the elements that appear twice in this array.
Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
*/
import java.util.*;

/**
 * O(n) runtime, O(1) space
 * Go through the array and use the values stored to access indices in the array.
 * Because the values must be between 1 < arr.length, each value must correspond
 * to a valid index position. 
 * Once an index has been pulled, "mark" the value stored at that index by 
 * assigning it a negative value
 * If a negative value is encountered when marking, that index has already 
 * been visited, thus the index number is a duplicate
*/
public class FindAllDuplicatesInAnArray {
  public static List<Integer> findDuplicates(int[] nums) {
    List<Integer> result = new ArrayList<>();

    // Iterate through each value in the array
    for (int i = 0; i < nums.length; i++) {
      // Use the value to pull a possible index in the array. Pull as absolute 
      // value to avoid reaching for a negative index
      int index = Math.abs(nums[i]);

      // Check if the value stored at the pulled index is negative. If so, this
      // index has been pulled before, meaning the index is a duplicate number
      // in the array
      if (nums[index - 1] < 0) {
        // Add the duplicate number to the resulting list
        result.add(nums[index]);
      }
      // Mark the value at the pulled index as visited by making it negative
      else {
        nums[index - 1] *= -1;
      }    
    }

    return result;
  }
}