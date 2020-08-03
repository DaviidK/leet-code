/*
Problem sourced from: leetcode.com

Given a non-negative integer num, repeatedly add all its digits until the result
has only one digit.

Example:

Input: 38
Output: 2 
Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2. 
             Since 2 has only one digit, return it.

Follow up:
Could you do it without any loop/recursion in O(1) runtime?
*/

#include <iostream>
#include <vector>

using namespace std;

/**
 * "Brute force" solution
 * Parse through the passed number digit by digit, continuously adding the digits
 * until reaching a single number. Will reset the value of passed number after
 * each iteration
 * O(logn) runtime
*/
int addDigitsIterative(int num) {
    int newSum = 0;
    // Loop until num is a single digit
    while (num > 0) {
        // Add the last digit to num
        newSum += num % 10;
        // Take off a digit from num
        num = num / 10;
        
        // Check if all digits in the current number have been added together.
        // If the result is still multiple digits long, reset num and add through
        // the new number
        if (newSum >= 10 && num == 0) {
            num = newSum;
            newSum = 0;
        }
        
    }     
    
    return newSum;
}

/**
 * Constant solution
 * The formula for the digital root can be found here: https://en.wikipedia.org/wiki/Digital_root
 * O(n) runtime
*/
int addDigits(int num) {
    return num % 9;
}