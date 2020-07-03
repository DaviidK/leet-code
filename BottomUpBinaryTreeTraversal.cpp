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


#include <iostream>   // For printing
#include <vector>     // For vectors
#include <algorithm>  // For vector reverse() function 

using namespace std;


struct TreeNode {
  int val;
  TreeNode *left;
  TreeNode *right;
  TreeNode() : val(0), left(nullptr), right(nullptr) {}
  TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
  TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
};

// DFS Traversal that adds values into result vector
void dfs(TreeNode* root, vector<vector<int>> &result, int level) {
  // Base case: a null element in the tree has been reached
  if (root == NULL) {
    return;
  }

  // Add in an empty array if the current result doesn't have enough levels stored
  if (result.size() < level + 1) {
    result.push_back({});
  }

  if (root->left != NULL) {
    dfs(root->left, result, level + 1);
  }

  if (root->right != NULL) {
    dfs(root->right, result, level + 1);
  }

  result[level].push_back(root->val);
}

vector<vector<int>> levelOrderBottomDFS(TreeNode* root) {
  vector<vector<int>> result = vector<vector<int>>();
  // If passed an empty tree, return an empty array
  if (root == NULL) {
    return result;
  }

  // Build the resulting vector using DFS traversal
  dfs(root, result, 0);
  // Reverse the order of the result
  reverse(result.begin(), result.end());
  return result;
}

int main() {
  // Create the tree for testing (dynamically allocated because the method 
  // required a pointer, not an object)
  TreeNode* root = new TreeNode(3);
  root->left = new TreeNode(9);
  root->right = new TreeNode(20);
  root->right->left = new TreeNode(15);
  root->right->right = new TreeNode(7);

  // Find the answer
  vector<vector<int>> ans = levelOrderBottomDFS(root);

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

