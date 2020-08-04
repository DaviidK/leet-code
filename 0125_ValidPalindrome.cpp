/*
Problem sourced from: leetcode.com

Given a string, determine if it is a palindrome, considering only alphanumeric 
characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
Input: "A man, a plan, a canal: Panama"
Output: true

Example 2:
Input: "race a car"
Output: false

Constraints:
    s consists only of printable ASCII characters.
*/

#include <iostream>         // For printing to console
#include <string>           // For strings

using namespace std;

bool isPalindrome(string word) {
    int wordSize = word.length();
    // Any empty string is considered a palindrome
    if (wordSize == 0) {
        return true;
    }

    string alphaNumWord;
    // Iterate through all characters in the passed string, and add any alphanumeric
    // chars into a new string
    for (char letter : word) {
        // Only add alphanumeric characters using std::isalnum()
        if(isalnum(letter)) {
            // Add characters in lower case
            alphaNumWord += tolower(letter);
        }
    }

    // Iterate through the new string, comparing characters at the front and back
    // If any characters don't match, return false
    int alphaNumSize = alphaNumWord.length();
    for (int i = 0; i < alphaNumSize / 2; i++) {
        // Compare the new string at i and at size - i - 1 (to compensate for null terminator)
        if (alphaNumWord[i] != alphaNumWord[alphaNumSize - i - 1]) {
            return false;
        }
    }

    // If all characters from first and second half were the same, the word is
    // a palindrome
    return true;
}

int main() {
    string test = "A man, a plan, a canal: Panama";
    cout << "For: \"A man, a plan, a canal: Panama\"" << endl;
    cout << "validPalindrome() = " << (isPalindrome(test) == 1 ? "true" : "false") << endl;
    test = "race a car";
    cout << "For: \"race a car\"" << endl;
    cout << "validPalindrome() = " << (isPalindrome(test) == 1 ? "true" : "false") << endl;
    return 1;
}