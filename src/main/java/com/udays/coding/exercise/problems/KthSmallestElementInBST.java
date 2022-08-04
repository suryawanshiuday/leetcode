package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode problem: 230
 * Problem statement:
 * Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,1,4,null,2], k = 1
 * Output: 1
 * Example 2:
 *
 *
 * Input: root = [5,3,6,2,4,null,null,1], k = 3
 * Output: 3
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is n.
 * 1 <= k <= n <= 104
 * 0 <= Node.val <= 104
 *
 *
 * Follow up: If the BST is modified often (i.e., we can do insert and delete operations) and you need to find the kth smallest frequently, how would you optimize?
 */

public class KthSmallestElementInBST {

    //inorder travelsal of BST gives ascending sorted values
    //perform inorder travalsal k times

    //Time complexity: O(logN) for balanced tree vs O(N) for skewed tree
    //Space complexity: O(logN) stack size for balanced tree vs O(N) for skewed tree

    public int kthSmallest(TreeNode root, int k) {

        Stack<TreeNode> stack = new Stack();

        TreeNode current = root;

        while(!stack.isEmpty() || current!=null){
            while(current!=null){
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            if(k==1)
                return current.val;
            current = current.right;
            k-=1;
        }

        return -1;
    }


}
