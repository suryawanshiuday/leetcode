package com.udays.coding.exercise.problems;

import com.udays.coding.exercise.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode problem: 450
 * Problem statement:
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST. Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 *
 * Search for a node to remove.
 * If the node is found, delete the node.
 *
 *
 * Example 1:
 *
 *
 * Input: root = [5,3,6,2,4,null,7], key = 3
 * Output: [5,4,6,2,null,null,7]
 * Explanation: Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the above BST.
 * Please notice that another valid answer is [5,2,6,null,4,null,7] and it's also accepted.
 *
 * Example 2:
 *
 * Input: root = [5,3,6,2,4,null,7], key = 0
 * Output: [5,3,6,2,4,null,7]
 * Explanation: The tree does not contain a node with value = 0.
 * Example 3:
 *
 * Input: root = [], key = 0
 * Output: []
 *
 *
 * Constraints:
 *
 * The number of nodes in the tree is in the range [0, 104].
 * -105 <= Node.val <= 105
 * Each node has a unique value.
 * root is a valid binary search tree.
 * -105 <= key <= 105
 *
 *
 * Follow up: Could you solve it with time complexity O(height of tree)?
 */

public class DeleteNodeInBST {

    //Time complexity: O(logN) for balanced tree,
    //Space complexity: O(H) for recursion stack = O(logN) for balanced tree

    public TreeNode deleteNode(TreeNode root, int key) {

        if(root==null)
            return null;

        //if key is greater than node value, go to right subtree
        if(key> root.val)
            root.right = deleteNode(root.right, key);
            //if key is lesser than node value, go to left subtree
        else if (key<root.val)
            root.left = deleteNode(root.left, key);
            //if we found the node, delete it
        else if (key==root.val){
            //case 1: node is leaf node, just delete it
            if(root.left==null && root.right==null)
                root=null;
                //case 2: node has right children
                //find the successor in recursion and reorder right tree
            else if(root.right!=null){
                //get value from successor to set for the node in order to delete it
                root.val = successor(root);
                //recurse for successors in sequence to set right tree
                root.right = deleteNode(root.right, root.val);
            }
            //case 3: node has no right child but left child
            //find the predecessor in recursion and reorder left tree
            else if (root.right==null && root.left!=null){
                //get value from predecessor to set for the node in order to delete it
                root.val = predecessor(root);
                //recurse left subtree to reorder predecessors
                root.left = deleteNode(root.left, root.val);
            }
            //case 4: node has both right and left nodes
            //in this case, right node gets preference and is handled in case 2 so no need to explicitely define this case
        }
        return root;
    }

    //successor = lowest on the right after current node
    //go right once, then select leftmost
    public int successor(TreeNode node){
        node = node.right;
        while(node.left!=null)
            node = node.left;
        return node.val;
    }

    //predecessor = hightest on the left before current node
    //go left once, then select rightmost
    public int predecessor(TreeNode node){
        node = node.left;
        while(node.right!=null)
            node = node.right;
        return node.val;
    }

}
