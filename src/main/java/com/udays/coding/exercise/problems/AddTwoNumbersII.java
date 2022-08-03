package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 445
 * Problem statement:
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: l1 = [7,2,4,3], l2 = [5,6,4]
 * Output: [7,8,0,7]
 * Example 2:
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [8,0,7]
 * Example 3:
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 *
 * Constraints:
 *
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have leading zeros.
 *
 *
 * Follow up: Could you solve it without reversing the input lists?
 */

public class AddTwoNumbersII {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> s1 = new Stack();
        Stack<ListNode> s2 = new Stack();
        while(l1!=null){
            s1.push(l1);
            l1 = l1.next;
        }
        while(l2!=null){
            s2.push(l2);
            l2 = l2.next;
        }
        int carry = 0;
        Stack<ListNode> answer = new Stack();
        while(!s1.isEmpty() || !s2.isEmpty()){
            int x = s1.isEmpty() ? 0 : s1.pop().val;
            int y = s2.isEmpty() ? 0 : s2.pop().val;
            int sum = x+y+carry;
            answer.push(new ListNode(sum%10));
            carry = sum/10;
        }
        if(carry>0)
            answer.push(new ListNode(carry));

        ListNode out = new ListNode(-1);
        ListNode current = out;
        while(!answer.isEmpty()){
            current.next = answer.pop();
            current = current.next;
        }

        return out.next;
    }

}
