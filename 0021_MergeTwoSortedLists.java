/*
Problem sourced from: leetcode.com
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of 
the first two lists.

Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]

Constraints:
  The number of nodes in both lists is in the range [0, 50].
  -100 <= Node.val <= 100
  Both list1 and list2 are sorted in non-decreasing order.
*/

public class MergeTwoSortedLists {
  public static void main(String[] args) {
    // No test cases were made for this problem
  }

  // Iterative solution
  // This solution moves through both lists simultaneously, adding nodes to a resulting list based on
  // which value is lower in each starting list. A new node is created to track that resulting list,
  // and it will be used to return the result at the end of the solution.
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    // If either list is null, return the other
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }

    // Create a node which will have a next pointer towards the result
    ListNode preHead = new ListNode(0);
    ListNode current = preHead;

    // Iterate until the end of one of the lists
    while (list1 != null && list2 != null) {
      // If the second list has a lower value than the first, append its node to the result 
      // node 
      if (list1.val > list2.val) {
        current.next = list2;
        list2 = list2.next;
      }
      // If the first list has a lower value than the second, append its node to the result
      else {
        current.next = list1;
        list1 = list1.next;
      }

      // Increment the resulting list
      current = current.next;
    }

    // Find which list ended first and append the rest of the other list to the result
    if (list1 == null) {
      current.next = list2;
    } else {
      current.next = list1;
    }

    // Return the result
    return preHead.next;
  }

  // Recursive backtracking solution
  // This solution will make recursive calls to find the lower value at each possible node combination,
  // then return the correct node in a backtracking fashion. The returned nodes will be used to create
  // the resulting chain of nodes in sorted order.
  public static ListNode mergeTwoListsBacktracking(ListNode list1, ListNode list2) {
    // If either parameter node is null, return the other option
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    }

    // If the first list had a lower value, append the recursive call to the first list node and 
    // return the first list
    if (list1.val < list2.val) {
      list1.next = mergeTwoListsBacktracking(list1.next, list2);
      return list1;
    }
    // If the second list had a lower value, append the recursive call to the second list node and 
    // return the second list
    else {
      list2.next = mergeTwoListsBacktracking(list1, list2.next);
      return list2;
    }
  }
}