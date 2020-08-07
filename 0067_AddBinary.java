/*
Problem sourced from: leetcode.com

Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"

Example 2:

Input: a = "1010", b = "1011"
Output: "10101"


Constraints:

    Each string consists only of '0' or '1' characters.
    1 <= a.length, b.length <= 10^4
    Each string is either "0" or doesn't contain any leading zero.
*/

// Java doesn't allow underscores in file names, so it's necessary to rename the 
// file before compiling. I chose to keep the underscore for easy organization
// within my git repo, given that these files are often never compiled after being 
// committed
public class AddBinary {

  public String addBinary(String a, String b) {
    // Stringbuilder which will store the result
    StringBuilder result = new StringBuilder();
    
    // Start at the last character of the first string
    int word1Pos = a.length() - 1;
    // Start at the last character of the second string
    int word2Pos = b.length() - 1;
    // Variable which represents any values that need to be carried over
    int carry = 0; 
    
    // Add the two strings so long as they are the same length
    while(word1Pos >= 0 || word2Pos >= 0) {
      // Character from first string
      int c1 = 0;
      // Character from second string
      int c2 = 0;
        
      // If there are still characters in the first string, save the next one into
      // c1
      if(word1Pos >= 0) {
        // Subtract '0' to convert it to an int
        c1 = a.charAt(word1Pos) - '0';
      }
      
      // If there are still characters in the second string, save the next one into
      // c2
      if(word2Pos >= 0) {
        // Subtract '0' to convert it to an int
        c2 = b.charAt(word2Pos) - '0';
      }
        
      // Sum the two characters, adding the carried value as well
      int sum = c1 + c2 + carry;
      
      // If the sum is 1 or 0, append that answer to the result
      if(sum <= 1) {
        result.append(Integer.toString(sum));
        // Set the carry to 0
        carry = 0;
      } 
      // If the sum is larger than 1, append either a 0 or 1 to result depending on
      // the sum.  
      else {
        // Sum % 2 can only be a 0 or 1
        result.append(Integer.toString(sum % 2));
        // Set carry to 1
        carry = 1;
      }
      
      // Move the two position pointers one position to the left
      word1Pos--;
      word2Pos--;
    }
    
    // If there is something leftover in the carry, append it to the end
    if(carry != 0) {
        result.append(carry);
    }
    
    // Finally, reverse the string to get the final result
    return result.reverse().toString();
  }
}