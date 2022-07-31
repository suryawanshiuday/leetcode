package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 543
 * Problem statement:
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * Example 2:
 *
 * Input: root = [1,2]
 * Output: 1
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -100 <= Node.val <= 100
 */

public class DiameterOfBinaryTree {

    //Time complexity: O(N)
    //Space complexity: O(N) for call stack for skewed tree O(logN) for balanced tree

    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestPath(root);
        return diameter;
    }

    public int longestPath(TreeNode current){
        //base case where it reaches leaf nodes
        if(current==null)
            return 0;

        int left = longestPath(current.left);
        int right = longestPath(current.right);

        diameter = Math.max(diameter, left+right);

        return Math.max(left, right)+1;
    }

}
