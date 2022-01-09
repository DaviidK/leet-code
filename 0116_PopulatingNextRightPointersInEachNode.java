/*
Problem sourced from: leetcode.com
You are given a perfect binary tree where all leaves are on the same level, and every parent has two
children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, the next
pointer should be set to NULL.
Initially, all next pointers are set to NULL.

Example 1:
Input: root = [1,2,3,4,5,6,7]
Output: [1,#,2,3,#,4,5,6,7,#]
Explanation: Given the above perfect binary tree (Figure A), your function should populate each next
pointer to point to its next right node, just like in Figure B. The serialized output is in level 
order as connected by the next pointers, with '#' signifying the end of each level.

Example 2:
Input: root = []
Output: []

Constraints:

  The number of nodes in the tree is in the range [0, 212 - 1].
  -1000 <= Node.val <= 1000

Follow-up:
  You may only use constant extra space.
  The recursive approach is fine. You may assume implicit stack space does not count as extra space 
  for this problem.
*/
import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersInEachNode {
  public static void main(String[] args) {
    // No test cases for this problem, as building the trees and writing a printTree() method would
    // take longer than the problem itself   
  }

  // BFS solution
  // This solution relies on the knowledge that the given tree is a perfect binary tree, and thus
  // each neighboring node will always have the same amount of children. A queue is used to iterate
  // through the tree in BFS fashion, and at each node the next pointers of that node's children will
  // be updated. 
  public static Node connect(Node root) {
    // Do nothing if the tree is empty
    if (root == null) {
      return null;
    }

    // Create a queue that will store the nodes in the tree
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    // Iterate through every node in the tree
    while (!q.isEmpty()) {
      Node current = q.remove();

      // If children exist at the current node, then update their next pointers
      if (current.left != null) {
        // The left child's next pointer will always direct to the right child
        current.left.next = current.right;

        // If the current node is not at the end (right side) of a level, then its right child's next
        // pointer will direct to the current node's neighbor's left child
        if (current.next != null) {
          current.right.next = current.next.left;
        } 
        // If the current node is at the end of a level, then its right child's next pointer will
        // direct be null
        else {
          current.right.next = null;
        }
        // Add both children to the queue
        q.add(current.left);
        q.add(current.right);
      }
    }

    // Return the root of the tree
    return root;
  }

  // Iterative, level-by-level BFS solution
  // This solution is inefficient, only beating out a brute force solution in time and space efficiency.
  // In this solution, the tree will be traversed in a bfs fashion, iterating level-by-level. A queue
  // is used to store each node, and upon visiting a node the solution will update its next pointer.
  // Null values are used to indicate the end of a level in the queue. When a null value is reached,
  // the next level of the queue will be added along with another null value. 
  // Note that adding null values works in Java and some other languages, but can be dangerous and 
  // should be avoided.
  public static Node connectLevelByLevel(Node root) {
    // Do nothing if the tree is empty
    if (root == null) {
      return null;
    }

    // Create a queue that will store the nodes in the tree
    Queue<Node> q = new LinkedList<>();
    // Store the left most node of the current level
    Node leftMost = root;
    // To begin, add the root and a null value to the queue
    q.add(root);
    q.add(null);

    // Iterate through every node in the tree
    while (!q.isEmpty()) {
      Node current = q.remove();

      // If a null value is found, the end of the level has been reached
      if (current == null) {
        // If there are more nodes in the tree
        if (leftMost != null) {
          // Add the next level of the tree
          addNextLevel(q, leftMost);
          // Update the new left most node
          leftMost = q.peek();
        }
        // Ignore the rest of this iteration
        continue;
      }

      // For all nodes in the tree, update their next pointers 
      if (q.peek() != null) {
        current.next = q.peek();
      } else {
        current.next = null;
      }
    }

    // Return the root of the tree
    return root;
  }

  // Helper method which takes the left-most node of one level and adds all nodes for the following
  // level to a queue
  public static void addNextLevel(Queue<Node> q, Node leftNode) {
    // Iterate through all nodes in the current level using the next pointer
    Node current = leftNode;
    while (current != null) {
      // Add the left and right children to the queue
      q.add(current.left);
      q.add(current.right);
      current = current.next;
    }
    // Add a null to the end of the queue to represent the end of the level
    q.add(null);
  }
}
