package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 108
 * Problem statement:
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 *
 * A height-balanced binary tree is a binary tree in which the depth of the two subtrees of every node never differs by more than one.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-10,-3,0,5,9]
 * Output: [0,-3,9,-10,null,5]
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 *
 * Example 2:
 *
 *
 * Input: nums = [1,3]
 * Output: [3,1]
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums is sorted in a strictly increasing order.
 */

public class ConvertSortedArrayToBinarySearchTree {

    //Time complexity: O(N)
    //Space complexity: O(logN)

    //center element is always the root in sorted array
    //left side numbers go in left tree, right side numbers go in right tree
    //do this recursively

    public TreeNode sortedArrayToBST(int[] nums) {
        return createNode(nums,0,nums.length-1);
    }

    public TreeNode createNode(int[] nums, int left, int right){
        if(left>right)
            return null;

        int middle = (left+right)/2;

        TreeNode middleNode = new TreeNode(nums[middle]);
        middleNode.left = createNode(nums, left, middle-1);
        middleNode.right = createNode(nums, middle+1, right);
        return middleNode;
    }

}
