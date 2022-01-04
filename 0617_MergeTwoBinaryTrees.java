/*
Problem sourced from: leetcode.com
You are given two binary trees root1 and root2.

Imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped
while the others are not. You need to merge the two trees into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of the new tree.

Return the merged tree.
Note: The merging process must start from the root nodes of both trees.

Example 1:
Input: root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
Output: [3,4,5,5,4,null,7]

Example 2:
Input: root1 = [1], root2 = [1,2]
Output: [2,2]

Constraints:

  The number of nodes in both trees is in the range [0, 2000].
  -104 <= Node.val <= 104
*/
import java.util.Stack;

public class MergeTwoBinaryTrees {
  public static void main(String[] args) {
    // No test cases for this problem, as building the trees and writing a printTree() method would
    // take longer than the problem itself
  }

  // Recursive Solution
  // This solution will move through both trees and add the node values together, storing them inside
  // the first tree. After adding the values, the children for each node will be passed into the next
  // recursive call.
  public TreeNode mergeTreesRecursive(TreeNode root1, TreeNode root2) {
    // If the first tree root is null, return the second node
    if (root1 == null)
      return root2;
    // If the second tree root is null, return the first node
    if (root2 == null)
      return root1;
    // Add the values of each node together
    root1.val += root2.val;
    // Set the left child equal to the result of the recursive call for both left children
    root1.left = mergeTreesRecursive(root1.left, root2.left);
    // Set the right child equal to the result of the recursive call for both right children
    root1.right = mergeTreesRecursive(root1.right, root2.right);
    // Return the node of the first tree
    return root1;
  }

  // Iterative solution
  // This solution uses a stack to imitate the functionality of recursive calls found in a recursive
  // solution. An array of two TreeNodes will be stored in the stack, with each node representing 
  // the current location in each tree. At each location, the values of the nodes will be added together
  // and stored in the first tree.
  public static TreeNode mergeTreesIterative(TreeNode root1, TreeNode root2) {
    // No need to perform any summation if either tree is empty
    if (root1 == null) {
      return root2;
    } else if (root2 == null) {
      return root1;
    }
    // Create a stack which will store the currently evaluated node at each tree
    Stack<TreeNode[]> nodeStack = new Stack<>(); 
    // Instantiate the first element in the stack as the roots of both trees
    TreeNode[] roots = {root1, root2};
    nodeStack.push(roots);

    // Iterate until all nodes have been evaluated
    while (!nodeStack.isEmpty()) {
      // Pull the current nodes from each tree
      TreeNode[] temp = nodeStack.pop();

      // If the either node is null, skip this iteration of the loop
      if (temp[0] == null || temp[1] == null) {
        continue;
      }
      
      // Add the value from the second tree into the first
      temp[0].val += temp[1].val;

      // If the first tree has no left child, add the left child of the second tree to the first
      if (temp[0].left == null) {
        temp[0].left = temp[1].left;
      } 
      // Otherwise, add both left children to the stack
      else {
        nodeStack.push(new TreeNode[] {temp[0].left, temp[1].left});
      }

      // Perform the same checks for the right child
      if (temp[0].right == null) {
        temp[0].right = temp[1].right;
      } else {
        nodeStack.push(new TreeNode[] {temp[0].right, temp[1].right});
      }
    }

    // Return the root of the first tree
    return root1;
  }
}
