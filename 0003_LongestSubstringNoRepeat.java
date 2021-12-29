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

    // Non-hashmap solution
    // This solution relies on each alphanumeric digit corresponding to a unique ASCII value. Using
    // these values, a facsimile of a hashmap can be created through a 256 int array
    public int lengthOfLongestSubstring(String s) {
        int result = 0;
        // Create an array of 256 ints, this will be used to store the latest index of any given
        // character (plus an additional 1 to ensure that the length is correctly calculated)
        int[] arr = new int[256]; 
        
        // Iterate through the entire string using i, while j will store the starting index of the 
        // current substring to be evaluated
        for (int i = 0, j = 0; i < s.length(); i++) {
            // Check if the current character has been seen previously. If it has, the number stored
            // in the array will be the index at which the letter was last seen
            if (arr[s.charAt(i)] > 0) {
                // Update the starting index for the current substring to be the larger value between
                // j and the most recent appearance of the current letter
                j = Math.max(j,arr[s.charAt(i)]);
            }

            // Update the index array to store the latest appearance of the current letter
            arr[s.charAt(i)] = i + 1;
                
            // Update the result to store the longest substring found so far
            result = Math.max(result, i - j + 1);
        }

        // Return the longest substring
        return result;
    }

}