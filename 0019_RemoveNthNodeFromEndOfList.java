/*
Problem sourced from: leetcode.com
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:
  The number of nodes in the list is sz.
  1 <= sz <= 30
  0 <= Node.val <= 100
  1 <= n <= sz
*/
public class RemoveNthNodeFromEndOfList {
  public static void main(String[] args) {
    // Create first linkedlist with values: [1,2,3,4,5]
    ListNode front1 = new ListNode(1);
    ListNode current1 = front1;
    for (int i = 2; i <= 5; i++) {
      current1.next = new ListNode(i);
      current1 = current1.next;
    }
    current1.next = null;

    // Create second linkedlist with values: [1,2]
    ListNode front2 = new ListNode(1);
    ListNode current2 = front2;
    for (int i = 2; i <= 2; i++) {
      current2.next = new ListNode(i);
      current2 = current2.next;
    }
    current2.next = null;

    // Create third linkedlist with value: [1]
    ListNode front3 = new ListNode(1);

    // Print input/expected result/output for both test cases
    System.out.println("Input: " + front1.printList());
    System.out.println("Expected Result: [1,2,3,5]");
    ListNode result1 = removeNthFromEnd(front1, 2);
    System.out.println("Output Produced: " + result1.printList());
    System.out.println();

    System.out.println("Input: " + front2.printList());
    System.out.println("Expected Result: [1]");
    ListNode result2 = removeNthFromEnd(front2, 1);
    System.out.println("Output Produced: " + result2.printList());
    System.out.println();

    System.out.println("Input: " + front3.printList());
    System.out.println("Expected Result: []");
    ListNode result3 = removeNthFromEnd(front3, 1);
    // Handle a null return to ensure output is still printed
    if (result3 == null) {
      System.out.println("Output Produced: [] - null result");
    }
    else {
      System.out.println("Output Produced: " + result3.printList());
    }
    System.out.println();
  }

  // Two pointer solution
  // This solution uses two pointers to track fast and slow nodes while iterating through the list.
  // The fast pointer will be accelerated by n nodes, allowing the slow pointer to end before the nth
  // node from the back of the list.
  public static ListNode removeNthFromEnd(ListNode head, int n) {
    // Create a new node in order to handle edge cases where the first node is intended to be deleted
    ListNode start = new ListNode(0);
    // Create two pointers for fast and slow nodes, then set them both to the head node
    ListNode slow = start, fast = start;
    slow.next = head;
    
    // Accelerate the fast node by n iterations
    for(int i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // Iterate both nodes until the fast node reaches the end
    while(fast != null) {
        slow = slow.next;
        fast = fast.next;
    }

    // Remove the nth node from the back of the list
    slow.next = slow.next.next;

    // Return the front of the new list
    return start.next;
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
