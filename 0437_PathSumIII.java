/*
Problem sourced from: leetcode.com

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the node or a leaf, but it must go 
downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000
to 1,000,000.

Example:
node = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

  10
   /  \
  5   -3
   / \  \
  3   2   11
 / \   \
3  -2   1

Return 3. The paths that sum to 8 are:
1.  5 -> 3
2.  5 -> 2 -> 1
3. -3 -> 11
*/

/* 
Java doesn't allow underscores in file names, so it's necessary to rename the 
file before compiling. I chose to keep the underscore for easy organization
within my git repo, given that these files are often never compiled after being 
committed
*/
public class PathSumIII {
  public int pathSum(TreeNode node, int sum) {
    int count = 0;
    // If tree is empty, return 0
    if (node == null) {
      return 0;
    }

    // Add all possiblities starting at the current node
    count += pathSumHelper(node, sum, 0);
    // Add all possiblities starting at the left child
    count += pathSum(node.left, sum);
    // Add all possibilities starting at the right child
    count += pathSum(node.right, sum);

    return count;
  }
  
  // This helper method is responsible for finding how many possibile paths to a
  // target value can be made starting at a given node
  public int pathSumHelper(TreeNode node, int sum, int currentSum) {
    // If the node is empty, return 0
    if (node == null) {
      return 0;
    }
    
    int count = 0;
    // Add the current value into the sum
    currentSum += node.val;

    // If the target value has been reached, add one to the count
    if (currentSum == sum) {
      count++;
    }
    
    // Add all the possible paths from the left branch
    count += pathSumHelper(node.left, sum, currentSum);
    // Add all the possibile paths from the right branch
    count += pathSumHelper(node.right, sum, currentSum);
    
    return count;
  } 
}