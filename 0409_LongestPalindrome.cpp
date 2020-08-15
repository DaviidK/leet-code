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

using namespace std;

// The solution below was taken via a discussion 
// Link: https://leetcode.com/problems/longest-palindrome/discuss/435222/C%2B%2B-Concise-Solution-Explained-100-Time-~99-Space
int longestPalindrome(string s) {
  // res created, frequency array initialised and populated
  int res = 0;
  int f[52];
  
  for (auto &e: f) { 
    e = 0;
  }

  for (auto c: s) {
    f[c < 'a' ? c - 'A' : c - 'a' + 26]++;
  }

  for (auto e: f) {
    // I take the frequence and round it down to the next multiple of 2
    res += e >> 1 << 1;
  }
  
  // if i did not use all the available characters, then the max lenght is + 1
  return res + (res != s.size());
}
