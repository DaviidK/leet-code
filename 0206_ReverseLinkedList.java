/*
Problem sourced from: leetcode.com
Given the head of a singly linked list, reverse the list, and return the reversed list.

Example 1:
Input: head = [1,2,3,4,5]
Output: [5,4,3,2,1]

Example 2:
Input: head = [1,2]
Output: [2,1]

Example 3:
Input: head = []
Output: []

Constraints:
  The number of nodes in the list is the range [0, 5000].
  -5000 <= Node.val <= 5000

Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

public class ReverseLinkedList {
  public static void main(String[] args) {
    // No test cases were made for this problem
  }

  // Iterative Solution
  // This solution moves through the linked list using two pointers to track the previous and next
  // nodes. At each node, the linkage for the next pointer will be redirected to the previous node.
  // Finally, the last node in the list will be returned.
  public static ListNode reverseListIterative(ListNode head) {
    // Do nothing if the list is empty or if there is only one node
    if (head == null || head.next == null) {
      return head;
    }

    // Create a temp node to track previous node
    ListNode prev = null;
    // Iterate through the entire list
    while (head != null) {
      // Create a temp node to store the next node
      ListNode next = head.next;
      // Update the pointer to direct to the previous node
      head.next = prev;
      // Increment both the previous and current nodes
      prev = head;
      head = next;
    }

    // Return the last node found, which will occur just before the null
    return prev;
  }

  // Recursive Solution
  // This solution will use recursive calls to move through the list, reconnecting each node to the
  // one that came prior as it moves through. Once the end of the list is reached, the final node 
  // will be returned, representing the start of the resulting list
  public static ListNode reverseListRecursive(ListNode head) {
    return reverseListRecursiveHelper(head, null);
  }

  // Helper method
  // This helper method is used to allow for two nodes to be carried between each recursive call. 
  // The current node will have its next pointer redirected to the previous node.
  public static ListNode reverseListRecursiveHelper(ListNode current, ListNode prev) {
    // If the end of the list is reached, return the last node in the list
    if (current == null) {
      return prev;
    }
    // Store the next node in a temp variable
    ListNode next = current.next;
    // Update the next pointer of the current node to redirect to the previous node
    current.next = prev;
    // Make a recursive call moving forward in the list
    return reverseListRecursiveHelper(next, current);
  }
}
