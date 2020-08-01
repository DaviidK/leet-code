/*
Problem sourced from: leetcode.com

Given a word, you need to judge whether the usage of capitals in it is right or
not.

We define the usage of capitals in a word to be right when one of the following 
cases holds:

    All letters in this word are capitals, like "USA".
    All letters in this word are not capitals, like "leetcode".
    Only the first letter in this word is capital, like "Google".

Otherwise, we define that this word doesn't use capitals in a right way.

Example 1:
Input: "USA"
Output: True

Example 2:
Input: "FlaG"
Output: False

Note: The input will be a non-empty word consisting of uppercase and lowercase 
latin letters.
*/

#include <iostream>     // For printing to console 
#include <string>       // For strings
#include <algorithm>    // For std::all_of
#include <vector>       // For creating test cases

using namespace std;

bool detectCapitalUse(string word) {
  // If the string has only 1 letter, return true
  if (word.length() == 1) {
    return true;
  }

  // The first case will only occur if all letters are capitalized
  if (isupper(word[0]) && all_of(word.begin(), word.end(), &::isupper)) {   // Not sure why "&::" is needed before isupper
    // If any letter is lowercase, case 1 fails
    for (char c : word) {
      if (islower(c)) {
        return false;
      }
    }

  }
  // Both the second and third cases are true if all letters after the first
  // are lower case
  else {
      // If any other letter other than the first is capitalized, cases 2 & 3
      // fail
      for (int i = 1; i < word.length(); i++) {
        if (isupper(word[i])) {
          return false;
        }
      }
  }

  // Will return true if either case 1, case 2, or case 3 are applicable
  return true;
}

int main() {
  // Create a vector and store different strings in it to be tested
  vector<string> testCases;
  testCases.push_back("USA");
  testCases.push_back("leetcode");
  testCases.push_back("Google");
  testCases.push_back("UsA");
  testCases.push_back("leeTcode");
  testCases.push_back("GooGle");

  for (string word : testCases) {
    cout << "For: " << word << "\t\t detectCapitalUse() = " << detectCapitalUse(word) << endl;
  }
}