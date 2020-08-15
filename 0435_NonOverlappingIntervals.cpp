/*
Problem sourced from: leetcode.com

Given a string which consists of lowercase or uppercase letters, find the length
of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:
Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

#include <vector>         // For vectors
#include <algorithm>      // For sort()

using namespace std;

// This helper method will be passed to std::sort() in order to determine the
// order of the sorted intervals
bool compareVectors(vector<int> &v1,vector<int> &v2) {
	return v1[1] < v2[1];
}

// This solution will involve first sorting the intervals, then traversing
// through the result, searching for any point of overlap
int eraseOverlapIntervals(vector<vector<int>> &intervals) {
  // If intervals are empty, return 0
  if (intervals.size() == 0) {
    return 0;    
  }

  // Instantiate result to -1, because the first iteration of the loop will 
  // always increment the result
  int result = -1;      
     
  // Use the std::sort() method to sort the intervals according to the above helper
  // method
  sort(intervals.begin(),intervals.end(),compareVectors);

  // Create a prev tracker which will track the interval used to determine overlap
  vector<int> prev = intervals[0];

  // Traverse through the sorted intervals  
  for (vector<int> i : intervals) {
    // Check if current interval overlaps with the prev tracker
    if (prev[1] > i[0]) {
      result++;                
    } 
    // If the interval doesn't overlap, update the tracker to the current interval
    else {
      prev = i;
    }          
  }
  
  return result;                 
}