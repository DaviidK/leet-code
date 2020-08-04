/*
Problem sourced from: leetcode.com

Given an integer (signed 32 bits), write a function to check whether it is a 
power of 4.

Example 1:
Input: 16
Output: true

Example 2:
Input: 5
Output: false

Follow up: Could you solve it without loops/recursion?
*/

#include <iostream>     // For printing to console

using namespace std;

// O(n) solution using a loop. O(1) solution can be achieved via bit manipulation
bool isPowerOfFour(int num) {
    // Check edge case for 0, which is not a power of four
    if (num == 0) {
        return false;
    }

    // Loop through the number, dividing by four everytime it is possible to do
    // so without a remainder. Stop when number is 1, indicating that 4 has been
    // reached
    while(num != 1){
        // If the number is divisible by four, do so
        if (num % 4 == 0){
            num = num / 4;
        } 
        // If the number is not divisible by four, return false
        else{
            return false;
        }
    }

    // Retrun true if the number was able to be broken down completely as a factor
    // of four
    return true;
}

int main() {
    // cout << "Testing isPowerOfFour(16)" << endl;
    // cout << (isPowerOfFour(16) == true ? "true" : "false") << endl;
    cout << "isPowerOfFour(0) = " << (isPowerOfFour(0) == true ? "true" : "false") << endl;
    cout << "isPowerOfFour(1) = " << (isPowerOfFour(1) == true ? "true" : "false") << endl;
    cout << "isPowerOfFour(4) = " << (isPowerOfFour(4) == true ? "true" : "false") << endl;
    cout << "isPowerOfFour(16) = " << (isPowerOfFour(16) == true ? "true" : "false") << endl;
    cout << "isPowerOfFour(15) = " << (isPowerOfFour(15) == true ? "true" : "false") << endl;
    cout << "isPowerOfFour(65536) = " << (isPowerOfFour(65536) == true ? "true" : "false") << endl;
}