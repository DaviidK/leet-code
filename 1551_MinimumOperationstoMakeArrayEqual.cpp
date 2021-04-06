/*
Problem sourced from: leetcode.com
You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid
values of i (i.e. 0 <= i < n).

In one operation, you can select two indices x and y where 0 <= x, y < n 
and subtract 1 from arr[x] and add 1 to arr[y] 
(i.e. perform arr[x] -=1 and arr[y] += 1). 
The goal is to make all the elements of the array equal. It is guaranteed
that all the elements of the array can be made equal using some operations.

Given an integer n, the length of the array. Return the minimum number of 
operations needed to make all the elements of arr equal.

 

Example 1:
Input: n = 3
Output: 2
Explanation: arr = [1, 3, 5]
First operation choose x = 2 and y = 0, this leads arr to be [2, 3, 4]
In the second operation choose x = 2 and y = 0 again, thus arr = [3, 3, 3].

Example 2:
Input: n = 6
Output: 9

Constraints:
  1 <= n <= 10^4
*/

// Number of operations can be determined mathematically.

int minOperations(int n) {
  // If n is odd, there is a median value in the array which all elements must
  // be modified to equal. Doing this will require 2*x operations for each element, 
  // where x is the distance from the midpoint. The total operations will
  // be a summation of these numbers for 0 to (n-1)/2, which represents
  // the number of elements on one side of the median. Summation formula is:
  // x * (x + 1), where x = (n-1)/2
  if (n % 2 != 0) {
    int x = (n - 1) / 2;
    return x * (x + 1);
  }
  // If even, the same principle applies, but the median value will now be 
  // an average of the middle two elements. This also changes the number of 
  // elements that are summed to n/2. When substituting n/2 back into the 
  // summation formula, the result is x^2.
  else {
    int x = n / 2;
    return x * x;
  }
}