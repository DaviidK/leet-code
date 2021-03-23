/*
Problem sourced from: leetcode.com
Given an integer array arr, and an integer target, return the number of tuples i, j, k such that i < j < k and arr[i] + arr[j] + arr[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.

Example 1:
Input: arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
Explanation: 
Enumerating by the values (arr[i], arr[j], arr[k]):
(1, 2, 5) occurs 8 times;
(1, 3, 4) occurs 8 times;
(2, 2, 4) occurs 2 times;
(2, 3, 3) occurs 2 times.

Example 2:
Input: arr = [1,1,2,2,2,2], target = 5
Output: 12
Explanation: 
arr[i] = 1, arr[j] = arr[k] = 2 occurs 12 times:
We choose one 1 from [1,1] in 2 ways,
and two 2s from [2,2,2,2] in 6 ways.

Constraints:
    3 <= arr.length <= 3000
    0 <= arr[i] <= 100
    0 <= target <= 300
*/

#include <iostream>   // For printing
#include <vector>     // For vectors
#include <algorithm>  // For sort()

using namespace std;

// This solution sorts the array and then uses the two-pointer technique
// that would normally be used on TwoSum
int threeSumMultiplicity(vector<int>& nums, int target) {
  int size = nums.size();
  int result = 0;
  int modulo = 1000000007;

  // Begin by sorting the data
  sort(nums.begin(), nums.end());

  for (int i = 0; i < size - 2; i++) {
    // Subtract the value stored at i from the target to find a new target value
    int secondTarget = target - nums[i];
    // Create j and k to mark the beginning and the end of the new set of
    // values to be considered
    int j = i + 1;
    int k = size - 1;
    // Iterate through all combinations of the remaining values to consider
    while (j < k) {
      // If a combination of values is equal to the new target, count the 
      // triplet of nums[i], nums[j], nums[k]
      if (nums[j] + nums[k] == secondTarget) {
        // If the values at j & k are the same, count the number of occurrences
        // of that value
        if (nums[j] == nums[k]) {
          // Counting the number of occurrences of the value
          result += ((k - j) * (k - j + 1)) / 2;
          // Refactoring the result to fit according to problem specifications
          result = result % modulo;
          // Ending this round of iteration
          break;
        }
        // If the values at j & k are different, the number of occurrences
        // for both values must be counted individually
        else {
          // Create left and right counters to track values
          int countLeft = 1;
          int countRight = 1;
          // Count occurrences of the left value
          while (j + 1 < k && nums[j] == nums[j + 1]) {
            j++;
            countLeft++;
          }
          // Count occurrences of the right value
          while (k - 1 >= j && nums[k] == nums[k -1]) {
            k--;
            countRight++;
          }
          j++;
          k--;
          // Add all combinations of values to the result
          result += (countLeft * countRight) % modulo;
        }
      }
      // If the combination of values is smaller than the new target, move
      // the left pointer
      else if (nums[j] + nums[k] < secondTarget) {
        j++;
      }
      // If the combination of values is larger than the new target, move
      // the right pointer
      else {
        k--;
      }
    }
  }
  return result;
}

int main() {
  vector<int> input = {1,1,2,2,3,3,4,4,5,5};
  cout << "For the input: [1,1,2,2,3,3,4,4,5,5]" << endl;
  cout << "And the target: 8" << endl;
  cout << "Result should be 20" << endl;
  cout << "threeSumMultiplicity(input, 8) = " << threeSumMultiplicity(input, 8);
  cout << "\n" << endl;
  vector<int> secondInput = {1,1,2,2,2,2};
  cout << "For the input: [1,1,2,2,2,2]" << endl;
  cout << "And the target: 5" << endl;
  cout << "Result should be 12" << endl;
  cout << "threeSumMultiplicity(input, 8) = " << threeSumMultiplicity(secondInput, 5);
  return 0;
}