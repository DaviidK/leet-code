/*
Problem sourced from: leetcode.com

Design a HashSet without using any built-in hash table libraries.

To be specific, your design should include these functions:

    add(value): Insert a value into the HashSet. 
    contains(value) : Return whether the value exists in the HashSet or not.
    remove(value): Remove a value in the HashSet. If the value does not exist in 
    the HashSet, do nothing.

Example:
MyHashSet hashSet = new MyHashSet();
hashSet.add(1);         
hashSet.add(2);         
hashSet.contains(1);    // returns true
hashSet.contains(3);    // returns false (not found)
hashSet.add(2);          
hashSet.contains(2);    // returns true
hashSet.remove(2);          
hashSet.contains(2);    // returns false (already removed)

Note:
    All values will be in the range of [0, 1000000].
    The number of operations will be in the range of [1, 10000].
    Please do not use the built-in HashSet library.
*/

#include <iostream>         // For printing to console
#include <vector>           // For vector

using namespace std;

class MyHashSet {  
  public:
  bool elements[1000000] {false};

  void add(int key) {
      elements[key] = true;
  }

  void remove(int key) {
      elements[key] = false;
  }

  bool contains(int key) {
      return elements[key];
  }
};

int main() {
    MyHashSet hashSet;
    hashSet.add(1);         
    hashSet.add(2);         
    cout << "contains(1) = " << hashSet.contains(1) << endl;    // returns true
    cout << "contains(3) = " << hashSet.contains(3) << endl;    // returns false (not found)
    hashSet.add(2);          
    hashSet.contains(2);    // returns true
    hashSet.remove(2);          
    cout << "contains(2) = " << hashSet.contains(2) << endl; // returns false (already removed)
}
