/*
Problem sourced from: leetcode.com

Given a non-negative index k where k ≤ 33, return the kth index row of the 
Pascal's triangle.

Note that the row index starts from 0.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:
Input: 3
Output: [1,3,3,1]

Follow up:
Could you optimize your algorithm to use only O(k) extra space?
*/

#include <vector>     // For vectors

using namespace std;

// O(n) time complexity, O(k) space complexity 
vector<int> getRow(int rowIndex) {
  // Create array using passed index + 1 for size 
  vector<int> result(rowIndex+1);
  // Set the first value equal to one
  result[0] = 1;
  
  // Iterate through the array until the correct row is reached
  for(int i = 1; i <= rowIndex; i++) {
      // For each row, populate values by summing the values that had appeared
      // previously
      for(int j = i; j >= 1; j--) {
        result[j] += result[j-1];
      }
  }

  // Return the resulting array
  return result;
}