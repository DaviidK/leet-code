/*
Problem sourced from: leetcode.com
Given a string s, reverse the order of characters in each word within a sentence while still
preserving whitespace and initial word order.

Example 1:
Input: s = "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

Example 2:
Input: s = "God Ding"
Output: "doG gniD"

Constraints:

  1 <= s.length <= 5 * 104
  s contains printable ASCII characters.
  s does not contain any leading or trailing spaces.
  There is at least one word in s.
  All the words in s are separated by a single space.
*/
public class ReverseWordsInAStringPartTwo {
  public static void main(String[] args) {
    String[] testCases = {"Let's take LeetCode contest", "God Ding"};
    String[] results = {"s'teL ekat edoCteeL tsetnoc", "doG gniD"};

    for (int i = 0; i < testCases.length; i++) {
      System.out.println("Test case: " + testCases[i]);
      System.out.println("Expected result: " + results[i]);
      System.out.print("Output produced: ");
      System.out.println(reverseWords(testCases[i]));
      System.out.println();
    }
  }

  // Single loop solution
  // This solution will iterate through the entire string a single time, checking for when spaces 
  // appear. When a space appears, the previous word will be reversed and added to a new string.
  // A left pointer is used to track the position of the last space discovered.
  public static String reverseWords(String s) {
    // Use StringBuilder to store the resulting string
    StringBuilder result = new StringBuilder("");
    int left = 0;

    // Iterate until the end of the string
    for (int i = 0; i < s.length(); i++) {
      // Check for every space that appears
      if (s.charAt(i) == ' ') {
        // Find the word that is bounded by spaces using the first letter and the current index
        String temp = s.substring(left, i);
        // Add the reversed word to the resulting string
        result.append(reverseString(temp));
        // Append a space to maintain whitespace in between words
        result.append(" ");
        // Store the first letter of the next word in the left pointer
        left = i + 1;
      }
      // Because the string will have no trailing whitespaces, the last character of the string
      // should be treated as a space to reverse the last word
      if (i == s.length() - 1) {
        String temp = s.substring(left, i + 1);
        result.append(reverseString(temp));
      }
    }
    // Return the reversed result
    return result.toString();
  }

  // Helper method which will reverse the entirety of a given string
  public static String reverseString(String s) {
    // Use StringBuilder to create a resulting string
    StringBuilder reversed = new StringBuilder();
    int left = 0;
    int right = s.length() - 1;
    // Iterate through the entire word
    while(right >= left) {
      // Add the right-most character to the front of the resulting string
      reversed.append(s.charAt(right));
      right--;
    }
    return reversed.toString();
  }
}
