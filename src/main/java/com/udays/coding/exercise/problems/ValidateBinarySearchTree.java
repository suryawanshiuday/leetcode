package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 98
 * Problem statement:
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [2,1,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -231 <= Node.val <= 231 - 1
 */

public class ValidateBinarySearchTree {

    //Time complexity: O(N) as we iterate on all nodes worst case
    //Space complexity: O(1) in place comparison

    //inorder traversal
    //at any point, a node value will be higher than prev node
    //if not, return false

    public boolean isValidBST(TreeNode root) {

        Stack<TreeNode> s = new Stack<>();

        TreeNode current = root;
        //maintain the prev value to compare
        Integer prev = null;

        while(!s.isEmpty() || current!=null){
            while(current!=null){
                s.push(current);
                current = current.left;
            }
            current = s.pop();

            if(prev!=null && prev >= current.val)
                return false;
            prev = current.val;
            current = current.right;
        }
        return true;
    }

}
