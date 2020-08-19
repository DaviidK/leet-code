/*
Problem sourced from: leetcode.com

Given a binary tree, return the zigzag level order traversal of its nodes' 
values. (ie, from left to right, then right to left for the next level and
alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
*/

#include <iostream>           // For printing
#include <vector>             // For vectors
#include <algorithm>          // To use the reverse() method on vectors
#include <queue>              // For queues
#include "IntTreeNode.cpp"    // For BSTree nodes

using namespace std;

vector<vector<int>> zigzagLevelOrder(IntTreeNode* root) {
  vector<vector<int>> result;

  // Return an empty vector if the tree is empty
  if (root == nullptr) {
    return result;
  }

  // Create a queue to hold nodes and add the root
  queue<IntTreeNode*> nodes;
  nodes.push(root);
  // Create a boolean that will dictate whether to print left to right or right
  // to left
  bool rightToLeft = false;

  // Iterate through the queue until all nodes have been added to a vector
  while (nodes.size() > 0) {
    // Pull the size of the current level and create a temporary vector using
    // that size
    int levelSize = nodes.size();
    vector<int> currentLevel(levelSize);

    // Iterate through all nodes in the current level
    for (int i = 0; i < levelSize; i++) {
      // Pull the next node in the queue
      IntTreeNode* currentNode = nodes.front();
      // Add the node's value to the temprorary vector
      currentLevel[i] = currentNode->value;
      // Check if there are any left children, and add them to the queue if so
      if (currentNode->left != nullptr) {
          nodes.push(currentNode->left);
      }
      // Check if there are any right children, and add them to the queue if so
      if (currentNode->right != nullptr) {
        nodes.push(currentNode->right);
      }
      // Pop the node off of the queue
      nodes.pop();
    }

    // If this level should be printed right-to-left, then reverse the array
    if (rightToLeft) {
      reverse(currentLevel.begin(), currentLevel.end());
    }
    // Add the array to the result
    result.push_back(currentLevel);
    // Flip the direction of printing after every level
    rightToLeft = !rightToLeft;
  }

  return result;
}

int main() {
  // Create the tree for testing (dynamically allocated because the method 
  // required a pointer, not an object)
  IntTreeNode* root = new IntTreeNode(3);
  root->left = new IntTreeNode(9);
  root->right = new IntTreeNode(20);
  root->right->left = new IntTreeNode(15);
  root->right->right = new IntTreeNode(7);

  // Find the answer
  vector<vector<int>> ans = zigzagLevelOrder(root);

  // Print test case and result
  cout << "For the tree:     3\n" 
       << "                 / \\\n"
       << "                9   20\n"
       << "                   /  \\\n"
       << "                  15    7" << endl;

  cout << "levelOrderBottomDFS(): \n[" << endl;
  // Print the resulting vector using the formatting shown in the example
  for (int i = 0; i < ans.size(); i++) {
    cout << "\t[";
    for (int j = 0; j < ans[i].size() - 1; j++) {
      cout << ans[i][j] << ", ";
    }
    cout << ans[i][ans[i].size() - 1] << "]" << endl;
  }
  cout << "]" << endl;

  return 0;
} 
