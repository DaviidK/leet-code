/*
Given an integer x, return true if x is palindrome integer.
An integer is a palindrome when it reads the same backward as forward.
  For example, 121 is a palindrome while 123 is not.

Example 1:
Input: x = 121
Output: true
Explanation: 121 reads as 121 from left to right and from right to left.

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is
not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Constraints:
  -231 <= x <= 231 - 1
*/
public class IsPalindrome {

  public static void main(String[] args) {
    System.out.println("checkPalindrome(121): " + checkPalindrome(121));
    System.out.println("checkPalindrome(-121): " + checkPalindrome(-121));
    System.out.println("checkPalindrome(000): " + checkPalindrome(000));
    System.out.println("checkPalindrome(1221): " + checkPalindrome(1221));
    System.out.println("checkPalindrome(556): " + checkPalindrome(556));
    System.out.println("checkPalindrome(10): " + checkPalindrome(10));
  }

  public static boolean checkPalindrome(int num) {
    // Negative numers cannot be palindromes
    if(num < 0) {
      return false;
    }

    // Any non-zero numbers which end in 0 cannot be palindromes
    if (num != 0 && num % 10 == 0) {
      return false;
    }

    // Create a new number that will represent the test case when read right-to-left
    int reverseNum = 0;
    // Iterate until the test number is lower than the new number, meaning half the digits have
    // been read
    while (num > reverseNum) {
      // Add the right most digit to the reverseNum
      reverseNum = reverseNum * 10 + (num % 10);
      // Remove the right most digit from the test case
      num /= 10;
    }

    // Compare the reversed number to the test case, palindromes will be the same
    // Make sure to compare both the numbers as-is, and after removing the right most digit from the
    // reversed number, to accomodate for test cases with odd amounts of digits
    return (num == reverseNum || num == (reverseNum / 10));
  }
}