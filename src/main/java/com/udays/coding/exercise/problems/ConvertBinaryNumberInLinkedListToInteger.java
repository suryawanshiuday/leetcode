package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 1290
 * Problem statement:
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 * The most significant bit is at the head of the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */

public class ConvertBinaryNumberInLinkedListToInteger {

    //Time complexity: O(N)
    //Space complexity: O(1)

    public int getDecimalValue(ListNode head) {
        //linked list of not empty
        int num = head.val;
        while(head.next !=null){
            num = num*2 + head.next.val;
            head = head.next;
        }
        return num;
        /*
        1011 = 8 + 0 + 2 + 1 = 11
        num = 1 (most significant bit)
        = 1*2 + 0 = 2
        = (1*2 + 0 )*2 + 1 = 5
        = ((1*2 + 0)*2 + 1)*2 + 1 = 11
        (1*2*2 + 0*2 + 1)*2 +1
        1*2*2*2 + 0*2*2 + 1*2 + 1
        8 + 0 + 2 + 1
        */
    }

}
