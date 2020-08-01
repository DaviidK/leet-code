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

public class AddBinary {
    public static void main(String[] args) {
        
    }

    // 111
    // 11
    // i = 2
    // shortNum = '1'
    // longNum = '1'
    // carry = '1'
    // result = "0"

    // Not working currently, also not an appropriate approach for this solution
    // Overly complicated logically
    public String addBinary(String a, String b) {
        String longString = (a.length() > b.length()) ? a : b;
        String shortString = (a.length() > b.length()) ? b : a;
        String result = "";
        char carry = '0';

        // Iterate through the length of the shorter parameter
        for (int i = 1; i <= shortString.length(); i++) {
            // Pull the digits from both strings
            char shortNum = shortString.charAt(shortString.length() - i);
            char longNum = longString.charAt(longString.length() - i);

            // If both are 1 and carry is 1, then add a 1 to the result & leave carry at 1
            if ((shortNum == '1' && longNum == '1') && carry == '1') {
                result = "1" + result;
            }
            // If both are 1 and carry is 0, then add a 0 to the result & update carry to 1
            else if ((shortNum == '1' && longNum == '1') && carry == '0') {
                result = "0" + result;
                carry = '1';
            }
            // If one digit is 1 and carry is 1, add 0 to the result & leave carry at 1
            else if ((shortNum == '1' || longNum == '1') && carry == '1') {
                result = "0" + result;
            }
            // If one digit is 1 and carry is 0, add 1 to result & leave carry at 0
            else if ((shortNum == '1' || longNum == '1') && carry == '0') {
                result = "1" + result;
            }
            // If both digits are 0 and carry is 1, add 1 to result & update carry to 0
            else if ((shortNum == '0' && longNum == '0') && carry == '1'){
                result = "1" + result;
                carry = '0';
            }
            else {
                result = "0" + result;
            }
        }

        // Iterate through the rest of the longer string, adding the values into
        // result. Ensure that the carry variable is taken into account
        for (int i = longString.length() - shortString.length() - 1; i >= 0; i--) {
            // If the digit && carry are 1, add a 1 to result and leave carry at 1
            if (carry == '1' && longString.charAt(i) == '1') {
                result = "0" + result;
            }
            // If the digit is 1 & carry is 0, add a 1 to result and leave carry at 0
            else if (carry == '0' && longString.charAt(i) == '1') {
                result = "1" + result;
            }
            // If both the digit & carry are 0, add a 0 to result and leave carry at 0
            else {
                result = "0" + result;
            }
        }

        if (carry == '1') {
            result = "1" + result;
        }

        return result;
    }
}