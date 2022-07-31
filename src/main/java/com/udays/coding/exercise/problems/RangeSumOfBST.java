package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 938
 * Problem statement:
 * Given the root node of a binary search tree and two integers low and high, return the sum of values of all nodes with a value in the inclusive range [low, high].
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [10,5,15,3,7,null,18], low = 7, high = 15
 * Output: 32
 * Explanation: Nodes 7, 10, and 15 are in the range [7, 15]. 7 + 10 + 15 = 32.
 * Example 2:
 *
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * Output: 23
 * Explanation: Nodes 6, 7, and 10 are in the range [6, 10]. 6 + 7 + 10 = 23.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [1, 2 * 104].
 * 1 <= Node.val <= 105
 * 1 <= low <= high <= 105
 * All Node.val are unique.
 */

public class RangeSumOfBST {

    //Time complexity: O(logN)
    //Space complexity: O(1)

    public int rangeSumBST(TreeNode root, int low, int high) {

        int[] ans = new int[]{0};
        binarySearch(ans, root, low, high);
        return ans[0];

    }

    private void binarySearch(int[] ans, TreeNode node, int low, int high){
        //if we reach leaf, return
        if(node==null)
            return;
        //if value is in range, sum
        if(low<=node.val && node.val<=high)
            ans[0]+=node.val;
        //if value>low, go left to sum smaller values in range
        if(node.val>low)
            binarySearch(ans, node.left, low, high);
        //if value<high, go right to sum larger values in range
        if(node.val<high)
            binarySearch(ans, node.right, low, high);
    }

}
