/*
Problem sourced from: leetcode.com

Design an Iterator class, which has:

    A constructor that takes a string characters of sorted distinct lowercase English letters and a number combinationLength as arguments.
    A function next() that returns the next combination of length combinationLength in lexicographical order.
    A function hasNext() that returns True if and only if there exists a next combination.

Example:
CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.

iterator.next(); // returns "ab"
iterator.hasNext(); // returns true
iterator.next(); // returns "ac"
iterator.hasNext(); // returns true
iterator.next(); // returns "bc"
iterator.hasNext(); // returns false

Constraints:
    1 <= combinationLength <= characters.length <= 15
    There will be at most 10^4 function calls per test.
    It's guaranteed that all calls of the function next are valid.
*/

import java.util.ArrayList;        // For arraylist to store combinations
import java.lang.StringBuilder;    // For strinbuilder when populating combinations

// Java doesn't allow underscores in file names, so it's necessary to rename the 
// file before compiling. I chose to keep the underscore for easy organization
// within my git repo, given that these files are often never compiled after being 
// committed
public class CombinationIterator {
  // An ArrayList that will store all possible combinations.
  // Populated during construction of an object
  private ArrayList<String> allCombinations;
  // Index used to determine where in the combination list the iterator currently is
  private int curIndex;
  // Length passed by user that is used to find all combinations
  private int combinationLength;

  // Creates an iterator containing all combinations of combLen from chars
  public CombinationIterator(String chars, int combLen) {
    // Start index at 0
    curIndex = 0;
    // Instantiate the combination list
    allCombinations = new ArrayList<>();
    // Set the combinationLength to the passed parameter
    combinationLength = combLen;

    // Only populate the combinations arraylist if there are characters provided
    if (chars.length() != 0) {
      // Create a stringbuilder that will be used to build combinations
      StringBuilder sb = new StringBuilder();
      // Build the combination list using the getCombinations method 
      getCombinations(sb, chars, 0);
    }   
  }

  // Will return the next combination available in the ArrayList 
  public String next() {
    // Return the next combination and increment curIndex afterwards
    return allCombinations.get(curIndex++);
  }
  
  // Returns true if another combination is available in the ArrayList
  public boolean hasNext() {
    return curIndex < allCombinations.size();
  }

  // Populates the allCombinations ArrayList using recursive backtracking
  public void getCombinations(StringBuilder sb, String chars, int index) {
    // Base case: Current string has reached the specified combination length
    if (sb.length() == combinationLength) {
      // Add the current string to the known combinations
      allCombinations.add(sb.toString());
      // End recursive call
      return;
    }

    // Iterate through the all the characters available, starting at the passed
    // index
    for (int i = index; i < chars.length(); i++) {
      // Add a character into the current string
      sb.append(chars.charAt(i));
      // Make a recursive call, using the next character as a starting point
      getCombinations(sb, chars, i + 1);
      // Remove the added character to allow for a backtracking solution
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
