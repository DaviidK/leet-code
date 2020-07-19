/*
Problem sourced from: leetcode.com

NO TESTING IN THIS FILE (Didn't create a TreeNode class)

Given a binary tree, write a function to get the maximum width of the given tree.
The width of a tree is the maximum width among all levels. The binary tree has 
the same structure as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes 
(the leftmost and right most non-null nodes in the level, where the null nodes 
between the end-nodes are also counted into the length calculation.)

Example 1:
Input: 

           1
         /   \
        3     2
       / \     \  
      5   3     9 

Output: 4
Explanation: The maximum width existing in the third level with the length 4 
(5,3,null,9).

Example 2:
Input: 

          1
         /  
        3     
       / \       
      5   3     

Output: 2
Explanation: The maximum width existing in the third level with the length 2 
(5,3).

Example 3:
Input: 

          1
         / \
        3   2 
       /        
      5      

Output: 2
Explanation: The maximum width existing in the second level with the length 2 
(3,2).

Example 4:
Input: 

          1
         / \
        3   2
       /     \  
      5       9 
     /         \
    6           7
Output: 8
Explanation:The maximum width existing in the fourth level with the length 8 
(6,null,null,null,null,null,null,7).


Note: Answer will in the range of 32-bit signed integer.
*/

public class MaxWidthBinTree {
    public int widthOfBinaryTree(TreeNode root) {
        // Return 0 if the tree is empty
        if (root == null) {
            return 0;
        }

        // Create result variable and map which stores Treenodes and their
        // "indices" within the tree
        int result = Integer.MIN_VALUE;
        Map<TreeNode, Integer> currentLevel = new LinkedHashMap();
        // Create a second map which will store the nodes that are contained in
        // the level below the current one
        Map<TreeNode, Integer> nextLevel = new LinkedHashMap();
        // Add root to map
        currentLevel.put(root, 1);
        // Create left and right pointer
        int left = 0;
        int right = 0;

        // Continue until every node has been examined
        while (!currentLevel.isEmpty()) {
            // Save size before entering loop to ensure loop range isn't modified
            int size = currentLevel.size();
            // Iterate through the current level in the queue
            for (TreeNode node : currentLevel.keySet()) {
                // Pull the index from the current level's map
                int index = currentLevel.get(node);
                // If the index is 0, update the left pointer
                if (index == 0) {
                    left = index;
                }
                // If the index is the last in the current level, update the 
                // right pointer
                if (index == size - 1) {
                    right = index;
                }

                // Add any left children to the next level's map
                if (node != null && node.left != null)
                    nextLevel.put(node.left, 2 * index);
                // Add any right children to the next level's map
                if (node != null && node.right != null) {
                    nextLevel.put(node.right, (2 * index) + 1);
                }
            }
            // Update the map to store the next level
            currentLevel = nextLevel;
            // Clear the nextLevel
            nextLevel.clear();

            // Update the result by taking the maximum value of the current 
            // answer and the difference between left and right pointers
            result = Math.max(result, right - left + 1);
        }

        return result;
    }
}
