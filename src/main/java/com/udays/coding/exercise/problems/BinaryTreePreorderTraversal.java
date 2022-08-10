package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 144
 * Problem statement:
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,null,2,3]
 * Output: [1,2,3]
 * Example 2:
 *
 * Input: root = []
 * Output: []
 * Example 3:
 *
 * Input: root = [1]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */

public class BinaryTreePreorderTraversal {

    //Morris traversal
    //Time complexity: O(N) as we visit each node max twice, once to locate the node and other to find predecessor
    //Space complexity: O(1)

    public List<Integer> preorderTraversal(TreeNode root) {
        //output array not considered towards space complexity
        List<Integer> res = new ArrayList<>();

        TreeNode curr = root;
        TreeNode pre;

        while (curr != null) {
            //preorder visits root first and hence first read the value
            //current.left is null, and we have already visited root, assign current.right to be visited
            //this makes it preorder traversal
            res.add(curr.val);
            if (curr.left == null) {
                curr = curr.right; // assign current to right node
            }
            //if current.left is not null, we need to store the nodes somehow to traverse back to root
            //1. from current.left, traverse to rightmost node (predecessor)
            //2. make rightmost.right = current.right (no need to visit current as that is root already visited)
            //3. make current = current.left (as we stored the pointer to current as rightmost.right, we don't lose the right node of this left)
            //4. (optimization) original cur left be null, avoid infinite loops
            else {
                //1. from current.left, traverse to rightmost node
                pre = curr.left;
                while (pre.right != null) { // find rightmost
                    pre = pre.right;
                }
                //2. make rightmost.right = current
                pre.right = curr.right;
                //3. make current = current.left
                //4. (optimization) original cur left be null, avoid infinite loops
                TreeNode temp = curr; // store cur node
                curr = curr.left; // move cur to the top of the new tree
                temp.left = null;
            }
        }
        return res;
    }
}
