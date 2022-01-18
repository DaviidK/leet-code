/*
Problem sourced from: leetcode.com
Given a string s, you can transform every letter individually to be lowercase or uppercase to create
another string.
Return a list of all possible strings we could create. Return the output in any order.

Example 1:
Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]

Example 2:
Input: s = "3z4"
Output: ["3z4","3Z4"]

Constraints:
  1 <= s.length <= 12
  s consists of lowercase English letters, uppercase English letters, and digits.
*/
import java.util.*;

public class LetterCasePermutation {
  public static void main(String[] args) {
    String[] testCases = {"a1b2", "3z4"};
    String[][] results = { {"3z4"}, {"3Z4"} };
  
    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + testCases[i]);
      System.out.println("Expected result: " + results[i]);
      List<String> = letterCasePermutation(testCases[i]);
      System.out.println("Output produced: ");
      System.out.println();
    }
  }

  public static List<String> letterCasePermutation(String s) {
    List<String> result = new ArrayList<>();
    letterCasePermutationHelper(s.toCharArray(), 0, result);
    return result;
  }

  public static void letterCasePermutationHelper(char[] s, int index, List<String> result) {
    if (index == s.length) {
      result.add(new String(s));
      return;
    }

    if (Character.isLetter( s[index])) {

        s[index] = Character.toUpperCase( s[index]); 
        letterCasePermutationHelper(s, index + 1, result);
        s[index] = Character.toLowerCase( s[index]);

  
        s[index] = Character.toLowerCase( s[index]); 
        letterCasePermutationHelper(s, index + 1, result);
        s[index] = Character.toUpperCase( s[index]);
    }
     
    letterCasePermutationHelper(s, index + 1, result);
  }
}