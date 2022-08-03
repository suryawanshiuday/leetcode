package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 103
 * Problem statement:
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[20,9],[15,7]]
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
 * -100 <= Node.val <= 100
 */

public class BinaryTreeZigzagLevelOrderTraversal {

    //Time complexity: O()
    //Space complexity: O()

    class Solution {

        //BFS with flipping order for alternate levels

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            //output
            List<List<Integer>> answer = new ArrayList();

            //if root is null, return empty
            if(root==null)
                return answer;

            //queue for BFS iteration
            Queue<TreeNode> queue = new LinkedList();
            queue.add(root);

            //flip this for each iteration
            boolean reverseOrder = false;

            while(!queue.isEmpty()){

                //size of queue for current level
                int size = queue.size();

                //level if going left to right
                List<Integer> level = new ArrayList<>();
                //stack if going right to left
                Stack<Integer> stack = new Stack();

                for(int i=0; i<size; i++){

                    TreeNode node = queue.poll();

                    //if we want reverse order, then add to stack, else add to list
                    if(reverseOrder)
                        stack.push(node.val);
                    else
                        level.add(node.val);

                    if(node.left!=null)
                        queue.add(node.left);
                    if(node.right!=null)
                        queue.add(node.right);
                }

                //if we want reverse order, empty stack into level to get reverse order
                if(reverseOrder){
                    while(!stack.isEmpty())
                        level.add(stack.pop());
                }

                //flip reverse order for next level
                reverseOrder = !reverseOrder;
                answer.add(level);
            }

            return answer;
        }
    }

}
