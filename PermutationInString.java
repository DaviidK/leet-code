
/*
Problem sourced from: leetcode.com
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.

Example 1:
Input: s1 = "abc", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").

Example 2:
Input: s1 = "ab", s2 = "eidboaoo"
Output: false

Constraints:
  1 <= s1.length, s2.length <= 104
  s1 and s2 consist of lowercase English letters.
*/
import java.util.Map;
import java.util.HashMap;
import java.util.Stack;


public class PermutationInString{
  public static void main(String[] args) {
    String[] testCasesS1 = {"ab", "ab", "adc"};
    String[] testCasesS2 = {"eidbaooo", "eidboaoo", "dcda"};
    boolean[] expectedResults = {true, false, true};

    for (int i = 0; i < testCasesS1.length; i++) {
      System.out.println("Test case: S1= \"" + testCasesS1[i] + "\", S2=\"" + testCasesS2[i] + "\"");
      System.out.println("Expected result: " + expectedResults[i]);
      System.out.println("Output produced: " + checkInclusion(testCasesS1[i], testCasesS2[i]));
      System.out.println();
    }
  }

  // // Brute force solution
  // // This solution will store all possible permutations of s1, then iterate through s2 and check if 
  // // any of the permutations can be found within it.
  // public static boolean checkInclusion(String s1, String s2) {
  //   if (s1.length() > s2.length()) {
  //     return false;
  //   }
    
  //   Stack<String> permutations = new Stack<>();
    
  //   // abc --> abc, bac, bca, cab
  //   // a=1. b=1. c=1
  //   // bc --> bc, cb
  //   // c --> c
  //   String current = s1;
  //   while (current != null) {
  //     permutations.add(current);
  //     for (int i = 1; i < current.length(); i++) {
        

  //     }
  //   }
    
  //   return false;
  // }

  // Non brute force solution
  // I swear I had something for this - it definitely involved counting letters
  // all permutations must have same count of letters
  // Recall the permutations problem for numbers
  public static boolean checkInclusion(String s1, String s2) {
    if (s1.length() > s2.length()) {
      return false;
    }

    Map<Character, Integer> s1LetterCount = new HashMap<>();
    for (int i = 0; i < s1.length(); i++) {
      char s1letter = s1.charAt(i);
      if (s1LetterCount.containsKey(s1letter)) {
        s1LetterCount.put(s1letter, s1LetterCount.get(s1letter) + 1);
      } else {
        s1LetterCount.put(s1letter, 1);
      }
    }

    // Store an index that represents the start of your current substring
    int start = 0;
    while (start <= s2.length() - s1.length()) {
      Map<Character, Integer> s2LetterCount = new HashMap<>();

      for (int j = 0; j < s1.length(); j++) {
        char s2letter = s2.charAt(j + start);
        if (s2LetterCount.containsKey(s2letter)) {
          s2LetterCount.put(s2letter, s2LetterCount.get(s2letter) + 1);
        } else {
          s2LetterCount.put(s2letter, 1);
        }
      }

      if (sameLetters(s1LetterCount, s2LetterCount)) {
        return true;
      }

      start++;
    }

    return false;
  }

  public static boolean sameLetters(Map<Character, Integer> s1Map, Map<Character, Integer> s2Map) {
    for (char letter : s1Map.keySet()) {
      if (s2Map.getOrDefault(letter, -1) == -1) {
        return false;
      }
      if (s1Map.get(letter) != s2Map.get(letter)) {
        return false;
      }
    }
    
    return true;
  }
}