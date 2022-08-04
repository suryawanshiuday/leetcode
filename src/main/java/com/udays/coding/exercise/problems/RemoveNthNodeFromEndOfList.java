package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 19
 * Problem statement:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 *
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 *
 * Input: head = [1,2], n = 1
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 *
 *
 * Follow up: Could you do this in one pass?
 */

public class RemoveNthNodeFromEndOfList {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode first = dummy;
        ListNode second = dummy;

        // Advances first pointer so that the gap between first and second is n nodes apart
        for(int i=1; i<=n+1; i++){
            first = first.next;
        }

        // Move first to the end, maintaining the gap
        while(first!=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }


}
