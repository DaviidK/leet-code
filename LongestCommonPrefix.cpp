/*
Problem sourced from: leetcode.com

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:
Input: ["flower","flow","flight"]
Output: "fl"


Example 2:
Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note All given inputs are in lowercase letters a-z.
*/


#include <iostream>
#include <string>
#include <vector>
#include <climits>

using namespace std;

class LongestCommonPrefix {  
  public:
    // Brute force solution
    string longestCommonPrefix(vector<string> arr) {
      if (arr.size() <= 0) {
        return "";
      }

      string result = "";
      int resultSize = INT_MAX;
      
      for (string s : arr) {
        if (s.length() < resultSize) {
          resultSize = s.length();
        }
      }

      for (int i = 0; i < resultSize; i++) {
        // Read in the letter at index i from the first word 
        char letter = arr[0][i];

        // Iterate through the other words
        for (int j = 1; j < arr.size(); j++) {
          // If the letters are not the same, return the substring that has been
          // created so far
          if (arr[j][i] != letter) {
            return result;
          }
        }

        // Add the letter to the result substring
        result += letter;
      }
      
      return result;
    }
    

};

int main() {

  LongestCommonPrefix obj = LongestCommonPrefix(); 
  vector<string> words = vector<string>();

  words.insert(words.end(), {"flower", "flow", "flight"});
  cout << "For {\"flower\", \"flow\", \"flight\"}, longestCommonPrefix() = "
       << obj.longestCommonPrefix(words) << endl;

  words.clear();
  words.insert(words.end(), {"dog", "racecar", "car"});
  cout << "For {\"dog\", \"racecar\", \"car\"}, longestCommonPrefix() = "
       << obj.longestCommonPrefix(words) << endl;

  words.clear();
  words.insert(words.end(), {"hyperactive", "hypermile", "hyperbeam"});
  cout << "For {\"hyperactive\", \"hypermile\", \"hyperbeam\"}, longestCommonPrefix() = "
       << obj.longestCommonPrefix(words) << endl;

  return 0;
} 