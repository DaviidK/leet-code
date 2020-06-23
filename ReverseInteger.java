/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: 123
Output: 321

Example 2:
Input: -123
Output: -321

Example 3:
Input: 120
Output: 21

Note:
Assume we are dealing with an environment which could only store integers 
within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of 
this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println("Int: \"123\", expected: 321, received: " + reverse(123));
        System.out.println("Int: \"-123\", expected: -321, received: " + reverse(-123));
        System.out.println("Int: \"120\", expected: 21, received: " + reverse(120));
    }

    public static int reverse(int num) {
        // Store the number in a long to temporarily avoid overflow errors
        long result = 0;
        // Reverse all digits
        while (num != 0) {
            // Add another digit to result
            result *= 10;
            // Add the ones-place digit from num into result
            result += num % 10;
            // Shorten the num by one digit
            num = num / 10;
        }
        
        // Before returning result, ensure that it is still within bounds of 
        // int
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        } else {
            return (int)result;
        }
    }
}