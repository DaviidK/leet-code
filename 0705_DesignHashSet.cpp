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
#include <algorithm>        // For find() in vectors

using namespace std;
// "Brute force" solution - use an array of the size necessary to store boolean
// values, and simply change the index value associated with each number
// class MyHashSet {   
//   public:
//   bool elements[1000000] {false};

//   void add(int key) {
//       elements[key] = true;
//   }

//   void remove(int key) {
//       elements[key] = false;
//   }

//   bool contains(int key) {
//       return elements[key];
//   }
// };

// Single-hashing solution: Create a vector
class MyHashSet {
    public:
        MyHashSet() {
            size = 1009;
            elements.resize(size);
        }

        void add(int value) {
            // Find index of inner vector corresponding to the passed value
            int index = value % size;
            // If the value is not contained in the inner vector, add it
            if (find(begin(elements[index]), end(elements[index]), value) == end(elements[index])) {
                elements[index].push_back(value);
            }
        }

        void remove(int value) {
            // Find the index of the inner vector corresponding to the passed value
            int index = value % size;
            // Find the position of the value inside the inner vector
            auto position = find(begin(elements[index]), end(elements[index]), value);
            // If the position is not the last element, remove that position
            if (position != end(elements[index])) {
                elements[index].erase(position);
            }

            //// ALTERNATIVE SOLUTION: Avoid using iterators by substituting a 
            //// for-i loop
            // int position = -1;
            // for (int i = 0; i < elements[index].size(); i++) {
            //     if (elements[index][i] == value) {
            //         position = i;
            //     }
            // }
            // if (find(begin(elements[index]), end(elements[index]), value) != end(elements[index])) {
            //     elements[index].erase(begin(elements[index] + position));
            // }
        }

        bool contains(int value) {
            // Find index of inner vector corresponding to the passed value
            int index = value % size;
            // Loop through the inner vector searching for the value. If the end 
            // is reached, then the value was not contained in the HashSet
            return find(begin(elements[index]), end(elements[index]), value) != end(elements[index]);
        }

    private:
        vector<vector<int>> elements;
        int size;
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
