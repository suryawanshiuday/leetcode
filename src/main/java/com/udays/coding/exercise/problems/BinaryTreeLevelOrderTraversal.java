package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 102
 * Problem statement:
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * Example 2:
 *
 * Input: root = [1]
 * Output: [[1]]
 * Example 3:
 *
 * Input: root = []
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
 */

public class BinaryTreeLevelOrderTraversal {

    //Time complexity: O(N)
    //Space complexity: O(N)

    //Iterative Solution

    public List<List<Integer>> levelOrder(TreeNode root) {

        //answer
        List<List<Integer>> returnList = new ArrayList();

        //null check
        if(root==null){
            return returnList;
        }

        //Queue to hold nodes to traverse
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        //starting with root
        queue.add(root);

        //idea is to keep adding nodes to queue in order root->left->right
        while(!queue.isEmpty()){
            //as queue will be continuously build, only visit elements for current level
            //current level = queue size before we add new nodes from next level in queue
            int size = queue.size();

            //inner list to hold nodes for current level
            List<Integer> inner = new ArrayList();
            //iterate size times and read current level
            for(int i=0; i<size; i++){
                //visit first node from queue
                //will be in order root->left->right
                TreeNode head = queue.poll();
                inner.add(head.val);
                //add left of current node to end of queue
                if(head.left!=null){
                    queue.add(head.left);
                }
                //add right of current node to end of queue
                if(head.right!=null){
                    queue.add(head.right);
                }
            }
            //add current level in output
            returnList.add(inner);
        }
        return returnList;
    }

}
