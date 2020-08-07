/*
Problem sourced from: leetcode.com

Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)

search(word) can search a literal word or a regular expression string containing
only letters a-z or .. A . means it can represent any one letter.

Example:
addWord("bad")
addWord("dad")
addWord("mad")
search("pad") -> false
search("bad") -> true
search(".ad") -> true
search("b..") -> true

Note:
You may assume that all words are consist of lowercase letters a-z.

Your WordDictionary object will be instantiated and called as such:
  WordDictionary obj = new WordDictionary();
  obj.addWord(word);
  boolean param_2 = obj.search(word);
*/

import java.util.*;     // For map of TrieNode children

// Java doesn't allow underscores in file names, so it's necessary to rename the 
// file before compiling. I chose to keep the underscore for easy organization
// within my git repo, given that these files are often never compiled after being 
// committed
public class WordDictionary {
  // The inner-class TrieNode is used as a data structure which allows us to build
  // a trie
  private class TrieNode {
    public char letter;
    public boolean isTerminal;
    public Map<Character, TrieNode> children;

    public TrieNode() {
      this('/', false, new HashMap<>());
    }

    public TrieNode(char l) {
      this(l, false, new HashMap<>());
    }

    public TrieNode(char l, boolean isT) {
      this(l, isT, new HashMap<>());
    }

    public TrieNode(char l, boolean isT, Map<Character, TrieNode> c) {
      this.letter = l; 
      this.isTerminal = isT;
      this.children = c;
    }
  }

  private TrieNode root;

  /** Initialize your data structure here. */
  public WordDictionary() {
    root = new TrieNode();
  }

  /** Adds a word into the data structure. */
  public void addWord(String word) {
    TrieNode current = root; 

    // Iterate through the length of the word
    for (int i = 0; i < word.length(); i++) {
      char letter = word.charAt(i);
      // If the next letter isn't found in the trie, add a new node containing that letter
      // to the children of the current node
      if (!current.children.containsKey(letter)) {
        current.children.put(letter, new TrieNode(letter));
      } 
      // Move current to the next letter
      current = current.children.get(letter);
    }
    current.isTerminal = true;
  }

  /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
  public boolean search(String word) {
    // Return false if the trie is empty
    if (root == null) {
      return false;
    }
    // Use the helper method to search through all children nodes
    return searchHelper(word, root);
  }

  public boolean searchHelper(String word, TrieNode node) {
    // If the end of the word has been reached, check if the current node is
    // marked as a terminal point
    if (word.length() == 0) {
      return node.isTerminal;
    }

    // Pull the first letter from the word
    char letter = word.charAt(0);

    // If the letter is a period, any letter is valid in that position. 
    if (letter == '.') {
      // Iterate through every child node to see if the word can be found
      for (TrieNode n : node.children.values()) {
        if(searchHelper(word.substring(1), n)) {
          return true;
        }
      }
    }
    // If the letter is not a period, check if the letter is contained in a child
    // node to the current letter
    else if (node.children.containsKey(letter)) {
      // Move current to the next letter if it exists in the children
      return searchHelper(word.substring(1), node.children.get(letter));
    }

    // If the letter is not found in the children, or if it is a period and no 
    // child can find the word, return false
    return false;
  }
}



