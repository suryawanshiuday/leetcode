package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 21
 * Problem statement:
 * 21. Merge Two Sorted Lists
 * Easy
 *
 * 13717
 *
 * 1241
 *
 * Add to List
 *
 * Share
 * You are given the heads of two sorted linked lists list1 and list2.
 *
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 *
 * Return the head of the merged linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Example 2:
 *
 * Input: list1 = [], list2 = []
 * Output: []
 * Example 3:
 *
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 */

public class MergeTwoSortedLists {

    //Time complexity: O(M+N)
    //Space complexity: O(1) auxiliary space

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //null check
        if(list1==null) return list2;
        if(list2==null) return list1;

        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        //iterate till both are not null
        //if one of them becomes null, remaining from other can be joined at tail
        while(list1!=null && list2!=null){
            if(list1.val<=list2.val){
                current.next = list1;
                list1 = list1.next;
            } else{
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        //remaining from other can be joined at tail
        current.next = (list1==null)? list2: list1;

        return dummy.next;
    }

}
