/*
Problem sourced from: leetcode.com
Given a column title as appear in an Excel sheet, return its corresponding column
number.

For example:
    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

Example 1:
Input: "A"
Output: 1

Example 2:
Input: "AB"
Output: 28

Example 3:
Input: "ZY"
Output: 701

Constraints:

    1 <= s.length <= 7
    s consists only of uppercase English letters.
    s is between "A" and "FXSHRXW".
*/

#include <string>     // For strings
#include <cmath>      // For pow()

using namespace std;

int titleToNumber(string s) {
  int result = 0;
  // Loop through the passed string
  for(int i = 0; i < s.size(); i++) {
    // For each character, multiply the previous value by 26, then add in the 
    // value of the current character
    result = (result * 26) + (s[i] - 'A' + 1);
  }
  
  return result;
}