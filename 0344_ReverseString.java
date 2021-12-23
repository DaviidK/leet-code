/*
Problem sourced from: leetcode.com
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]

Constraints:

  1 <= s.length <= 105
  s[i] is a printable ascii character.
*/

import java.util.Arrays;

public class ReverseString {
  public static void main(String[] args) {
    char[][] testCases = { {'h','e','l','l','o'},
                          {'H','a','n','n','a','h'} };
    char[][] results = { {'o','l','l','e','h'},
                        {'h','a','n','n','a','H'} };

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + Arrays.toString(testCases[i]));
      System.out.println("Expected result: " + Arrays.toString(results[i]));
      System.out.print("Output produced: ");
      reverseString(testCases[i]);
      System.out.println(Arrays.toString(testCases[i]));
      System.out.println();
    }
  }

  // Two pointer solution
  // This solution uses two pointers to iterate from the left and right of the string.
  // In each iteration, the letters at the locations of each pointer will be swapped.
  public static void reverseString(char[] s) {
    // Create two pointers for left and right of the string
    int start = 0;
    int end = s.length - 1;

    // Iterate until the two pointers meet
    while (start < end) {
      // Store the letter contained at the left pointer
      char temp = s[start];
      // Move the right letter to the left pointer
      s[start++] = s[end];
      // Move the stored left letter to the right pointer
      s[end--] = temp;
    }
  }
}