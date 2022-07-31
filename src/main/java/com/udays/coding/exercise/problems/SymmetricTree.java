package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 101
 * Problem statement:
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,2,3,4,4,3]
 * Output: true
 * Example 2:
 *
 *
 * Input: root = [1,2,2,null,3,null,3]
 * Output: false
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 1000].
 * -100 <= Node.val <= 100
 *
 *
 * Follow up: Could you solve it both recursively and iteratively?
 */

public class SymmetricTree {

    //Time complexity: O(N)
    //Space complexity: O(N)

    //Recursive solution
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2){
        if(t1==null && t2==null)
            return true;
        if(t1==null || t2==null)
            return false;
        return (t1.val==t2.val)
                && isMirror(t1.right, t2.left)
                && isMirror(t1.left, t2.right);
    }

    /*
    //iterative solution

    public boolean isSymmetric(TreeNode root) {

        //2 consecutive nodes should match
        //initially we put root 2 times to match

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            //if both are null, either leaf nodes are TreeNode with only roots, continue
            //return true at the end will be effective
            if(t1==null && t2==null)
                continue;

            //if either are null or if value doesn't match, return false
            if(t1==null || t2==null || t1.val!=t2.val)
                return false;

            //t1->right==t2.left && t1.left==t2.right
            queue.add(t1.right);
            queue.add(t2.left);
            queue.add(t1.left);
            queue.add(t2.right);

        }

        return true;

    }
    */

}
