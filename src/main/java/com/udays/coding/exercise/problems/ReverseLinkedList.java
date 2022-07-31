package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 206
 * Problem statement:
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * Example 2:
 *
 *
 * Input: head = [1,2]
 * Output: [2,1]
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 *
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */

public class ReverseLinkedList {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public ListNode reverseList(ListNode head) {

        //iterative solution

        ListNode prev = null;
        ListNode current = head;
        while(current!=null){
            //hold next node in tmp
            ListNode tmp = current.next;
            //reset current.next by pointing to prev
            //it will be null for head
            current.next = prev;
            //current node becomes previous of next
            prev = current;
            //tmp becomes current for next iteration
            current = tmp;
        }
        return prev;

    }


    /*
    //Recursive solution

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
    */

}
