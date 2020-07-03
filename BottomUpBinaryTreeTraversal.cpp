/*
Problem sourced from: leetcode.com

Given a binary tree, return the bottom-up level order traversal of its nodes' 
values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7

return its bottom-up level order traversal as:

[
  [15,7],
  [9,20],
  [3]
]
*/


#include <iostream>
#include <string>
#include <vector>

using namespace std;


struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};


int main() {

  vector<string> words = vector<string>();



  return 0;
} 

vector<vector<int>> levelOrderBottom(TreeNode* root) {

  vector<vector<int>> result = vector<vector<int>>();

  
  
}