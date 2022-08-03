package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.ListNode;
import com.udays.coding.exercise.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 109
 * Problem statement:
 * Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced BST.
 * Example 2:
 *
 * Input: head = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in head is in the range [0, 2 * 104].
 * -105 <= Node.val <= 105
 */

public class ConvertSortedListToBinarySearchTree {

    //Time complexity: O(NlogN) for every node in N, we do binary split logN to create further nodes
    //Space complexity: O(logN) recursion stack for skewed tree, but height balanced tree it is logN

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> input = new ArrayList();
        while(head!=null){
            input.add(head.val);
            head = head.next;
        }
        return createNode(input, 0, input.size()-1);
    }

    public TreeNode createNode(List<Integer> nums, int left, int right){
        if(left>right)
            return null;

        int middle = (left+right)/2;

        TreeNode middleNode = new TreeNode(nums.get(middle));
        middleNode.left = createNode(nums, left, middle-1);
        middleNode.right = createNode(nums, middle+1, right);
        return middleNode;
    }

}
