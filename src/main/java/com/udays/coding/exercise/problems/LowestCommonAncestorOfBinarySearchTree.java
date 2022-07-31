package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 235
 * Problem statement:
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 *
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6.
 * Example 2:
 *
 *
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * Example 3:
 *
 * Input: root = [2,1], p = 2, q = 1
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 105].
 * -109 <= Node.val <= 109
 * All Node.val are unique.
 * p != q
 * p and q will exist in the BST.
 */

public class LowestCommonAncestorOfBinarySearchTree {

    //Time complexity: O(logN)
    //Space complexity: O(1)

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        //as p and q are guaranteed to be present
        //we need to find the node where p<node<q

        TreeNode current = root;
        while(current!=null){
            //if both p and q values are greater than node, go to right subtree
            if(p.val>current.val && q.val>current.val)
                current = current.right;
                //if both p and q are smaller than node, go to left subtree
            else if(p.val<current.val && q.val<current.val)
                current = current.left;
                //if one is smaller and other is larger, we have found the LCA
            else
                return current;
        }
        return null;
    }

}
