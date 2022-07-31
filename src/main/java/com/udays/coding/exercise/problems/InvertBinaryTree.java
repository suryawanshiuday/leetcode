package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 226
 * Problem statement:
 * Given the root of a binary tree, invert the tree, and return its root.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [4,2,7,1,3,6,9]
 * Output: [4,7,2,9,6,3,1]
 * Example 2:
 *
 *
 * Input: root = [2,1,3]
 * Output: [2,3,1]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class InvertBinaryTree {

    //Time complexity: O(N)
    //Space complexity: O(H) for recursion stack, where h is height of tree

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //we flip everything from right first and then left
        TreeNode right = invertTree(root.right);
        TreeNode left = invertTree(root.left);
        root.left = right;
        root.right = left;
        return root;
    }

}
