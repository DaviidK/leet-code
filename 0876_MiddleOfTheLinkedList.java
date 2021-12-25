/*
Problem sourced from: leetcode.com
Given the head of a singly linked list, return the middle node of the linked list.
If there are two middle nodes, return the second middle node.

Example 1:
Input: head = [1,2,3,4,5]
Output: [3,4,5]
Explanation: The middle node of the list is node 3.

Example 2:
Input: head = [1,2,3,4,5,6]
Output: [4,5,6]
Explanation: Since the list has two middle nodes with vals 3 and 4, we return the second one.

Constraints:
  The number of nodes in the list is in the range [1, 100].
  1 <= Node.val <= 100

Definition for singly-linked list.
  public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
*/
public class MiddleOfTheLinkedList {
  public static void main(String[] args) {
    // Create first linkedlist with values: [1,2,3,4,5]
    ListNode front1 = new ListNode(1);
    ListNode current1 = front1;
    for (int i = 2; i <= 5; i++) {
      current1.next = new ListNode(i);
      current1 = current1.next;
    }
    current1.next = null;

    // Create second linkedlist with values: [1,2,3,4,5,6]
    ListNode front2 = new ListNode(1);
    ListNode current2 = front2;
    for (int i = 2; i <= 6; i++) {
      current2.next = new ListNode(i);
      current2 = current2.next;
    }
    current2.next = null;

    // Run middleNode() and store results
    ListNode result1 = middleNode(front1);
    ListNode result2 = middleNode(front2);

    // Print input/expected result/output for both test cases
    System.out.println("Input: " + front1.printList());
    System.out.println("Expected Result: [3,4,5]");
    System.out.println("Output Produced: " + result1.printList());
    System.out.println();

    System.out.println("Input: " + front2.printList());
    System.out.println("Expected Result: [4,5,6]");
    System.out.println("Output Produced: " + result2.printList());
    System.out.println();
  }

  // Two-loop solution
  // This solution iterates through the list twice. On the first iteration, the size of the list 
  // will be calculated. The second iteration will go halfway through the node to find the middle.
  public static ListNode middleNode(ListNode head) {
    int size = 0;

    // Iterate through the entire list to find the size
    ListNode current = head;
    while (current != null) {
      current = current.next;
      size++;
    }

    // Iterate halfway through the list to find the middle node
    current = head;
    for (int i = 0; i < size / 2; i++) {
      current = current.next;
    }
    return current;
  }


  // Two pointer solution
  // This solution uses two pointers to track a fast and slow node. Using a single loop, the fast node
  // will iterate twice as often as the slow node. When the fast node has reached the end of the list, 
  // the slow node will be in the middle.
  public ListNode middleNodeOptimized(ListNode head) {
    ListNode slow = head, fast = head;
    // Iterate until the fast node has reached the end. Be sure to check for fast.next as well to 
    // avoid null pointer exceptions
    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }
    return slow;
  }

  // Inner ListNode class which can store integer values and next/previous pointers
  public static class ListNode{
    public int val;
    public ListNode next;
    public ListNode prev;

    // Default constructor: Creates a node with value -1 and two null pointers
    public ListNode() {
      this.val = -1;
      this.next = null;
      this.prev = null;
    }

    // Single-parameter value constructor: Creates a node with parameter value and two null pointers
    public ListNode(int v) {
        this.val = v;
        this.next = null;
        this.prev = null;
    }

    // Two-parameter constructor: Creates a node with parameter value, parameter next pointer, and
    // null previous pointer
    public ListNode(int v, ListNode n) {
      this.val = v;
      this.next = n;
      this.prev = null;
    }

    // Three-parameter constructor: Creates a node with parameter value and parameter pointers
    public ListNode(int v, ListNode n, ListNode p) {
        this.val = v;
        this.next = n;
        this.prev = p;
    }

    // printList()
    // Will print the list created starting from the object node. Formatted with brackets on each 
    // end and commas separating each element.
    public String printList() {
      StringBuilder result = new StringBuilder("[");
      ListNode current = this; 
      
      while (current.next != null) {
        result.append(current.val);
        result.append(",");
        current = current.next;
      }
      result.append(current.val + "]");
      
      return result.toString();
    }
  }
}