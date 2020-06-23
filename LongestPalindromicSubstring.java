/*
Problem sourced from: leetcode.com

Given a string s, find the longest palindromic substring in s. 
You may assume that the maximum length of s is 1000.

Example 1:
Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: "cbbd"
Output: "bb"
*/

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String word = "babad";
        System.out.println("longestPalindrome(\"babad\") = " + 
                            longestPalindrome(word) + " (Should be \"bab\")");
        word = "cbbd";
        System.out.println("longestPalindrome(\"cbbd\") = " + 
                            longestPalindrome(word) + " (Should be \"bb\")");
    }
    
    // This method will check each letter in the string as a possible center
    // of the palindrome
    public String longestPalindrome(String s) {
        // Edge cases: string is empty
        if (s == null || s.length() < 1) {
            return "";
        }

        // babad
        // Initialize starting & ending indices for resulting substring
        int start = 0, end = 0;
        // Iterate through each letter
        for (int i = 0; i < s.length(); i++) {
            // Length of palindrome created using the left character as center
            int len1 = checkFromCenter(s, i, i);
            // Length of palindrome created using the right character as center
            int len2 = checkFromCenter(s, i, i + 1);
            // Find which palindrome was longer
            int len = Math.max(len1, len2);
            // Update the starting & ending incides for final palindrome if a
            // longer one was found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        // Return substring created by starting & ending indices
        return s.substring(start, end + 1);
    }
    
    // This method will take in the string and two indices representing the left
    // and right characters
    private int checkFromCenter(String s, int left, int right) {
        // As long as the two indices are in range of the string and the 
        // characters at those indices are the same, expand outwards
        while (left >= 0 && right < s.length() 
               && s.charAt(left) == s.charAt(right)) {
            // Increment both left and right outwards
            left--;
            right++;
        }
        
        // Return the length of the palindrome found
        return right - left - 1;
    }
}