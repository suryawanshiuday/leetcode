package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 100
 * Problem statement:
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: p = [1,2,3], q = [1,2,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: p = [1,2], q = [1,null,2]
 * Output: false
 * Example 3:
 *
 *
 * Input: p = [1,2,1], q = [1,1,2]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in both trees is in the range [0, 100].
 * -104 <= Node.val <= 104
 */

public class SameTree {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return match(p,q);
    }

    public boolean match(TreeNode p, TreeNode q){
        if(p==null && q==null)
            return true;
        if(p==null || q==null)
            return false;
        return p.val==q.val && match(p.left,q.left) && match(p.right, q.right);
    }

}
