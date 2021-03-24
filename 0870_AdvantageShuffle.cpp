/*
Problem sourced from: leetcode.com

Given two arrays A and B of equal size, the advantage of A with respect to
B is the number of indices i for which A[i] > B[i].

Return any permutation of A that maximizes its advantage with respect to B.

Example 1:
Input: A = [2,7,11,15], B = [1,10,4,11]
Output: [2,11,7,15]

Example 2:
Input: A = [12,24,8,32], B = [13,25,32,11]
Output: [24,32,8,12]

Note:
  1 <= A.length = B.length <= 10000
  0 <= A[i] <= 10^9
  0 <= B[i] <= 10^9
*/

#include <iostream>   // For printing
#include <vector>     // For vectors
#include <algorithm>  // For sort()

using namespace std;

vector<int> advantageCount(vector<int>& A, vector<int>&B) {
  // Create a vector to store results
  vector<int> result;
  
  // First, sort A to easily find smallest & largest values
  sort(A.begin(), A.end());

  // Iterate through B to preserve to order of our resulting vector
  for (int i = 0; i < B.size(); i++) {
    // If the largest value in A is smaller than the current value of B,
    // insert the smallest value from A into our result
    if (A.back() < B[i]) {
      result.push_back(A[0]);
    }
    // If the largest value in A is larger than the current value of B,
    // iterate through A and find the smallest value which is larger than
    // the current value of B 
    else {
      // Use the upper_bound() method to find the smallest value in A which
      // is still larger than B[i]
      auto it = upper_bound(A.begin(), A.end(), B[i]);
      // Add the value into the result
      result.push_back(*it);
      // Remove the value from A
      A.erase(it);
    }
  }
  return result;
}

int main() {
  vector<int> A1 = {2,7,11,15};
  vector<int> B1 = {1,10,4,11};
  vector<int> output1 = advantageCount(A1, B1);

  cout << "For input: A = [2,7,11,15], B = [1,10,4,11]" << endl;
  cout << "Output should be: [2, 11, 7, 15]" << endl;
  cout << "advatageCount(A, B) = [";
  for (int i = 0; i < output1.size() - 1; i++) {
    cout << output1[i] << ", ";
  }
  cout << output1[output1.size() - 1] << "]" << endl;
  cout << endl;

  vector<int> A2 = {12,24,8,32};
  vector<int> B2 = {13,25,32,11};
  vector<int> output2 = advantageCount(A2, B2);
  cout << "For input: A = [12,24,8,32], B = [13,25,32,11]" << endl;
  cout << "Output should be: [24, 32, 8, 12]" << endl;
  cout << "advatageCount(A, B) = [";
  for (int i = 0; i < output2.size() - 1; i++) {
    cout << output2[i] << " ";
  }
  cout << output2[output2.size() - 1] << "]" << endl;


  return 0;
}