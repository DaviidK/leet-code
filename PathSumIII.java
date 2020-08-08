/*
Problem sourced from: leetcode.com

You are given a binary tree in which each node contains an integer value.

Find the number of paths that sum to a given value.

The path does not need to start or end at the root or a leaf, but it must go 
downwards (traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000
to 1,000,000.

Example:
root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8

      10
     /  \
    5   -3
   / \    \
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

    public static int pathSum(IntTreeNode root, int sum) {
        // Call helper method, starting at the root with 0 paths found
        return pathSumHelper(root, 0, sum, 0);
    }
    
    public static int pathSumHelper(IntTreeNode node, int sum, int target, int pathCount) {
        // Add the value at the current node to the running total
        sum += node.value;
        // If the new total equals the target, add one to the number of paths found
        if (sum == target) {
            pathCount += 1;
        }
        // If there is a left child, check for valid paths in that direction
        if (node.left != null) {
            pathCount += pathSumHelper(node.left, sum, target, pathCount);
        }
        // If there is a right child, check for valid paths in that direction
        if (node.right != null) {
            pathCount += pathSumHelper(node.right, sum, target, pathCount);
        }
        // Return the number of paths found
        return pathCount;
    }
}