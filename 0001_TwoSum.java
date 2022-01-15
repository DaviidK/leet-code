/*
Problem sourced from: leetcode.com

Given an array of integers, return indices of the two numbers such that they add
up to a specific target. You may assume that each input would have exactly one
solution, and you may not use the same element twice.
*/

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int targetNum = 9;
        System.out.println("Given nums = [2, 7, 11, 15], target = 9:");
        System.out.println("twoSumBruteForce(): " + Arrays.toString(twoSumBruteForce(numbers, targetNum)));
        System.out.println("twoSumHashTable(): " + Arrays.toString(twoSumHashTable(numbers, targetNum)));   
        System.out.println();  

        int[] numbers2 = {-5, 3, 99, 4, 11, 8, -2};
        targetNum = 3;
        System.out.println("Given nums = [-5, 3, 99, 4, 11, 8, -2], target = 3:");
        System.out.println("twoSumBruteForce(): " + Arrays.toString(twoSumBruteForce(numbers2, targetNum)));
        System.out.println("twoSumHashTable(): " + Arrays.toString(twoSumHashTable(numbers2, targetNum))); 
    } 
    
    // Brute force solution, O(n^2) runtime
    public static int[] twoSumBruteForce(int[] nums, int target) {
        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // For each number, see if there is any other number that can add 
            // to the target
            for (int j = i + 1; j < nums.length; j++) {
                // If a complementary number exists, return the two indices
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        throw new IllegalArgumentException("No solution");
    }

    // Using a HashTable, O(n) runtime
    public static int[] twoSumHashTable(int[] nums, int target) {
        // Create a HashMap to store all numbers that have been evaluated
        Map<Integer, Integer> numbersEvaluated = new HashMap<>();
        // Iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complementary number that would add up to the target
            int complement = target - nums[i];
            // If the complementary number exists in the map, find its index value
            // and return the pair of indices 
            if (numbersEvaluated.containsKey(complement)) {
                return new int[] {numbersEvaluated.get(complement), i};
            }
            // Save the index of the current number at a key value of the number itself
            numbersEvaluated.put(nums[i], i);
        }

        throw new IllegalArgumentException("No solution");
    }

}