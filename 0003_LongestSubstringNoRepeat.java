/*
Problem sourced from: leetcode.com

Given a string, find the length of the longest substring without repeating characters.  

Example 1:
Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 

Example 2:
Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence 
             and not a substring.
*/

public class LongestSubstringNoRepeat {
    public static void main(String[] args) {
        System.out.println("String: \"abcabcbb\", expected: 3, received: " + lengthOfLongestSubstring("abcabcbb"));
        System.out.println("String: \"bbbbb\", expected: 1, received: " + lengthOfLongestSubstring("bbbbb"));
        System.out.println("String: \"pwwkew\", expected: 3, received: " + lengthOfLongestSubstring("pwwkew"));
        System.out.println(
                "String: \"abczbdegtopb\", expected: 9, received: " + lengthOfLongestSubstring("abczbdegtopb"));
    }
    
    // Using a HashTable, the problem can be simplified
    public int lengthOfLongestSubstringHash(String s) {
        // Create HashTable to store characters that have been seen with their
        // index value in the string
        Map<Character, Integer> visitedChars = new HashMap<>();
        // Create starting index that will move with substring
        int start = 0;
        int max = 0;
        
        // Iterate through the passed string
        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            // Check if the character has been seen before
            if (visitedChars.containsKey(letter)) {
                if (visitedChars.get(letter) >= start) {
                    start = visitedChars.get(letter) + 1;
                }
            }
            // Compare current substring length to known maximum
            max = Math.max(max, i - start + 1);
            // Add the visited character into the HashTable
            visitedChars.put(letter, i);
        }
        
        return max;
    }

    // Attempt to complete problem in O(n) without using an extra data structure
    public static int lengthOfLongestSubstring(String s) {
        // Create result counter and string representing vharacters that have
        // already been seen
        int max = 0;
        String currentChars = "";

        // Iterate through the passed string, checking each charcter individually
        for (int i = 0; i < s.length(); i++) {
            // Pull the current character from the passed string
            char letter = s.charAt(i);

            // Check if the current character has been seen before
            if (currentChars.contains(letter)) {
                max -= currentChars.indexOf(letter) + 1;
                currentChars = currentChars.substring(currentChars.indexOf(letter) + 1, currentChars.length);
            } else {
                max++;
                currentChars += letter;
            }
        }
        
        return max;
    }
    

}