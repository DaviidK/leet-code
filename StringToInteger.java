/*
Problem sourced from: leetcode.com

Implement atoi which converts a string to an integer. The function first 
discards as many whitespace characters as necessary until the first non-whitespace
character is found. Then, starting from this character, takes an optional initial
plus or minus sign followed by as many numerical digits as possible, and interprets
them as a numerical value.

The string can contain additional characters after those that form the integral
number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral
number, or if no such sequence exists because either str is empty or it contains 
only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.

Note: Only the space character ' ' is considered as whitespace character. Assume
we are dealing with an environment which could only store integers within the 32-bit
signed integer range: [−231,  231 − 1]. If the numerical value is out of the range
of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.

Example 1:
Input: "42"
Output: 42

Example 2:
Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.

Example 3:
Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.

Example 4:
Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical 
             digit or a +/- sign. Therefore no valid conversion could be performed.

Example 5:
Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
*/

public class StringToInteger {
    public static void main(String[] args) {
        System.out.println("String: \"42\", expected: 42, received: " + myAtoi("42"));
        System.out.println("String: \"   -42\", expected: -42, received: " 
                          + myAtoi("   -42"));
        System.out.println("String: \"words and 987\", expected: 0, received: " 
                          + myAtoi("words and 987"));
        System.out.println("String: \"-91283472332\", expected: -2147483648, received: " 
                          + myAtoi("-91283472332"));
    }
    
    public static int myAtoi(String str) {

        // Return 0 if string is empty, null, or only contains a single space
        if (str == null || str.length() == 0 || str.equals(" ")) {
            return 0;
        }
        
        // Number taken out of string
        int num = 0;
        // Index within string
        int index = 0;
        // Flag used to determine if positive or negative
        boolean positive = true;
        // Count of signs found in string
        int signCount = 0;

        // Move past all whitespace characters 
        while (str.charAt(index) == ' ' && index < str.length()) {
            index++;
        }

        // Check if string contains a positive sign
        if (str.charAt(index) == '+') {
            index++;
        }
        // Check if the string contains a negative sign
        else if (str.charAt(index) == '-') {
            positive = false;
            index++;
        }

        // If two characters are found in a row, the string is invalid
        if (str.charAt(index) == '+' || str.charAt(index) == '-') {
            return 0;
        }

        // Construct a number by going through each character in the string
        while (index < str.length()) {
            // Pull the character at the current index
            char digit = str.charAt(index);

            // Stop building the number if an invalid character is found
            if (digit < '0' || digit > '9') {
                break;
            }

            // Check if multiplying the number by 10 would move it out of range
            // If so, return the correct Min/Max int value
            if (Integer.MAX_VALUE / 10 < num
                    || Integer.MAX_VALUE / 10 == num && Integer.MAX_VALUE % 10 < (digit - '0')) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            // Multiply the number by 10 to add a new digit to the number, then
            // add the newly pull character to the number
            num = num * 10 + (digit - '0');
            index++;
        }
        
        // Check if the number should be positive or negative and return accordingly
        return positive ?  num : (-1 * num);
    }
}