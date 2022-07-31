package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.*;

/**
 * Leetcode problem: 1161
 * Problem statement:
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 *
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,7,0,7,-8,null,null]
 * Output: 2
 * Explanation:
 * Level 1 sum = 1.
 * Level 2 sum = 7 + 0 = 7.
 * Level 3 sum = 7 + -8 = -1.
 * So we return the level with the maximum sum which is level 2.
 * Example 2:
 *
 * Input: root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * Output: 2
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 104].
 * -105 <= Node.val <= 105
 */

public class MaximumLevelSumOfBinaryTree {

    //Time complexity: O(N) visit all nodes
    //Space complexity: O(logN) queue size for balances tree, O(N) for skewed tree

    class Solution {
        public int maxLevelSum(TreeNode root) {

            //to store visited sums
            //level2 has sum 10 and level5 has sum 10, we want to return 2
            HashSet<Long> visitedSums = new HashSet();

            //store max level sum seen
            long max = Long.MIN_VALUE;
            //store level with max level seen
            int level = Integer.MIN_VALUE;

            //level order traversal with queue
            Queue<TreeNode> q = new LinkedList();
            q.offer(root);

            int index = 0;
            while(!q.isEmpty()){
                int size = q.size();
                long sum = 0L;
                index++;
                for(int i=0; i<size; i++){
                    TreeNode current = q.poll();
                    sum += current.val;
                    if(current.left!=null)
                        q.offer(current.left);
                    if(current.right!=null)
                        q.offer(current.right);
                }
                //update max sum
                max = Math.max(max, sum);
                //if current level sum is max, update level if max not seen before
                if(sum==max && !visitedSums.contains(sum)){
                    level = Math.max(level, index);
                }
                //mark sum for level as seen
                visitedSums.add(sum);
            }
            return level;
        }
    }

}
