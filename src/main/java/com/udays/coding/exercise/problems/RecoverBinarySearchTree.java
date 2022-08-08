package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode problem: 99
 * Problem statement:
 * You are given the root of a binary search tree (BST), where the values of exactly two nodes of the tree were swapped by mistake. Recover the tree without changing its structure.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: root = [1,3,null,null,2]
 * Output: [3,1,null,null,2]
 * Explanation: 3 cannot be a left child of 1 because 3 > 1. Swapping 1 and 3 makes the BST valid.
 * Example 2:
 *
 *
 * Input: root = [3,1,4,null,null,2]
 * Output: [2,1,4,null,null,3]
 * Explanation: 2 cannot be in the right subtree of 3 because 2 < 3. Swapping 2 and 3 makes the BST valid.
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [2, 1000].
 * -231 <= Node.val <= 231 - 1
 *
 *
 * Follow up: A solution using O(n) space is pretty straight-forward. Could you devise a constant O(1) space solution?
 */

public class RecoverBinarySearchTree {

    //Time complexity: O(N)
    //Space complexity: O(N)

    public void recoverTree(TreeNode root) {

        //Step1: inorder traversal to get sorted list (with 2 anomalies)
        List<Integer> nums = new ArrayList();
        inorder(root, nums);
        //Step2: find the anomalies
        int[] swapped = findTwoSwapped(nums);
        //Step3: reverse the anomaly
        reverse(root, swapped[0], swapped[1]);
    }

    private void inorder(TreeNode node, List<Integer> nums){
        if(node==null)
            return;
        inorder(node.left, nums);
        nums.add(node.val);
        inorder(node.right, nums);
    }

    private void reverse(TreeNode node, int swap, int swapWith){
        if(node==null)
            return;
        reverse(node.left, swap, swapWith);
        //swap first anomaly
        if(node.val==swap)
            node.val=swapWith;
            //swap second anomaly
        else if(node.val==swapWith)
            node.val=swap;
        reverse(node.right, swap, swapWith);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        int x = -1, y = -1;
        boolean foundFirst = false;
        for(int i=1; i<nums.size(); i++){
            if(nums.get(i)<nums.get(i-1)){
                //keep updating y as it doesn't hurt
                //actually expected value of y will be set after finding second anomaly and breaking the loop
                y=nums.get(i);
                if(!foundFirst){
                    x=nums.get(i-1);
                    foundFirst=true;
                } else{
                    //loop comes here only after identifying second anomaly
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

}
