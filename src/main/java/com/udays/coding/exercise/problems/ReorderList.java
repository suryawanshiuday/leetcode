package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 143
 * Problem statement:
 * You are given the head of a singly linked-list. The list can be represented as:
 *
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 *
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 *
 *
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 *
 *
 * Constraints:
 *
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 */

public class ReorderList {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack();
        ListNode current = head;
        while(current!=null){
            stack.push(current);
            current = current.next;
        }
        current = head;
        while(current!=null){
            //store next node of current node
            ListNode next = current.next;
            //get end node from stack
            ListNode end = stack.pop();
            //set next of current to node from stack
            current.next = end;
            //set next of end node to next node stored in step 1
            end.next = next;
            //assign current to next for iteration
            current = next;
            //if current itself is null or we have already reach middle, terminate
            if(current!=null && current.next == end){
                current.next = null;
                break;
            }
        }
    }

}
