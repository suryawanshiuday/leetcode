package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 113
 * Problem statement:
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * Output: [[5,4,11,2],[5,8,4,5]]
 * Explanation: There are two paths whose sum equals targetSum:
 * 5 + 4 + 11 + 2 = 22
 * 5 + 8 + 4 + 5 = 22
 * Example 2:
 *
 *
 * Input: root = [1,2,3], targetSum = 5
 * Output: []
 * Example 3:
 *
 * Input: root = [1,2], targetSum = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 5000].
 * -1000 <= Node.val <= 1000
 * -1000 <= targetSum <= 1000
 */

public class PathSumII {

    //Time complexity: O(N)
    //Space complexity: O(logN) for balanced tree, O(N) for skewed tree, recursion stack

    //recursive solution

    List<List<Integer>> paths;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        paths = new ArrayList<>();

        findPath(root, targetSum, new ArrayList<Integer>());

        return paths;
    }

    public void findPath(TreeNode root, int sum, List<Integer> current){

        if(root==null){
            return;
        }

        current.add(root.val);

        //check if we have reached leaf node and if we reached target value, if yes, thats one path answer
        if(root.right==null && root.left==null && sum-root.val==0){
            paths.add(current);
            return;
        }

        //check in left node
        findPath(root.left, sum-root.val, new ArrayList<Integer>(current));
        //check in right node
        findPath(root.right, sum-root.val, new ArrayList<Integer>(current));

    }
}
