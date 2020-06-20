/*
Problem sourced from: leetcode.com

You are given two non-empty linked lists representing two non-negative integers.
The digits are stored in reverse order and each of their nodes contain a single
digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the
number 0 itself.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/

import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class AddTwoNumbers {
    public static void main(String[] args) {
    }

    public static ListNode addTwoNumbers(ListNode front1, ListNode front2) {
        // Create new List head
        ListNode front3 = new ListNode();
        // CCreate current nodes for each list
        ListNode cur1 = front1;
        ListNode cur2 = front2;
        ListNode cur3 = front3;
        // Instantiate a carry variable to start at 0
        int carry = 0;

        // Iterate until reaching the end of both lists
        while (cur1 != null || cur2 != null) {
            // Pull the value for each node, set it to 0 if the node is null
            int val1 = cur1 != null ? cur1.val : 0;
            int val2 = cur2 != null ? cur2.val : 0;

            // Calculate sum using both values and carry
            int sum = val1 + val2 + carry;
            // Update the carry variable
            carry = sum / 10;

            // Add summed value into new list
            cur3.val = sum % 10;
            cur3.next = new ListNode();
            
            // Move all current nodes
            cur1 = cur1.next;
            cur2 = cur2.next;
            cur3 = cur3.next;
        }

        // If any value is left over from final summation, add it to the end of 
        // the list
        if (carry != 0) {
            cur3.val = carry;
        } else {
            cur3 = null;
        }

        return front3;
    }



}