package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 110
 * Problem statement:
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,3,3,null,null,4,4]
 * Output: false
 * Example 3:
 *
 * Input: root = []
 * Output: true
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -104 <= Node.val <= 104
 */

public class BalancedBinaryTree {

    //Time complexity: O(NlogN) as each element will be evaluated and height of balanced tree is logN
    //Space complexity: O(N) recursion stack

    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        //height difference between right and left subtree should be 1
        //this should be true recursively
        return Math.abs(height(root.left)-height(root.right))<2
                && isBalanced(root.left)
                && isBalanced(root.right);
    }

    public int height(TreeNode node){
        if(node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

}
