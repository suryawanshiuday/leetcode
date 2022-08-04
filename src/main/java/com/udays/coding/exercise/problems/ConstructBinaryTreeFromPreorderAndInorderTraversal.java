package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 105
 * Problem statement:
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * Example 2:
 *
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 *
 *
 * Constraints:
 *
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    //Time complexity: O(N) as we iterate all nodes
    //Space complexity: O(N) for hashmap

    int[] preorder;
    Map<Integer, Integer> inorderMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        this.preorder = preorder;

        //build the map from inorder for O(1) lookup
        inorderMap = new HashMap<>();
        for(int i=0; i<inorder.length; i++){
            inorderMap.put(inorder[i],i);
        }

        //1. start of subtree, 0 for first loop
        //2. end of subtree, n-1 for first loop
        //3. preorder
        //4. map of inorder
        //5. index of root, 0 from preorder for first loop
        return constructNode(0, inorder.length-1, new int[]{0});

    }

    public TreeNode constructNode(int start, int end, int[] indexOfRoot){

        if(start>end)
            return null;

        //root values of subtree are in sequence from start of preorder
        //so get the value and increment for next root
        int rootVal = preorder[indexOfRoot[0]++];
        //get the index of inorder to divide left and right subtree
        int index = inorderMap.get(rootVal);

        //important to construct left first because preorder sequence of roots is, centre first and left roots first and then right roots
        TreeNode left = constructNode(start, index-1, indexOfRoot);
        TreeNode right = constructNode(index+1, end, indexOfRoot);

        TreeNode root = new TreeNode(rootVal, left, right);
        return root;

    }

}
