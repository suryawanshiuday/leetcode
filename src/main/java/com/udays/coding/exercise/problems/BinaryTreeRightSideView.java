package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 199
 * Problem statement:
 * Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * Example 2:
 *
 * Input: root = [1,null,3]
 * Output: [1,3]
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

public class BinaryTreeRightSideView {

    //Time complexity: O(N) as we will iterate all nodes
    //Space complexity: O(N) queue size, for skewed binary tree O(logN) for balanced

    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> answer = new ArrayList();

        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                //this condition for [] input
                if(node!=null){
                    if(i==size-1)
                        answer.add(node.val);
                    if(node.left!=null)
                        q.offer(node.left);
                    if(node.right!=null)
                        q.offer(node.right);
                }
            }
        }

        return answer;
    }

}
